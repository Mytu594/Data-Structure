package Card_ferry;
//专业洗牌
import java.util.Random;
public class Card3 {//第三种生成牌方法
	public class poker
	{
	    public String suit;
        public String rank;
        public poker(String x,String y)
        {
            suit=x;
            rank=y;
        }
    }
	public poker[] card3()
	{
		poker[] array=new poker[52];
		String[] suit= {"黑桃","红桃","方片","梅花"};
		String[] rank= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int k=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<13;j++)
              {
            	array[k]=new poker(suit[i],rank[j]);
            	k++;
              }
        }
        this.shuffle3(array);
        return array;
	}
	public void shuffle3(poker[] array)//专业洗牌
	{
		Random rand = new Random();
		int num=rand.nextInt(7)+22;
		System.out.println(num);
		poker[] NewArray=new poker[52];
		int i=0,j=num,k=0;
		if(num<=26)
		{
			for(;i<num;i++,j++)
			{
				NewArray[k]=array[i];
				NewArray[k+1]=array[j];
				k+=2;
			}
			for(;j<52;j++)
			{
				NewArray[k]=array[j];
				k++;
			}
		}
		else
		{
			for(;j<52;i++,j++)
			{
				NewArray[k]=array[i];
				NewArray[k+1]=array[j];
				k+=2;
			}
			for(;i<num;i++)
			{
				NewArray[k]=array[i];
				k++;
			}
		}
		System.out.println();
		for(i=0;i<52;i++)
        {
            System.out.print(NewArray[i].suit+NewArray[i].rank+" ");
        }
	}
	public static void main(String[] args) {
		Card3 a=new Card3();
		a.card3();
	}

}
