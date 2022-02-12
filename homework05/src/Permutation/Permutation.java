package Permutation;

import java.io.*;
import java.util.Stack;

class Permutation{ 	
	public static void permutation(char[]ss,int i) throws IOException{  
//		int[] pushA =
//    		{ 1, 2, 3, 4, 5 };
        if(ss==null||i<0 ||i>ss.length){//1  
            return;  
        }
        
        if(i==ss.length-1){//2  
            System.out.println(new String(ss));
            FileWriter fw=new FileWriter("g:\\file.txt",true);
            fw.write(new String(ss)+"\n");
            fw.close();
        }else{  
            for(int j=i;j<ss.length;j++){//3  
                char temp=ss[j];//����ǰ׺,ʹ֮������һ��ǰ׺  
                ss[j]=ss[i];  
                ss[i]=temp;  
                
                permutation(ss,i+1);//4  
                
                temp=ss[j]; //��ǰ׺������,��������һ����ǰ׺����.//5  
                ss[j]=ss[i];  
                ss[i]=temp;  
                
            }   
        }  
        
    }  
	Stack<Integer> stack = new Stack<Integer>();
	 
	public boolean IsPopOrder(char[] pushA, char[] popA)
	{
 
		if (pushA.length <= 0 || popA.length <= 0)
		{
			return false;
		}
		// popA�±�
		int index = 0;
		for (int i = 0; i < pushA.length-1; i++)
		{
			stack.push((int) pushA[i]);
			// ����ջ���͵������еĵ�һ������ͬ����ջ��popA�±�������һλ�������ж�ջ���͸����Ƿ���ͬ����ͬ������ѹջ
			while (!stack.isEmpty() && stack.peek() == popA[index])
			{
				stack.pop();
				index++;
			}
		}
		// ������ջ������û��ȫ��������˵�����ǵ�������
		if (stack.isEmpty())
		{	
			return true;
			
		} else
			return false;
	}
    public static void main(String args[]) throws IOException{
    	permutation(new char[]{'1','2','3','4','5'},0);
    	char[] pushA =
      		{ '1', '2','3','4','5' };
    	Permutation T=new Permutation();
    	File filePath = new File("g:\\file.txt");
		BufferedReader br;
		String s = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				System.out.print(s + "��");
				System.out.println(T.IsPopOrder(pushA, s.toCharArray()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}