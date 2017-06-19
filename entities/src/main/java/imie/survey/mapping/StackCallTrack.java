package imie.survey.mapping;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StackCallTrack {
	
	private Set<Integer> stack;

	public StackCallTrack() {
		this.stack = new HashSet<>();
	}
	
	public boolean add(int hashCode) {
		return stack.add(hashCode);
	}
	
	public void clear() {
		stack.clear();
	}
}
