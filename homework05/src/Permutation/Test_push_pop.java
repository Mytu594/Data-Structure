package Permutation;

import java.util.Stack;
 
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,
 * 5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：
 * 这两个序列的长度是相等的）
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
		// popA下标
		int index = 0;
		for (int i = 0; i < pushA.length; i++)
		{
			stack.push(pushA[i]);
			// 假如栈顶和弹出序列的第一个数相同，出栈，popA下标往后移一位，继续判定栈顶和该数是否相同，不同，继续压栈
			while (!stack.isEmpty() && stack.peek() == ss[index])
			{
				stack.pop();
				index++;
			}
		}
		// 如果最后栈中数据没有全部弹出，说明不是弹出序列
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