import java.util.Arrays;
public class QuickSort2 {
    public static void main(String[] args)
    {
        int[] arr={5,3,1,9,8,2,4,7};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quick(int[] arr,int left,int right)
    {
        while (left>=right)
        {
            return;
        }
        int i=left;
        int j=right;
        int k=(int)(Math.random()*(right-left+1))+left;//�����������ѡ��һ������Ϊ��׼��
        int temp=arr[k];
        arr[k]=arr[left];
        arr[left]=temp;//���Ի�׼����������±�Ϊ0��λ��--�������ж�
        int firstIndex=left;
        int first=arr[firstIndex];
        while (i<j)
        {
            while (i<j&&arr[j]>=first)
            {
                j--;
            }
            while (i<j&&arr[i]<=first)
            {
               i++;
            }
            if(i<j)
            {
                int temp2=arr[j];
                arr[j]=arr[i];
                arr[i]=temp2;
            }
        }
        arr[firstIndex]=arr[i];
        arr[i]=first;
        quick(arr,left,i-1);
        quick(arr,i+1,right);
    }
}