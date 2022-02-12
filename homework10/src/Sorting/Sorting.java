package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
public class Sorting {
    //ð������  
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    for(int k=0;k< array.length; k++)
              	   {
                    	System.out.print(" "+array[k]);
                     	
              	   }
                    System.out.println();
                }
        return array;
    }
   
	//ѡ������
//    public static int[] selectionSort(int[] array) {
//        if (array.length == 0)
//            return array;
//        for (index[j]) //�ҵ���С����
//                    minIndex = j; //����С������������
//            }
//            int temp = array[minIndex];
//            array[minIndex] = array[i];
//            array[i] = temp;
//        }
//        return array;
//    }
    // ��������
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
    //ϣ������
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
    /**
     * �鲢����
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * �鲢���򡪡�����������õ������ϳ�һ����������
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
    /**
     * �������򷽷�
     */
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
     * ���������㷨����partition

     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
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
     * ��������������Ԫ��

     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  //����ȫ�ֱ��������ڼ�¼����array�ĳ��ȣ�
    static int len;
        /**
         * �������㷨
         *
         * @param array
         * @return
         */
        public static int[] HeapSort(int[] array) {
            len = array.length;
            if (len < 1) return array;
            //1.����һ������
            buildMaxHeap(array);
            //2.ѭ��������λ�����ֵ����ĩλ������Ȼ�������µ�������
            while (len > 0) {
                swap(array, 0, len - 1);
                len--;
                adjustHeap(array, 0);
            }
            return array;
        }
        /**
         * ��������
         *
         * @param array
         */
        public static void buildMaxHeap(int[] array) {
            //�����һ����Ҷ�ӽڵ㿪ʼ���Ϲ�������
            for (int i = (len/2 - 1); i >= 0; i--) { //��л @���ҷ���� ���ѵ����ѣ��˴�Ӧ��Ϊ i = (len/2 - 1) 
                adjustHeap(array, i);
            }
        }
        /**
         * ����ʹ֮��Ϊ����
         *
         * @param array
         * @param i
         */
        public static void adjustHeap(int[] array, int i) {
            int maxIndex = i;
            //������������������������ڸ��ڵ㣬�����ָ��ָ��������
            if (i * 2 < len && array[i * 2] > array[maxIndex])
                maxIndex = i * 2;
            //������������������������ڸ��ڵ㣬�����ָ��ָ��������
            if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
                maxIndex = i * 2 + 1;
            //������ڵ㲻�����ֵ���򽫸��ڵ������ֵ���������ҵݹ�����븸�ڵ㽻����λ�á�
            if (maxIndex != i) {
                swap(array, maxIndex, i);
                adjustHeap(array, maxIndex);
            }
        }
        /**
         * ��������
         */
        public static int[] CountingSort(int[] array) {
            if (array.length == 0) return array;
            int bias, min = array[0], max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max)
                    max = array[i];
                if (array[i] < min)
                    min = array[i];
            }
            bias = 0 - min;
            int[] bucket = new int[max - min + 1];
            Arrays.fill(bucket, 0);
            for (int i = 0; i < array.length; i++) {
                bucket[array[i] + bias]++;
            }
            int index = 0, i = 0;
            while (index < array.length) {
                if (bucket[i] != 0) {
                    array[index] = i - bias;
                    bucket[i]--;
                    index++;
                } else
                    i++;
            }
            return array;
        }
        /**
         * Ͱ����
         */
        public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
            if (array == null || array.size() < 2)
                return array;
            int max = array.get(0), min = array.get(0);
            // �ҵ����ֵ��Сֵ
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > max)
                    max = array.get(i);
                if (array.get(i) < min)
                    min = array.get(i);
            }
            int bucketCount = (max - min) / bucketSize + 1;
            ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
            ArrayList<Integer> resultArr = new ArrayList<>();
            for (int i = 0; i < bucketCount; i++) {
                bucketArr.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < array.size(); i++) {
                bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
            }
            for (int i = 0; i < bucketCount; i++) {
                if (bucketSize == 1) { // ������������������ظ�����ʱ  ��л @������Ȼ�Ƿ� ����ָ������
                    for (int j = 0; j < bucketArr.get(i).size(); j++)
                        resultArr.add(bucketArr.get(i).get(j));
                } else {
                    if (bucketCount == 1)
                        bucketSize--;
                    ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                    for (int j = 0; j < temp.size(); j++)
                        resultArr.add(temp.get(j));
                }
            }
            return resultArr;
        }
        /**
         * ��������
         */
        public static int[] RadixSort(int[] array) {
            if (array == null || array.length < 2)
                return array;
            // 1.������������λ����
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                max = Math.max(max, array[i]);
            }
            int maxDigit = 0;
            while (max != 0) {
                max /= 10;
                maxDigit++;
            }
            int mod = 10, div = 1;
            ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 10; i++)
                bucketList.add(new ArrayList<Integer>());
            for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
                for (int j = 0; j < array.length; j++) {
                    int num = (array[j] % mod) / div;
                    bucketList.get(num).add(array[j]);
                }
                int index = 0;
                for (int j = 0; j < bucketList.size(); j++) {
                    for (int k = 0; k < bucketList.get(j).size(); k++)
                        array[index++] = bucketList.get(j).get(k);
                    bucketList.get(j).clear();
                }
            }
            return array;
        }
        public static void display(int[] array) {
        	for(int i=0;i<array.length;i++) {
        		System.out.print(array[i]+" ");
        	}
        	System.out.println();
        }
        public static void main(String[] args) {
        	int[] array= {25,30,11,7,22,16,18,33,40,45};
        	Sorting s1=new Sorting();
        	System.out.println("ԭ����:");
        	s1.display(array);
        	s1.bubbleSort(array);
        	System.out.println("ð������:");
        	s1.display(array);
        	Sorting s2=new Sorting();
//        	s2.selectionSort(array);
        	System.out.println("ѡ������:");
        	s2.display(array);
        	Sorting s3=new Sorting();
        	s3.insertionSort(array);
        	System.out.println("��������:");
        	s3.display(array);
        	Sorting s4=new Sorting();
        	s4.ShellSort(array);
        	System.out.println("ϣ������:");
        	s4.display(array);
        	Sorting s5=new Sorting();
        	s5.MergeSort(array);
        	System.out.println("�鲢����:");
        	s5.display(array);
        	Sorting s6=new Sorting();
        	s6.CountingSort(array);
        	System.out.println("��������:");
        	s6.display(array);
        	Sorting s7=new Sorting();
        	s7.HeapSort(array);
        	System.out.println("������:");
        	s7.display(array);
        	Sorting s8=new Sorting();
        	System.out.println("��������:");
        	s8.RadixSort(array);
        	s8.display(array);
        }
}
