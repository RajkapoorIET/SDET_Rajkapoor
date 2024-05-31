package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SumOfGivenArrays {
	
	public static void main(String[] args) {
		
		List<Integer> ll = Arrays.asList(22,43,655,3,4,23,34);
		
		System.out.println(ll.stream().reduce((a,b) -> a+b).get());
		//System.out.println(sum.get());
		
		System.out.println(ll.stream().collect(Collectors.summingInt(e->e)));
		System.out.println(ll.stream().mapToInt(e->e).average().getAsDouble());
		//System.out.println(ll.stream().map(e->e*e).map(e->e.compare(0, 0));
	}

}
