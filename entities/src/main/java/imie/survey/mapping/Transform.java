package imie.survey.mapping;

import java.util.function.Function;

public @interface Transform {
	@SuppressWarnings("rawtypes")
	Class<Function> value();
}
