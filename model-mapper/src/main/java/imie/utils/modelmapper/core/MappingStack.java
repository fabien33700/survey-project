package imie.utils.modelmapper.core;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class MappingStack extends TreeMap<Integer, MappingCall> {

	public boolean containsClass(Class<?> testClass) {
		for (Iterator<Map.Entry<Integer, MappingCall>> it = this.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, MappingCall> current = it.next();
			if (current.getValue().getCallClass().equals(testClass))
				return true;
		}
		return false;
	}
	
}
