package Stack;
import LinkStack.LinkStack;

import java.util.Scanner;

class list {
	LinkStack stack=new LinkStack();
	public char priority2(char t1,char t2) {
		int i = 0,j = 0;
		char[][] pre={    
				{ '>','>','<','<','<','>','>'},
				{'>','>','<','<','<','>','>',},
				{'>','>','>','>','<','>','>',},
				{'>','>','>','>','<','>','>',},   
				{'<','<','<','<','<','=',' ',},
				{'>','>','>','>',' ','>','>',},
				{'<','<','<','<','<',' ','=' },
			};       //���������ȹ�ϵ����Ӧ��ʵ�ֹ�ϵ�ڴ��������׳�
		switch(t1){
		case '+': i=0; break;
		case '-': i=1; break;
		case '*': i=2; break;
		case '/': i=3; break;
		case '(': i=4; break;
		case ')': i=5; break;
		case '=': i=6; break;
		}
		switch(t2){
		case '+': j=0; break;
		case '-': j=1; break;
		case '*': j=2; break;
		case '/': j=3; break;
		case '(': j=4; break;
		case ')': j=5; break;
		case '=': j=6; break;
		}
		return pre[i][j];
	}
	//�ж��ǲ��ǲ�����
	public static boolean isNum(char c) {
        return Character.isDigit(c);
    }
	public boolean isOperator(char c) {
		if('+'==c||'-'==c||'*'==c||'/'==c||'^'==c||'%'==c) {
			return true;
		}else {
			return false;
		}
	}
	/*public void convertToPostfix(String str,int maxsize)throws Exception{
		
		LinkStack st=new LinkStack();
		String postfix=new String();
		
		while(!st.isEmpty()) {
			postfix=postfix.concat(String.valueOf(st.pop()));
		}
		return postfix;
		
	}*/
	/*public double Calculate(char a,char y,char b){
	    char result = 0;
	    char i,j;
	    i=(char) (a-48);
	    j=(char) (b-48);
	    switch(y){
	        case'+':result=(char) (i+j+48);break;
	        case'-':result=(char) (i-j+48);break;
	        case'*':result=(char) ((i*j)+48);break;
	        case'/':result=(char) (((double)i/(double)j)+48);break;
	    }
	     
	    return result;
	}*/
	//��ֵ
		public double Calculate(String postfix)throws Exception{
			LinkStack st=new LinkStack();
			for(int i=0;postfix!=null&&i<postfix.length();i++) {
				char c=postfix.charAt(i);
				if(isOperator(c)) {
					//ȡ������������
					double num2=Double.valueOf(st.pop().toString());
					double num1=Double.valueOf(st.pop().toString());
					double num=0;
					if('+'==c) {
						num=num1+num2;
					}
					else if('-'==c) {
						num=num1-num2;
					}
					else if('*'==c) {
						num=num1*num2;
					}
					else if('/'==c) {
						num=num1/num2;
					}
					else if('^'==c) {
						num=Math.pow(num1,num2);
					}
					else if('%'==c) {
						num=num1%num2;
					}
					st.push(num);
				}
				else {
					st.push(c);
				}
			}	
			return (Double)st.pop();
		}
	public double Calculate() throws Exception {
		char num1,num2,c,optr;
		LinkStack op=new LinkStack();
		LinkStack num=new LinkStack();
	    op.push('#');
	    System.out.println("��������ʽ:");
	    c= (char)System.in.read();
	    while(c!='#'||!op.peek().equals('#')){
	        if(isOperator(c)){
	            
	            switch(priority2((char)op.peek(),c)){
                case'<':
                    op.push(c);
                    c=(char)System.in.read();
                    break;
                case'=':
                	op.pop();
                	c=(char)System.in.read();
                    break;
                case'>':
                	num1=(char) num.pop();
                	num.pop();
                	optr=(char) op.pop();
                	op.pop();
                	num2=(char) num.pop();
                	num.pop();
                	num.push(Calculate());
                    break;
	            }
	        }
	        else{
	        	num.push(c);
	            c=(char)System.in.read();
	        }
	    }
	    return (Double)num.pop();
	}	
}
public class calculate1 {
	public static void main(String[] args) throws Exception {
		list sc=new list();
		double sum=sc.Calculate();//(1+2)*(5-2)/2^2+5%3
		System.out.println("���ʽ��Ȩֵ���:"+sum);
	}
}
