package Stack;
import LinkStack.LinkStack;
import java.util.Scanner;
public class calculate {
	LinkStack stack=new LinkStack();
	public String convertToPostfix(String expression)throws Exception{
		LinkStack st=new LinkStack();         //运算符栈
		String postfix=new String();         //后缀表达式
		for(int i=0;expression!=null&&i<expression.length();i++) {
			char c=expression.charAt(i);
			if(' '!=c) {
				if(isOpen(c)) {
					st.push(c);  //左,压栈
				}
				else if(isClose(c)) {  //右
					char ac=(Character) st.pop();
					while(!isOpen(ac)) {
						postfix=postfix.concat(String.valueOf(ac));
						ac=(Character) st.pop();
					}
				}
				else if(isOperator(c)) {  //运算符
					if(!st.isEmpty()) {
						Object ac = (Character)st.pop();
						while(ac!=null&&priority(((Character) ac).charValue())>=priority(c)) {
							postfix=postfix.concat(String.valueOf(ac));
							ac=(Character) st.pop();
						}
						if(ac!=null) {
							st.push(ac);
						}
					}
					st.push(c);
				}
				else {  //操作数
					postfix=postfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()) {
			postfix=postfix.concat(String.valueOf(st.pop()));
		}
		return postfix;
		
	}
	//求值
	public double Calculate(String postfix)throws Exception{
		LinkStack st=new LinkStack();
		for(int i=0;postfix!=null&&i<postfix.length();i++) {
			char c=postfix.charAt(i);
			if(isOperator(c)) {
				//取出两个操作数
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
	public boolean isOperator(char c) {
		if('+'==c||'-'==c||'*'==c||'/'==c||'^'==c||'%'==c) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isOpen(char c) {
		return '('==c;
	}
	public boolean isClose(char c) {
		return ')'==c;
	}
	//优先级--赋权值
	public int priority(char c){
		 if(c=='^') {
			 return 3;
		 }
		 if('*'==c||'/'==c||'%'==c) {
			 return 2;
		 }
		 else if('+'==c||'-'==c) {
			 return 1;
		 }
		 else {
			 return 0;
		 }
	}
	//优先级--二维数组
	public String[][] priority2() {
		String[][] pre={    
				{" ","+","-","*","/","(",")","#"},
				{"+",">",">","<","<","<",">",">"},
				{"-",">",">","<","<","<",">",">"},
				{"*",">",">",">",">","<",">",">"},   
				{"/",">",">",">",">","<",">",">"},
				{"(","<","<","<","<"," ","=",">"},
				{")",">",">",">",">"," "," ",">"},
				{"#","<","<","<","<","<","<","="},
			};       //算符间的优先关系，对应的实现关系在代码下面抛出
		return pre;
	}
	/*public char priority2(char t1,char t2) {
		int i = 0,j = 0;
		char[][] pre={    
				{ '>','>','<','<','<','>','>'},
				{'>','>','<','<','<','>','>',},
				{'>','>','>','>','<','>','>',},
				{'>','>','>','>','<','>','>',},   
				{'<','<','<','<','<','=',' ',},
				{'>','>','>','>',' ','>','>',},
				{'<','<','<','<','<',' ','=' },
			};       //算符间的优先关系，对应的实现关系在代码下面抛出
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
	}*/
	public void convertToPostfix(String expression,int maxsize) {
		String[][] pre=priority2();
		LinkStack st=new LinkStack();         //运算符栈
		LinkStack sn=new LinkStack();        //运算数栈
		String[] postfix=new String[maxsize];         //后缀表达式
		String s="";
		for(int i=0;i<expression.length();i++) {
			if(!Character.isDigit(expression.charAt(i))) {
				postfix[i]=String.valueOf(expression.charAt(i));
//				System.out.println(postfix[i]);
			}
			else {
				if(i<expression.length()-1&&expression.charAt(i+1)>=0) {
					s+=expression.charAt(i);
				}
			}
		}
		int length=expression.length();
		sn.push("#");
		st.push("#");
		int i=0;
		for(i=0;i<length;i++) {
			if(isOperator1(postfix[i])) {
				int rows=0;
				int cols=0;
				for(int j=0;j<8;j++) {
					if(pre[j][0].equals(st.peek())) {
						rows=j;
						break;
					}
				}
				for(int j=0;j<8;j++) {
					if(pre[0][j].equals(st.peek())) {
						cols=j;
						break;
					}
				}
				if(pre[rows][cols].equals("<")) {
					st.push(postfix[i]);
				}
				else if(pre[rows][cols].equals(">")) {
					int a=Integer.parseInt((String) sn.peek());
					sn.pop();
					int b=Integer.parseInt((String) sn.peek());
					sn.pop();
					if(st.peek().equals("+")) {
						sn.push(""+(a+b));
					}
					if(st.peek().equals("*")) {
						sn.push(""+(a*b));
					}
					else if(st.peek().equals("/")) {
						sn.push(""+(a/b));
					}
					else if(st.peek().equals("^")) {
						sn.push(""+(Math.pow(a,b)));
					}
					else if(st.peek().equals("%")) {
						sn.push(""+(a%b));
					}
					st.pop();
					i--;
				}
				else {
					st.pop();
				}
			}
			else  //不是操作符
				sn.push(postfix[i]);
			
			System.out.println("此时操作符栈:");
			st.display();
			System.out.println("此时数字符栈:");
			sn.display();
		}
		if(st.isEmpty()) 
			System.out.println("表达式的权值结果"+sn.peek());
		
	}
	
	boolean isOperator1(String c){
		if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")||c.equals("^")||c.equals("%")) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		calculate p=new calculate();
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入10以内的四则运算表达式:");//(1+2)*(5-2)/2^2+5%3
		String str=reader.next();
		System.out.println("原式为："+str);
		System.out.println("后缀表达式:"+p.convertToPostfix(str));
		String postfix=p.convertToPostfix(str);
		System.out.println("表达式的权值结果:"+p.Calculate(postfix));
		String str1=reader.next();
		System.out.println("原式为："+str1);
		int maxsize=str1.length()+1;;
		System.out.println("后缀表达式:");
		p.convertToPostfix(str1,maxsize);
		reader.close();
//		String postfix=p.convertToPostfix(str);
//		System.out.println("表达式的权值结果:"+p.Calculate(postfix));
	}

}
