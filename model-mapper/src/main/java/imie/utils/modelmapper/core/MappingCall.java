package imie.utils.modelmapper.core;

import java.lang.reflect.Field;

public class MappingCall {
	
	private Class<?> callClass;
	
	private Field problematicField;
	
	private int depth;

	public MappingCall(Class<?> callClass, int depth) {
		this.callClass = callClass;
		this.depth = depth;
	}

	public Class<?> getCallClass() {
		return callClass;
	}

	public void setCallClass(Class<?> callClass) {
		this.callClass = callClass;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Field getProblematicField() {
		return problematicField;
	}

	public void setProblematicField(Field problematicField) {
		this.problematicField = problematicField;
	}
}
