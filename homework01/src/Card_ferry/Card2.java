package Card_ferry;
//����ϴ��
import java.util.ArrayList;
public class Card2 {//����
	/*public ArrayList<String> cardArray()//��һ�������Ʒ���
	{
		ArrayList<String> array=new ArrayList<String>();
		String[] suit=new String[] {"����","����","����","÷��"};
		String[] rank=new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
			{
				array.add(suit[i]+rank[j]);
			}
		}
		return array;
	}*/
	public String[] card2()//�ڶ��������Ʒ���
	{
		  String[] suit= {"����","����","��Ƭ","÷��"};
		  String[] rank= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		  String[] array=new String[52];
		  String str = "";
		  int k=0;
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<13;j++)
			  {
				  str=suit[i]+rank[j];
				  array[k]=str;
				  k++;
			  }
		  }
		  this.shuffle2(array);
		  return array;
	}
	public void shuffle2(String[] array)//����ϴ��
	{
		String[] NewArray=new String[52];
		int k=0;
		for(int i=0,j=51;i<26;i++,j--)
		{
			NewArray[k]=array[i];
			NewArray[k+1]=array[j];
			k+=2;
		}
		System.out.println();
		for(int i=0;i<52;i++)
		{
			System.out.print(NewArray[i]+" ");
		}
	}
	public static void main(String[] args) {
		Card2 a=new Card2();
		a.card2();
	}

}