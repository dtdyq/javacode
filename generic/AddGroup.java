package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddGroup {
	
	public static void main(String[] args) {
		Collection<Integer> collection =new ArrayList<Integer>();
		collection.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		Integer[] in={22,33,44,55};
		collection.addAll(Arrays.asList(in));
		Collections.addAll(collection, 66,77,88,99);
		List<Integer> list=Arrays.asList(12,23,34,45,56);
		collection.addAll(list);
		System.out.println(collection);
		for(Integer i:collection){
			System.out.println(i);
		}
	}

}
