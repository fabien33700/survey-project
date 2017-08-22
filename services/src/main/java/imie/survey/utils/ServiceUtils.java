package imie.survey.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ServiceUtils {
	
	public static <E> List<E> iterableToList(Iterable<E> iter) {
		return StreamSupport
				.stream(iter.spliterator(), false)
				.collect(Collectors.toList());
	}

}
