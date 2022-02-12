package reverseArray;

public class MyArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	//数字
        Integer[]   arr = {10,45,78,45,14,79};
        MyArrays<Integer> tool = new MyArrays<Integer>();
        tool.reverse(arr);
        System.out.println("数组元素："+tool.toString(arr));
        //字符串
        String[]    arr1 = {"aa","bb","cc","dd","ee",};
        MyArrays<String> tool1 = new MyArrays<String>();
        tool1.reverse(arr1);
        System.out.println("数组元素："+tool1.toString(arr1));
    }

}

 class MyArrays <T> {
     //元素反转
     public void reverse(T[] arr){
         for (int startIndex = 0,endIndex =arr.length-1 ; startIndex < endIndex; startIndex++,endIndex--){
            T temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
        }
     }
     //toString 方法
     public String toString(T[] arr){
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                //字符串初始值
                sb.append("["+arr[i]+",");
            }else if (i == arr.length-1) {
                //字符串末尾值
                sb.append(arr[i]+"]");
            }else {
                //字符串中间值
                sb.append(arr[i]+",");
            }
        }
        return sb.toString();
     }
 }
 
 