
public class qSort {
	public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
    */
    public static int partition(int[] array, int start, int end) {
    	int pivot = start;
        //int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }
    /**
     * 交换数组内两个元素
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void display(int[] array) {
    	for(int i=0;i<array.length;i++) {
    		System.out.print(array[i]+" ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
		int[] li= {8,4,3,7,1,5,6,2};
		System.out.println("原数组：");
		display(li);
		QuickSort(li,0,li.length-1);
		System.out.println("快排后：");
		display(li);
	}
}
