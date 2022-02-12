package horse;

import java.util.Random;
import java.util.Scanner;
public class d_2_1 {
	public static void main(String[] args) {
		System.out.println("输出数组num*num:");
		Scanner reader=new Scanner(System.in);
        int num=reader.nextInt();
        int[][] array=new int[num][num];
        int x=0,y=0;
        int px=0,py=1;
        int sum=num,p=num;
        array[0][0]=1;
        for(int i=2;i<=num*num;i++)
        {
        	x=x+px;
        	y=y+py;
        	array[x][y]=i;
        	if(i==sum)
        	{
        		if(py!=0)
        		{
        			px=py;
        			py=0;
        			p--;
        			sum+=p;
        		}
        		else
        		{
        			py=-px;
        			px=0;
        			sum+=p;
        		}
        	}
        }
        for(int i=0;i<num;i++)
        {
        	for(int j=0;j<num;j++)
        	{
        		if(array[i][j]<10)
        			System.out.print(array[i][j]+"  ");
        		else
        			System.out.print(array[i][j]+" ");
        	}
        	System.out.println();
        }
        System.out.println();
        Random rand = new Random();
        int temp,k=0;
        int s=0;
        while(s<100)
        {
        	int n1=rand.nextInt(3)+1;
        	System.out.println("移动"+n1+"位");
        	s+=n1;
        	k=0;
        	while(k<n1)
            {
            	x=0;y=0;px=0;py=1;sum=num;p=num;
                for(int i=2;i<=4*num-4;i++)
                {
                	x=x+px;
                	y=y+py;
                	temp=array[x][y];
                	array[x][y]=array[0][0];
                	array[0][0]=temp;
                	if(i==sum)
                	{
                		if(py!=0)
                		{
                			px=py;
                			py=0;
                			p--;
                			sum+=p;
                		}
                		else
                		{
                			py=-px;
                			px=0;
                			sum+=p;
                		}
                	}
                }
                for(int i=0;i<num;i++)
                {
                	for(int j=0;j<num;j++)
                	{
                		{
                    		if(array[i][j]<10)
                    			System.out.print(array[i][j]+"  ");
                    		else
                    			System.out.print(array[i][j]+" ");
                    	}
                    }
                    System.out.println();
                	k++;
                }
            	if(s%(4*num-4)==0)
            		break;
            	for(int i=0;i<num;i++)
                {
                	for(int j=0;j<num;j++)
                	{
                		if(array[i][j]<10)
                			System.out.print(array[i][j]+"  ");
                		else
                			System.out.print(array[i][j]+" ");
                	}
                	 System.out.println();
                }
                System.out.println();
            	k++;
            }
        	if(s%((num-2)*(num-2))==0)
        		break;
        }
                
	}
}
       