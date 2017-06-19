package imie.survey.mapping;

public interface Treatment<I, O> {
	O perform(I value);
}
