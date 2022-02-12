package Permutation;

import java.util.Stack;
 
/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,
 * 5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺
 * ���������еĳ�������ȵģ�
 */
public class Test_push_pop
{
	Stack<Integer> stack = new Stack<Integer>();
 
	 boolean IsPopOrder(int[] pushA, char[] ss)
	{
 
		if (pushA.length <= 0 || ss.length <= 0)
		{
			return false;
		}
		// popA�±�
		int index = 0;
		for (int i = 0; i < pushA.length; i++)
		{
			stack.push(pushA[i]);
			// ����ջ���͵������еĵ�һ������ͬ����ջ��popA�±�������һλ�������ж�ջ���͸����Ƿ���ͬ����ͬ������ѹջ
			while (!stack.isEmpty() && stack.peek() == ss[index])
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
 
	public static void main(String[] args)
	{
		int[] pushA =
		{ 1, 2, 3, 4, 5 };
		char[] popA =
				// { 4, 5, 3, 2, 1 };
				{'4', '3', '5','1', '2' };
 
		Test_push_pop s = new Test_push_pop();
		System.out.println(s.IsPopOrder(pushA, popA));
	}
 
}