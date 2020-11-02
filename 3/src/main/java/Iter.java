import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Iter{

	public static <E> Iterable<E> filter(Iterable<E> toFilter, Predicate<? super E> addToResultIfTrue){

		List<E> result = new LinkedList<>();
		for (E i: toFilter){
			if (addToResultIfTrue.test(i)) result.add(i);
		}
		return result;
	} 

	public static <F, E> Iterable<E> transform(Iterable<F> toIterate, Function<? super F, ? extends E> convert){

		List<E>	result  = new LinkedList<>();
		for (F i: toIterate) {
			result.add(convert.apply(i));

		}
		return result;

	}
}
