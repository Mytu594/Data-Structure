import java.util.ArrayList;
import java.util.List;

public class sort {
	int num[] = new int[] {25,30,11,7,22,16,18,33,40,55};
	int len = num.length;
	//冒泡排序
	public void bubbleSort() {
		for(int i = 1 ; i < len ; i++) {//n-1趟
			int temp;
			for(int j = 0 ; j < len-1 ;j++) {
				if(num[j] > num[j+1]) {
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] =temp;
					for(int k=0;k< num.length; k++)
	              	{
	                   System.out.print(" "+num[k]);
	                }
	                System.out.println();
				}
			}
		}
	}
	//推排序
	int leng = num.length;
	List<Object> list = new ArrayList<Object>();
	public void heapSort() {
		for(int j = 0 ; j < leng ; j++) {
			for(int i = len/2-1 ; i >= 0; i--) {
				//创建堆
				siftSmall(i,len);
			}
			list.add(num[0]);
			num = remove(num,0);
			len--;
			for(Object n:list) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
	private static int[] remove(int[] arr,int num) {
		int[] tmp = new int[arr.length-1];
		int idx = 0;
		boolean hasRemove = false;
		for(int i=0 ; i<arr.length; i++) {
			if(!hasRemove&&i==num) {
				hasRemove =true;
				continue;
			}
			tmp[idx++] = arr[i];
		}
		return tmp;	
	}
	//建立最小堆
	public void siftSmall(int low,int high) {
		int i = low;//子树的根节点
		int j = 2*i + 1;//j为i的左孩子
		int temp = num[i];
		while(j < high) {//沿着较小值孩子节点向下筛选
			if(j < high - 1 && num[j] > num[j+1]) {
				j++;//记录比较，j为左右孩子的较小者
			}
			if(temp > num[j]){//若父节点较大
				num[i] = num[j];//孩子节点中较小者上移
				i = j;
				j = 2*i + 1;
			}
			else {
				j = high + 1;
			}
		}
		num[i] = temp;		
	}
	//直接选择排序
	public void selectSort() {
		int temp;
		for(int i = 0;i <len;i++) {
			int min = 1;
			for(int j = i + 1 ; j < len ; j++) {
				if(num[j] < num[min]) {
					min = j ;
				}
			}
			if(min != i) {
				temp = num[i];
				num[i] = num[min];
				num[min] = temp;
			}
			for(int k=0;k< num.length; k++)
	      	{
	           System.out.print(" "+num[k]);
	        }
	        System.out.println();
		}	
	}
	public void selectionSort(int[] a,int n) {
        if(n>a.length) {
            System.out.println("超出数组长度");
            System.exit(1);
        }
        for (int i = 1; i < n; i++) {    //i表示次数，共进行n-1次选择和交换
            int minIndex = i-1;            //用minIndex表示最小元素的下标
            for (int j = i; j < n; j++) {//找到当前排序区间中最小元素的下标
                if(a[minIndex]>a[j]) {//如果后面的元素小于当前最小元素，则用minIndex记录下后面最小元素的下标
                    minIndex = j;
                }
                
            }
            if(minIndex != i) {//如果minIndex==i,说明minIndex就是当前排序区间首位元素的下标，因此不用交换
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
                for(int k=0;k< a.length; k++)
              	{
                   System.out.print(" "+a[k]);
                }
                System.out.println();
            }
            
        }
        
    }
	//直接插入排序
	public void insertSort()//将比较后较大数放在后一位
	{
		for(int i = 1 ; i < len ; i++)
		{
			//准备插入的数
			int temp = num[i];
			int j = i-1;
			for(; j > 0 && temp < num[j] ; j--) {
				num[j+1] = num[j];
			}
			num[j+1] = temp; //将数组后一位数赋值，插入排序
			for(int k=0;k < num.length; k++)
	      	{
	           System.out.print(" "+num[k]);
	        }
	        System.out.println();
		}
	}
	public static void main(String[] args) {
		int num[] = new int[] {25,30,11,7,22,16,18,33,40,55};
		int len = num.length;
		sort s1=new sort();
//    	System.out.println("冒泡排序:");
//    	s1.bubbleSort();
//    	System.out.println("堆排序:");
//    	s1.heapSort();
//    	System.out.println("直接选择排序:");
//    	s1.selectionSort(num,len);
    	System.out.println("直接插入排序:");
    	s1.insertSort();
	}
}
