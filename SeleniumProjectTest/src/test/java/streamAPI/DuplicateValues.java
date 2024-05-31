package streamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateValues {
	public static void main(String[] args) {
		
		List<Integer> ll = Arrays.asList(10,3,43,223,54,55,44,33,55,66,77,55,44,66,55);
		Set<Integer> set = new HashSet();
		ll.stream().filter(x ->set.add(x)).collect(Collectors.toSet()).forEach(y->System.out.println(y));
	}

}
