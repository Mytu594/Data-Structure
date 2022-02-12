package Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//������ͨ��ջ��Push()��pop()��ã���push()pop()��˳�����
class SqStack_01{   //��ջ�ж��Ƿ�Ϊ���Ĵ�
	public int top;
	public String[] stackElem;
	SqStack_01(int maxsize){     //��ʼ��
		top = 0;
		stackElem = new String[maxsize];
	}
	public void push(String x) {    //��ջ
		if (top == stackElem.length) {
			System.out.println("ջ������");
			return;
		}
		else
			stackElem[top++] = x;
	}
	public boolean isEmpty() {   //�ж��Ƿ��ǿ�
		return top == 0;
	}
	public String peek() {   //��ȡջ��Ԫ��
		if(!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}
	public String pop() {   //��ջ
		if(isEmpty())
			return null;
		else
			return stackElem[--top];
	}
}


public class CanThrough {
	public void putOut(String str) {
		String[] strs = str.split("");
		int maxsize = strs.length;
		SqStack_01 S = new SqStack_01(maxsize);
		String[] orignal = {"1","2","3","4","5"};   //ԭʼ�ַ�������
		int i = 0, j = 0;
		String newStr = "";
		try {
            FileWriter fw=new FileWriter("g:\\pushpop.txt",true);
            fw.append(new String(str)+'\n');
            while (i < orignal.length && j < maxsize) {    //����ԭʼ�ַ���
            	int ori = Integer.parseInt(orignal[i]);
            	int strNum = Integer.parseInt(strs[j]);
            	if (ori == strNum) {    //������ֵ���ʱ
            		S.push(orignal[i]);   //ѹ��ԭʼ�����һ��
            		newStr += ("push(" + orignal[i] + ")\t");																			
            		S.pop();       //ֱ��pop����
            		newStr += ("pop()\t");	//������д���ļ�
            		i++;
            		j++;     //ָ�����
            	}
            	else if(strNum > ori) {    //�����ַ���ָ��ָ�����>ԭʼ����ָ��ָ�����
            		S.push(orignal[i]);    //ѹ��
            		newStr += ("push(" + orignal[i] + ")\t");	
            		i++;    //ָ�����
            	}
            	else {    //�����ַ���ָ��ָ�����<ԭʼ����ָ��ָ�����
            		if(S.peek().equals(strs[j]))
            			S.pop();
            		else
            			return;
            		newStr += ("pop()\t");
            		j++;   //ָ�����
            	}
            }
            if (i == orignal.length) {
            	while(j < maxsize) {    //ջ��Ԫ���ܲ���pop�����γ������˳��
            		if(S.peek().equals(strs[j])) {
            			S.pop();
            			newStr += "pop()\t";
            			j++;
            		}
            		else
            			return;
            	}
            }
            fw.append(new String(newStr+'\n'));
            fw.close();
		}catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CanThrough S = new CanThrough();
		File filePath = new File("h:\\file.txt");
		String s = null;
		try {    //��ȡ�ļ���ÿһ��
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				S.putOut(s);
			}
			System.out.println("Done!");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}