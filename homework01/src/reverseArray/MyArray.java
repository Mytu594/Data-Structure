package reverseArray;

public class MyArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	//����
        Integer[]   arr = {10,45,78,45,14,79};
        MyArrays<Integer> tool = new MyArrays<Integer>();
        tool.reverse(arr);
        System.out.println("����Ԫ�أ�"+tool.toString(arr));
        //�ַ���
        String[]    arr1 = {"aa","bb","cc","dd","ee",};
        MyArrays<String> tool1 = new MyArrays<String>();
        tool1.reverse(arr1);
        System.out.println("����Ԫ�أ�"+tool1.toString(arr1));
    }

}

 class MyArrays <T> {
     //Ԫ�ط�ת
     public void reverse(T[] arr){
         for (int startIndex = 0,endIndex =arr.length-1 ; startIndex < endIndex; startIndex++,endIndex--){
            T temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
        }
     }
     //toString ����
     public String toString(T[] arr){
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                //�ַ�����ʼֵ
                sb.append("["+arr[i]+",");
            }else if (i == arr.length-1) {
                //�ַ���ĩβֵ
                sb.append(arr[i]+"]");
            }else {
                //�ַ����м�ֵ
                sb.append(arr[i]+",");
            }
        }
        return sb.toString();
     }
 }
 
 