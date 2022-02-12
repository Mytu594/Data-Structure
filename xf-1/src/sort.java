import java.util.ArrayList;
import java.util.List;

public class sort {
	int num[] = new int[] {25,30,11,7,22,16,18,33,40,55};
	int len = num.length;
	//ð������
	public void bubbleSort() {
		for(int i = 1 ; i < len ; i++) {//n-1��
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
	//������
	int leng = num.length;
	List<Object> list = new ArrayList<Object>();
	public void heapSort() {
		for(int j = 0 ; j < leng ; j++) {
			for(int i = len/2-1 ; i >= 0; i--) {
				//������
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
	//������С��
	public void siftSmall(int low,int high) {
		int i = low;//�����ĸ��ڵ�
		int j = 2*i + 1;//jΪi������
		int temp = num[i];
		while(j < high) {//���Ž�Сֵ���ӽڵ�����ɸѡ
			if(j < high - 1 && num[j] > num[j+1]) {
				j++;//��¼�Ƚϣ�jΪ���Һ��ӵĽ�С��
			}
			if(temp > num[j]){//�����ڵ�ϴ�
				num[i] = num[j];//���ӽڵ��н�С������
				i = j;
				j = 2*i + 1;
			}
			else {
				j = high + 1;
			}
		}
		num[i] = temp;		
	}
	//ֱ��ѡ������
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
            System.out.println("�������鳤��");
            System.exit(1);
        }
        for (int i = 1; i < n; i++) {    //i��ʾ������������n-1��ѡ��ͽ���
            int minIndex = i-1;            //��minIndex��ʾ��СԪ�ص��±�
            for (int j = i; j < n; j++) {//�ҵ���ǰ������������СԪ�ص��±�
                if(a[minIndex]>a[j]) {//��������Ԫ��С�ڵ�ǰ��СԪ�أ�����minIndex��¼�º�����СԪ�ص��±�
                    minIndex = j;
                }
                
            }
            if(minIndex != i) {//���minIndex==i,˵��minIndex���ǵ�ǰ����������λԪ�ص��±꣬��˲��ý���
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
	//ֱ�Ӳ�������
	public void insertSort()//���ȽϺ�ϴ������ں�һλ
	{
		for(int i = 1 ; i < len ; i++)
		{
			//׼���������
			int temp = num[i];
			int j = i-1;
			for(; j > 0 && temp < num[j] ; j--) {
				num[j+1] = num[j];
			}
			num[j+1] = temp; //�������һλ����ֵ����������
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
//    	System.out.println("ð������:");
//    	s1.bubbleSort();
//    	System.out.println("������:");
//    	s1.heapSort();
//    	System.out.println("ֱ��ѡ������:");
//    	s1.selectionSort(num,len);
    	System.out.println("ֱ�Ӳ�������:");
    	s1.insertSort();
	}
}
