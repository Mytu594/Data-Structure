package Card_ferry;
//ÆÕÍ¨Ï´ÅÆ
import java.util.Random;
public class Card4 {
	public String[] card4()
	{
		  String[] suit= {"ºÚÌÒ","ºìÌÒ","·½Æ¬","Ã·»¨"};
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
		  return array;
	}
	public String[] shuffle4(String[] array)
	{
		String[] NewArray=new String[52];
		Random rand = new Random();
		int num=rand.nextInt(7)+22;
		System.out.println(num);
		if(num==27)
			num=25;
		if(num==28)
			num=24;
		int i=0,j=num,k=0,number;
		while(i<num && j<52)
		{
			number=rand.nextInt(3)+1;
			System.out.print(number+" ");
			if(i+number<num)
			{
				for(int a=0;a<number;a++)
				{
					NewArray[k++]=array[i];
					i++;
				}
			}
			else
			{
				for(int a=0;a<num-i-1;a++,k++)
				{
					NewArray[k]=array[i];
					i++;
				}
			}
			if(i==27)
				break;
			number=rand.nextInt(3)+1;
			System.out.println(number);
			if(j+number<52)
			{
				for(int a=0;a<number;a++,k++)
				{
					NewArray[k]=array[j];
					j++;
				}
			}
			else
			{
				for(int a=0;a<52-j;a++,k++)
				{
					NewArray[k]=array[j];
					j++;
				}
			}
			if(j==52)
				break;
		}
		if(j==52)
			for(int a=0;a<num-i;a++,i++)
				NewArray[k++]=array[i];
		if(i==num)
			for(int a=0;a<52-j;a++,j++)
				NewArray[k++]=array[j];
		for(i=0;i<52;i++)
			System.out.print(NewArray[i]+" ");
		return NewArray;
	}
	public static void main(String[] args) {
		Card4 a=new Card4();
		String[] b;
		b=a.shuffle4(a.card4());
		a.shuffle4(a.shuffle4(b));
	}

}
