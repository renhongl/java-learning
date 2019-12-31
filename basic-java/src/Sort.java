import java.util.ArrayList;
import java.util.List;

public class Sort {
	
	/**
	 * Internal function for heap sort
	 * @param list
	 * @return
	 */
	private List<Integer> createHeap(List<Integer> list) {
		List<Integer> heap = new ArrayList<Integer>(list);
		for (int i = 0; i < Math.floor(heap.size() / 2); i++) {
			int root = i;
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left < heap.size() && heap.get(left) < heap.get(root)) {
				int temp = heap.get(left);
				heap.set(left, heap.get(root));
				heap.set(root, temp);
			}
			if (right < heap.size() && heap.get(right) < heap.get(root)) {
				int temp = heap.get(right);
				heap.set(right, heap.get(root));
				heap.set(root, temp);
			}
		}
		return heap;
	}
	
	/**
	 * Heap Sort
	 * @time O(n * log2n)
	 * @param list
	 * @return
	 */
	public List<Integer> heapSort(List<Integer> list) {
		List<Integer> ret = new ArrayList<Integer>();
		while(list.size() > 0) {
			List<Integer> heap = createHeap(list);
			ret.add(heap.get(0));
			list.remove(heap.get(0));
		}
		return ret;
	}
	
	/**
	 * Insert Sort
	 * @time O(n2)
	 * @param list
	 * @return
	 */
	public List<Integer> insertSort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			int j = i;
			while(j > 0 && list.get(j) < list.get(j-1)) {
				int temp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1, temp);
				j--;
			}
		}
		return list;
	}
	
	/**
	 * Internal function for merge sort
	 * @param left
	 * @param right
	 * @return
	 */
	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> ret = new ArrayList<Integer>();
		while(left.size() > 0 && right.size() > 0) {
			if (left.get(0) < right.get(0)) {
				ret.add(left.get(0));
				left.remove(0);
			} else {
				ret.add(right.get(0));
				right.remove(0);
			}
		}
		ret.addAll(left);
		ret.addAll(right);
		return ret;
	}
	
	/**
	 * Merge Sort
	 * @time O(n * log2n)
	 * @param list
	 * @return
	 */
	public List<Integer> mergeSort(List<Integer> list) {
		if (list.size() <=1 ) {
			return list;
		}
		int middleIndex = (int)Math.floor(list.size() / 2);
		List<Integer> left = new ArrayList<Integer>(list.subList(0, middleIndex));
		List<Integer> right = new ArrayList<Integer>(list.subList(middleIndex, list.size()));
		return merge(mergeSort(left), mergeSort(right));
	}
	
	/**
	 * Select Sort
	 * @time O(n2)
	 * @param list
	 * @return
	 */
	public List<Integer> selectSort(List<Integer> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(minIndex)) {
					minIndex = j;
				}
			}
			int temp = list.get(minIndex);
			list.set(minIndex, list.get(i));
			list.set(i, temp);
		}
		return list;
	}
	
	/**
	 * Bubble Sort
	 * @time O(n2)
	 * @param list
	 * @return
	 */
	public List<Integer> bubbleSort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - i - 1; j++) {
				if (list.get(j) > list.get(j+1)) {
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		return list;
	}
	
	/**
	 * Quick sort
	 * @time O(n * log2n)
	 * @param list
	 * @return
	 */
	public List<Integer> quickSort(List<Integer> list) {
		if (list.size() <= 1) {
			return list;
		}
		int middle = list.get(0);
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < middle) {
				left.add(list.get(i));
			} else {
				right.add(list.get(i));
			}
		}
		
		List<Integer> leftResult = new ArrayList<Integer>(quickSort(left));
		List<Integer> rightResult = new ArrayList<Integer>(quickSort(right));
		
		leftResult.add(middle);
		leftResult.addAll(rightResult);
		return leftResult;
	}
}
