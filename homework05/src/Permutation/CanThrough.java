package Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//若可以通过栈的Push()和pop()获得，则将push()pop()的顺序输出
class SqStack_01{   //用栈判断是否为回文串
	public int top;
	public String[] stackElem;
	SqStack_01(int maxsize){     //初始化
		top = 0;
		stackElem = new String[maxsize];
	}
	public void push(String x) {    //入栈
		if (top == stackElem.length) {
			System.out.println("栈已满！");
			return;
		}
		else
			stackElem[top++] = x;
	}
	public boolean isEmpty() {   //判断是否是空
		return top == 0;
	}
	public String peek() {   //读取栈顶元素
		if(!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}
	public String pop() {   //出栈
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
		String[] orignal = {"1","2","3","4","5"};   //原始字符串数组
		int i = 0, j = 0;
		String newStr = "";
		try {
            FileWriter fw=new FileWriter("g:\\pushpop.txt",true);
            fw.append(new String(str)+'\n');
            while (i < orignal.length && j < maxsize) {    //遍历原始字符串
            	int ori = Integer.parseInt(orignal[i]);
            	int strNum = Integer.parseInt(strs[j]);
            	if (ori == strNum) {    //当两个值相等时
            		S.push(orignal[i]);   //压入原始数组的一个
            		newStr += ("push(" + orignal[i] + ")\t");																			
            		S.pop();       //直接pop出来
            		newStr += ("pop()\t");	//将操作写入文件
            		i++;
            		j++;     //指针后移
            	}
            	else if(strNum > ori) {    //当新字符串指针指向的数>原始数组指针指向的数
            		S.push(orignal[i]);    //压入
            		newStr += ("push(" + orignal[i] + ")\t");	
            		i++;    //指针后移
            	}
            	else {    //当新字符串指针指向的数<原始数组指针指向的数
            		if(S.peek().equals(strs[j]))
            			S.pop();
            		else
            			return;
            		newStr += ("pop()\t");
            		j++;   //指针后移
            	}
            }
            if (i == orignal.length) {
            	while(j < maxsize) {    //栈内元素能不能pop出，形成输入的顺序
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
		try {    //读取文件的每一行
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