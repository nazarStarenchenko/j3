import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;



public class IterTest{

	private<T> void compare(List<T> first, List<T> second) {
	    assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
	}

	@Test
	public void TestFilterForInt() {
		Predicate<Integer> lowerThenThree = integer -> integer < 3;

		List<Integer> resultToExpect = Arrays.asList(1,2);
		List<Integer> testList = Arrays.asList(1,2,3,4,5);

		List<Integer> actualResult = (List<Integer>) Iter.filter((List<Integer>) testList, lowerThenThree);
		compare(actualResult, resultToExpect);
	}
	
	@Test
	public void TestFilterForFloat() {
		Predicate<Float> lowerThenThree = f -> f < 3.0f;

		List<Float> resultToExpect = Arrays.asList(1.0f,2.0f);
		List<Float> testList = Arrays.asList(1.0f,2.0f,3.0f,4.0f,5.0f);

		List<Float> actualResult = (List<Float>) Iter.filter((List<Float>) testList, lowerThenThree);
		compare(actualResult, resultToExpect);
	}

	@Test
	public void TestFilterForStr() {
		Predicate<String> lengthEqualsThree = s -> s.length() == 3;

		List<String> resultToExpect = Arrays.asList("abc", "adc");
		List<String> testList = Arrays.asList("abc", "adc", "boolean", "string");

		List<String> actualResult = (List<String>) Iter.filter((List<String>) testList, lengthEqualsThree);
		compare(actualResult, resultToExpect);
	}
	
	@Test
	public void TestFilterForBool() {
		Predicate<Boolean> isTrue = b -> b == true;

		List<Boolean> resultToExpect = Arrays.asList(true);
		List<Boolean> testList = Arrays.asList(true,false);

		List<Boolean> actualResult = (List<Boolean>) Iter.filter((List<Boolean>) testList, isTrue);
		compare(actualResult, resultToExpect);
	}

	@Test
	public void TestTransformForInt() {
		Function<Integer, Integer> multiplyByThree = integer -> integer * 3 ;

		List<Integer> resultToExpect = Arrays.asList(3,6,9);
		List<Integer> testList = Arrays.asList(1,2,3);

		List<Integer> actualResult = (List<Integer>) Iter.transform((List<Integer>) testList, multiplyByThree);
		compare(actualResult, resultToExpect);
	}
	
	@Test
	public void TestTransformForFloat() {
		Function<Float, Float> multiplyByThree = f -> f *  3.0f;

		List<Float> resultToExpect = Arrays.asList(3.0f,6.0f, 9.0f);
		List<Float> testList = Arrays.asList(1.0f,2.0f,3.0f);

		List<Float> actualResult = (List<Float>) Iter.transform((List<Float>) testList, multiplyByThree);
		for (float i: actualResult){
			System.out.println(i);
		}
		compare(actualResult, resultToExpect);
	}

	@Test
	public void TestTransformForStr() {
		Function<String, String> concatinateThree = s -> s + "3";

		List<String> resultToExpect = Arrays.asList("abc3", "adc3"); 
		List<String> testList = Arrays.asList("abc", "adc");

		List<String> actualResult = (List<String>) Iter.transform((List<String>) testList, concatinateThree);
		compare(actualResult, resultToExpect);
	}
	
	@Test
	public void TestTransformForBool() {
		Function<Boolean, Boolean> isTrue = b -> b = true;

		List<Boolean> resultToExpect = Arrays.asList(true, true);
		List<Boolean> testList = Arrays.asList(true,false);

		List<Boolean> actualResult = (List<Boolean>) Iter.transform((List<Boolean>) testList, isTrue);
		compare(actualResult, resultToExpect);
	}
}
