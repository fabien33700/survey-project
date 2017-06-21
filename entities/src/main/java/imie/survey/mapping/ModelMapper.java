package imie.survey.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;

public class ModelMapper<S, T> {
	
	//@SuppressWarnings("rawtypes")
	//private List<MappingConverter> converters;

    private final View scope;

    private final Class<S> sourceClass;

    private final Class<T> targetClass;

    public ModelMapper(View scope, Class<S> sourceClass, Class<T> targetClass) {
        this.scope = scope;
        
        this.sourceClass = sourceClass;
        this.targetClass = targetClass;
        
        //this.converters = new ArrayList<>();
    }

    public View getScope() {
        return scope;
    }

    public Class<?> getSourceClass() {
        return sourceClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public T convert(S source) 
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	  
          T target = targetClass.newInstance();
          
          Method[] targetMethods = targetClass.getDeclaredMethods();

          for (Field f : sourceClass.getDeclaredFields()) {
              f.setAccessible(true);
              Method getter = null, setter = null;

              try {
                  getter = sourceClass.getDeclaredMethod("get" + ucFirst(f.getName()));
                  setter = targetClass.getDeclaredMethod("set" + ucFirst(f.getName()), f.getType());
              } catch (NoSuchMethodException | SecurityException e) { }

              if ((getter != null) && (setter != null)) {
            	  if (getter.getReturnType().equals(setter.getParameterTypes()[0])) {
            		  MapExclude exclude = AnnotationUtils.findAnnotation(f, MapExclude.class);
            		  boolean mustExclude = false;
            		  
            		  if (exclude != null) {
            			  if (exclude.views().length > 0) {
	            			  for (View view : exclude.views()) {
	        					  if (scope.equals(view)) {
	        						  mustExclude = true;
	        						  break;
	        					  }
	        				  }
            			  } else {
            				  mustExclude = true;
            			  }
            		  }
            			 
            				  
    				  if (!mustExclude) {
    					  setter.invoke(target, getter.invoke(source));
    				  }
            	  }
              }
          }

          return target;
    }

    private static String ucFirst(String str) {
        return str.substring(0, 1).toUpperCase() + 
        	   str.substring(1).toLowerCase();
    }

}