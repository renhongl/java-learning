import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P1 {

	public static void main(String[] args) {
		
		// Sort test
		Sort sort = new Sort();
		List<Integer> a1 = new ArrayList<Integer>();
		a1.add(54);
		a1.add(12);
		a1.add(17);
		a1.add(76);
		a1.add(82);
		a1.add(93);
		List<Integer> t1 = new ArrayList<Integer>(a1);
		List<Integer> t2 = new ArrayList<Integer>(a1);
		List<Integer> t3 = new ArrayList<Integer>(a1);
		List<Integer> t4 = new ArrayList<Integer>(a1);
		List<Integer> t5 = new ArrayList<Integer>(a1);
		List<Integer> t6 = new ArrayList<Integer>(a1);
		
		System.out.print("Bubble Sort: " + t1 + "--->");
		System.out.println(sort.bubbleSort(t1));
		
		System.out.print("Quick Sort: " + t2 + "--->");
		System.out.println(sort.quickSort(t2));
		
		System.out.print("Select Sort: " + t3 + "--->");
		System.out.println(sort.selectSort(t3));
		
		System.out.print("Merge Sort: " + t4 + "--->");
		System.out.println(sort.mergeSort(t4));
		
		System.out.print("Insert Sort: " + t5 + "--->");
		System.out.println(sort.insertSort(t5));
		
		System.out.print("Heap Sort:" + t6 + "--->");
		System.out.println(sort.heapSort(t6));
		
	}
	
	public static void printArr(String title, List<Integer> list) {
		System.out.println("\n" + title);
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + ", ");
		}
		System.out.println("\n");
	}

}
