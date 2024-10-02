package lab06;

public class Tester {
	
	public static void main(String [] args) {
		SortedString zeb = new SortedString("zebra");
		System.out.println(zeb.toString());
		
		SortedString Zeb = new SortedString("Zebra");
		System.out.println(Zeb.toString());
		
		SortedString joy = new SortedString("joy");
		SortedString ski = new SortedString("ski");
		SortedString bel = new SortedString("below");
		SortedString Elb = new SortedString("Elbow");
		
		System.out.println("joy.compareTo(ski): " + joy.compareTo(ski));
		// expect positive value
		System.out.println("Joy = " + joy.getSorted() + " Ski = " + ski.getSorted());
		System.out.println("below.comapreTo(Elbow): " + bel.compareTo(Elb));
		//expect 0
		System.out.println("zebra.compareTo(joy): " + zeb.compareTo(joy));
		
		System.out.println("----------------------------------------");
		
		SortedString empty = new SortedString("");
		SortedString elb = new SortedString("elbow");
		System.out.println("AnagramsUtil.areAnagrams(empty, bel): " + AnagramUtil.areAnagrams(empty,  bel));
		System.out.println("AnagramsUtil.areAnagrams(bel, bel): " + AnagramUtil.areAnagrams(bel,  bel));
		System.out.println("AnagramsUtil.areAnagrams(bel, Elb): " + AnagramUtil.areAnagrams(bel,  Elb));
		System.out.println("AnagramsUtil.areAnagrams(bel, joy): " + AnagramUtil.areAnagrams(bel,  joy));
		System.out.println("AnagramsUtil.areAnagrams(bel, elb): " + AnagramUtil.areAnagrams(bel,  elb));
		System.out.println("AnagramsUtil.areAnagrams(zeb, Zeb): " + AnagramUtil.areAnagrams(zeb,  Zeb));
		
		System.out.println("-------------------------------------------");
		
		InsertionSort<Integer> intIS = new InsertionSort<Integer>();
		Integer [] one = {1};
		Integer [] two = {6, 2};
		Integer [] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer [] random = {5, 3, 7, 1, 8, 2, 9, 6, 4};
		
		Integer [] intArr = intIS.sort(one);
		String intArrStr = "[";
		for(Integer i: intArr) {
			intArrStr += i + " ";
		}
		intArrStr += "]";
		System.out.println("One Element: " + intArrStr);
		intArr = intIS.sort(two);
		intArrStr = "[";
		for(Integer i: intArr) {
			intArrStr += i + " ";
		}
		intArrStr += "]";
		System.out.println("Two Elements: " + intArrStr);
		intArr = intIS.sort(sorted);
		intArrStr = "[";
		for(Integer i: intArr) {
			intArrStr += i + " ";
		}
		intArrStr += "]";
		System.out.println("Sorted Elements: " + intArrStr);
		intArr = intIS.sort(random);
		intArrStr = "[";
		for(Integer i: intArr) {
			intArrStr += i + " ";
		}
		intArrStr += "]";
		System.out.println("Random Elements: " + intArrStr);
		
		System.out.println("----------------------------------");
		
		InsertionSort<SortedString> ssIS = new InsertionSort<SortedString>();
		String [] strArr = {"joy", "ski", "fed", "cat"};
		SortedString [] sortStrArr = SortedString.toSortedString(strArr);
		
		SortedString [] sortedArr = ssIS.sort(sortStrArr);
		String ssArrStr = "[";
		for(SortedString ss: sortedArr) {
			ssArrStr += ss.getUnsorted() + " ";
		}
		ssArrStr += "]";
		System.out.println("Sorted SortedString []: " + ssArrStr);
		
		System.out.println("----------------------------------");
		
		Integer [] realRandom = new Integer [10];
		for (int i = 0; i<10; i++) {
			realRandom[i]= (int) (Math.random()*10000);
		}
		
		intIS.fit(realRandom);
		
		System.out.println("To sort 100000 elements it would take " + intIS.predict(10000) + " microseconds");
		
		System.out.println("--------------------------");
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		
		
		String fin = "[";
		for(int i = 0; i < s3.length; i++) {
			fin += s3[i] + " ";
		}
		fin += "]";
		System.out.println("getLargestAnagramGroup: " + fin);
		
		MergeSort<Integer> merge = new MergeSort<Integer>();
		Integer [] on = {1};
		Integer [] tw = {6, 2};
		Integer [] sorte = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer [] rando = {5, 3, 7, 1, 8, 2, 9, 6, 4};
		
		Integer [] merg = merge.sort(on);
		String mergStr = "[";
		for(Integer i: merg) {
			mergStr += i + " ";
		}
		mergStr += "]";
		
		System.out.println("On Element: " + mergStr);
		
		merg = merge.sort(tw);
		mergStr = "[";
		for(Integer i: merg) {
			mergStr += i + " ";
		}
		mergStr += "]";
		
		System.out.println("On Element: " + mergStr);
		
		merg = merge.sort(sorte);
		mergStr = "[";
		for(Integer i: merg) {
			mergStr += i + " ";
		}
		mergStr += "]";
		
		System.out.println("On Element: " + mergStr);
		
		merg = merge.sort(rando);
		mergStr = "[";
		for(Integer i: merg) {
			mergStr += i + " ";
		}
		mergStr += "]";
		
		System.out.println("On Element: " + mergStr);

		
		Integer [] realRan = new Integer [10];
		for (int i = 0; i<10; i++) {
			realRan[i]= (int) (Math.random()*10000);
		}
		
		merge.fit(realRan);
		
		System.out.println("To sort 100000 elements it would take " + merge.predict(10000) + " microseconds");
		
		
		//carets Caters caster crates Reacts recast traces
		
	}

}
