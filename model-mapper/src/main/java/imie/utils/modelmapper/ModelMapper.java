package imie.utils.modelmapper;

import java.beans.Expression;
import java.beans.Statement;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import imie.utils.modelmapper.annotations.Convert;
import imie.utils.modelmapper.converters.Converter;
import imie.utils.modelmapper.core.MappingCall;
import imie.utils.modelmapper.annotations.Ignore;
import imie.utils.modelmapper.annotations.Mapping;
import imie.utils.modelmapper.converters.RegisterConverter;
import imie.utils.modelmapper.core.MappingException;
import imie.utils.modelmapper.core.MappingStack;

/**
 * usage: ModelMapper mapper = new ModelMapper(source); result =
 * (<TargetClassType>)mapper.convert() -> throws Exception
 * 
 * @author Fabien LH
 * @version 0.1
 * @license MIT
 *
 */
public class ModelMapper {

	/**
	 * Logger instance
	 */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ModelMapper.class);

	/**
	 * Reference to the root class with which Mapper is called
	 */
	private Object rootSource;

	/**
	 * Call stack for mapped class
	 */
	private MappingStack callStack;

	/**
	 * Current nested depth
	 */
	private int depth;

	private int order;

	/**
	 * Build a new ModelMapper
	 * 
	 * @param source
	 *            The object to map
	 */
	public ModelMapper(Object source) {
		this.rootSource = source;
	}

	/**
	 * Perform the conversion and return the converted object
	 * 
	 * @return An instance of the target class (value of @Mapping{target})
	 * @throws Exception
	 *             An error during mapping has occurred
	 */
	public Object convert() throws MappingException {
		callStack = new MappingStack();
		depth = 0;
		order = 0;

		return convert(rootSource);
	}

	/**
	 * Internal conversion method, which can be called recursively, each time a
	 * mappable field is found in root source object.
	 * 
	 * ModelMapper provide a cyclic mapping protection. Assuming that you have a
	 * Person and a House class, linking each other with a many to many relation
	 * (Person has House[] field and House has Person[] field), both mapped
	 * (both classes declare a @Mapping annotation) to target classes (PersonDto
	 * and HouseDto, for example),
	 * 
	 * the convert() method call hierarchy will probably look like this : Person
	 * > House > Person > House > ... ModelMapper will detect this loop and
	 * break it, like this : Person > House > [X] Person so person instance will
	 * be mapped all the house instances in the house[] field of person will be
	 * mapped but the person instances in the person[] field of house will NOT
	 * BE mapped ! see units tests specifications for an example of working
	 * 
	 * @param source
	 *            The object to map
	 * @return An instance of the target class (value of @Mapping{target})
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws Exception
	 *             An error during mapping has occurred
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object convert(Object source) throws MappingException, IllegalArgumentException {

		// The source object's class
		Class<?> sourceClass = source.getClass();
		callStack.put(++order, new MappingCall(sourceClass, ++depth));

		// Find a possible mapping annotation on the source class
		Mapping mapping = findAnnotation(sourceClass, Mapping.class);

		// Source object's class must declare a @Mapping annotation
		if (mapping == null) {
			throw new IllegalArgumentException("The source class must define @Mapping annotation with target value");
		}

		// Get the target object's class from the @Mapping annotation
		Class<?> targetClass = mapping.target();

		// Instanciate the target object
		Object target = null;
		try {
			target = targetClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new MappingException("Unable to instanciate target object : " + e.getMessage());
		}

		// Get the source object fields
		Field[] sourceFields = sourceClass.getDeclaredFields();

		// For each source fields
		for (Field sourceField : sourceFields) {
			// Find a possible ignore annotation on the current source field
			Ignore ignore = findAnnotation(sourceField, Ignore.class);

			// If the current field is not ignored
			if (ignore == null) {
				// Get the current field class
				Class<?> fieldClass = sourceField.getType();

				// Make the current source field accessible
				sourceField.setAccessible(true);

				// Retrieve the source field getter on the source object
				Method getter = findGetter(sourceField, sourceClass);
				if (getter == null)
					continue;

				// Getting the source field value
				Object sourceValue = getValueFromGetter(source, getter);

				// [Case: The field is an array]
				if (sourceField.getType().isArray()) {
					// The class of type contained by the array
					Class<?> arrayItemClass = sourceField.getType().getComponentType();

					// Checking if the array item type is mapped
					Mapping arrayItemMapping = findAnnotation(arrayItemClass, Mapping.class);

					// Getting the array value
					Object sourceItemArray = getValueFromGetter(source, getter);
					if (sourceItemArray == null) {
						throw new MappingException("Unable to get the value of the source field {} in class {}",
								sourceField, sourceClass);
					}

					if (arrayItemMapping != null) {

						if (callStack.containsClass(arrayItemClass)) {
							// TODO Return Circular constant value
							trackCircularCall(sourceClass, sourceField);
							continue;
						}

						// Instanciate a target array for the target object
						// corresponding field
						Object targetItemArray = Array.newInstance(arrayItemMapping.target(),
								((Object[]) sourceValue).length);

						// Iterate over the source object field array
						for (int i = 0, len = Array.getLength(sourceItemArray); i < len; i++) {
							// Getting the source element
							Object element = Array.get(sourceItemArray, i);

							// Process to mapping of each array element
							Array.set(targetItemArray, i, convert(element));
						}

						// Mapping the target object value
						mapTargetValue(sourceClass, source, sourceField, targetClass, target,
								targetItemArray.getClass(), targetItemArray);
					} else {
						mapTargetValue(sourceClass, source, sourceField, targetClass, target, fieldClass,
								sourceItemArray);
					}
					// [Case: The field is a collection]
				} else if (isCollection(sourceField.getType())) {

					// The class of type contained by the iterable
					ParameterizedType collectionItemType = (ParameterizedType) sourceField.getGenericType();
					Class<?> collectionItemClass = (Class<?>) collectionItemType.getActualTypeArguments()[0];

					// Checking if the array item type is mapped
					Mapping collectionItemMapping = findAnnotation(collectionItemClass, Mapping.class);

					// Getting the collection value
					// Object sourceItemCollection = sourceField.get(source);

					// Getting the collection value
					Object sourceItemCollection = getValueFromGetter(source, getter);
					if (sourceItemCollection == null) {
						throw new MappingException("Unable to get the value of the source field {} in class {}",
								sourceField, sourceClass);
					}

					if (collectionItemMapping != null) {

						// if (collectionItemClass.equals(rootClass) &&
						// !sourceClass.equals(rootClass)) {
						if (callStack.containsClass(collectionItemClass)) {
							/*
							 * logger.
							 * warn("Cyclic call detected with {} on field <{}> {} (order={}, depth={})"
							 * , sourceClass.getSimpleName(),
							 * sourceField.getType(), sourceField.getName(),
							 * order, depth);
							 */
							trackCircularCall(sourceClass, sourceField);
							continue;
						}

						// Getting the collection type
						Class<?> collectionType = sourceField.getType();

						// Checking if collection type is abstract or interface
						if (isAbstractType(collectionType))
							// If it is the case, finding the closest
							// implementation in java.util hierarchy
							collectionType = getClosestCollectionImpl(collectionType);

						// Ignoring the field if no implementation could be
						// found
						if (collectionType == null) {
							logger.warn(
									"Could not find implementation for List abstract type {}. Ignoring the field {}...",
									sourceField.getType(), sourceField.getName());
							continue;
						}

						// Instanciate a target collection for the target object
						// corresponding field
						Object targetItemCollection = null;
						try {
							targetItemCollection = collectionType.newInstance();
						} catch (IllegalAccessException | InstantiationException e) {
							throw new MappingException("Unable to instanciate the type {}", collectionType);
						}

						// Iterate over the source object field array
						for (Iterator it = ((Collection) sourceItemCollection).iterator(); it.hasNext();) {
							// Getting the source element
							Object element = it.next();

							// Process to mapping of each collection element
							((Collection) targetItemCollection).add(convert(element));
						}

						// Mapping the target object value
						mapTargetValue(sourceClass, source, sourceField, targetClass, target, sourceField.getType(),
								targetItemCollection);
					} else {

						mapTargetValue(sourceClass, source, sourceField, targetClass, target, fieldClass,
								sourceItemCollection);
					}
					// [Case: field is a map]
					/*
					 * } else if () { // TODO Not implemented yet! }
					 */

					// [Case: field is a simple object]
				} else {
					Mapping fieldMapping = findAnnotation(sourceField.getType(), Mapping.class);

					if ((fieldMapping != null) && !sourceField.getType().isPrimitive()) {
						// Cyclic call protection
						if (callStack.containsClass(sourceField.getType())) {
							/*
							 * logger.
							 * warn("Cyclic call detected with {} on field <{}> {} (order={}, depth={})"
							 * , sourceClass.getSimpleName(),
							 * sourceField.getType(), sourceField.getName(),
							 * order, depth);
							 */
							trackCircularCall(sourceClass, sourceField);
							continue;
						}

						mapTargetValue(sourceClass, source, sourceField, targetClass, target, fieldMapping.target(),
								convert(sourceValue));

					} else {
						Convert fieldConvert = findAnnotation(sourceField, Convert.class);

						if (fieldConvert != null) {
							Class<?> converterClass = fieldConvert.using();
							RegisterConverter fieldConverter = findAnnotation(converterClass, RegisterConverter.class);

							if (fieldConverter != null) {
								Class<?> converterReturns = fieldConverter.returns();
								Object converter = null;
								try {
									converter = converterClass.newInstance();
								} catch (IllegalAccessException | InstantiationException e) {
									logger.warn("Unable to instanciate converter {} for field {} : {}", converterClass,
											sourceField.getName(), e.getMessage());
									continue;
								}

								Object targetValue = ((Converter) converter).convert(sourceValue);
								mapTargetValue(sourceClass, source, sourceField, targetClass, target, converterReturns,
										targetValue);
							}

						} else {
							mapTargetValue(sourceClass, source, sourceField, targetClass, target, fieldClass,
									sourceValue);
						}
					}
				}
			}
		}

		// Decremeting depth counter at end of nested convert() execution
		if (--depth == 0) {
			getCallStack();
		}

		// Returns the target object
		return target;
	}

	private Object getValueFromGetter(Object source, Method getter) {
		Object value = null;
		Expression expr = new Expression(source, getter.getName(), null);

		try {
			value = expr.getValue();
		} catch (Exception e) {
			logger.debug("Unable to get value from the getter {}", getter.getName());
		}

		return value;
	}

	/**
	 * Map a value on the target field of the target instance of the target
	 * class, from the source field
	 * 
	 * @param sourceClass
	 *            The source object class
	 * @param sourceObject
	 *            The source object instance
	 * @param sourceField
	 * @param targetClass
	 * @param targetObject
	 * @param targetFieldClass
	 * @param targetValue
	 */
	private void mapTargetValue(Class<?> sourceClass, Object sourceObject, Field sourceField, Class<?> targetClass,
			Object targetObject, Class<?> targetFieldClass, Object targetValue) {

		Field targetField = null;
		Method setter = null;

		try {
			targetField = targetClass.getDeclaredField(sourceField.getName());
			assert (targetField != null);

			setter = targetClass.getDeclaredMethod("set" + StringUtils.capitalize(sourceField.getName()),
					targetFieldClass);
			assert (setter != null);

			Statement exec = new Statement(targetObject, setter.getName(), new Object[] { targetValue });
			exec.execute();

		} catch (NoSuchFieldException | NoSuchMethodException | SecurityException e) {
			logger.debug("Could not map value to the target object : target class <{}> : {}", targetClass,
					e.getMessage());

		} catch (Exception e) {
		}

	}

	private Method findGetter(Field field, Class<?> sourceClass) {
		Method getter = null;
		try {
			getter = sourceClass.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()));
		} catch (NoSuchMethodException | SecurityException e) {
			logger.debug("Unable to find getter for field {} in {}", field.getName(), sourceClass);
		}
		return getter;
	}

	@SuppressWarnings("unchecked")
	private static <A extends Annotation> A findAnnotation(AnnotatedElement annotatedElement, Class<A> annotationType) {
		if (annotatedElement == null) {
			throw new IllegalArgumentException("annotatedElement must be not null");
		}

		if (annotationType == null) {
			return null;
		}

		Annotation[] annotations = annotatedElement.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType() == annotationType) {
				return (A) annotation;
			}
		}

		return null;
	}

	private void getCallStack() {
		logger.debug("Final mapping hierarchy stack for {} class.", rootSource.getClass().getSimpleName());
		logger.debug("X indicates blocked cyclic calls, target value will be null)");
		
		String line = "";

		for (Entry<Integer, MappingCall> callEntry : callStack.entrySet()) {
			int order = callEntry.getKey();
			MappingCall call = callEntry.getValue();
			
			line = String.format("%d: %s+%s", order, StringUtils.repeat("-", (call.getDepth() - 1) * 3),
					call.getCallClass().getSimpleName());

			if (call.getProblematicField() != null) {
				line += String.format(" --> [X] %s", call.getProblematicField().getType().getSimpleName());
			}
			
			logger.debug("{}", line);
		}
	}

	private void trackCircularCall(Class<?> problematicClass, Field problematicField) {
		logger.warn("Cyclic call detected with {} on field <{}> {} (order={}, depth={})",
				problematicClass.getSimpleName(), problematicField.getType().getSimpleName(),
				problematicField.getName(), order, depth);

		int last = callStack.lastKey();
		MappingCall lastCall = callStack.get(last);

		lastCall.setProblematicField(problematicField);
	}

	public static boolean isAbstractType(Class<?> testClass) {
		return testClass.isInterface() || Modifier.isAbstract(testClass.getModifiers());
	}

	public static Class<?> getClosestCollectionImpl(Class<?> collectClass) {
		if (!isAbstractType(collectClass))
			return collectClass;

		Set<Class<?>> hierarchy = computeClassHierarchy(collectClass);

		if (hierarchy.contains(List.class))
			return ArrayList.class;

		if (hierarchy.contains(Queue.class))
			return PriorityQueue.class;

		if (hierarchy.contains(Set.class))
			return HashSet.class;

		if (hierarchy.contains(Map.class))
			return HashMap.class;

		return null;
	}

	private static boolean isCollection(Class<?> testClass) {
		return computeClassHierarchy(testClass).contains(Collection.class);
	}

	private static Set<Class<?>> computeClassHierarchy(Class<?> baseClass) {
		Set<Class<?>> hierarchy = new HashSet<>();

		Class<?> pointerClass = baseClass;
		do {
			hierarchy.add(pointerClass);

			Stream<Class<?>> interfaces = Arrays.stream(pointerClass.getInterfaces());
			interfaces.forEach(iface -> hierarchy.addAll(computeClassHierarchy(iface)));

			hierarchy.addAll(Arrays.asList(pointerClass.getInterfaces()));
		} while ((pointerClass = pointerClass.getSuperclass()) != null);

		return hierarchy;
	}
}
