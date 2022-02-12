package horse;

import java.util.Random;
public class d_3 {

	public static void main(String[] args) {
		int[][][] array=new int[3][3][3];
		for(int z=0;z<3;z++)//array[z][y][x]
		{
			int t=1;
			for(int y=0;y<3;y++)
			{
				for(int x=0;x<3;x++)
				{
					array[z][y][x]=t++;
					System.out.print(array[z][y][x]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
		}
		Random rand = new Random();
		int n=rand.nextInt(3)+1;
    	System.out.println("最外一圈移动"+n+"位");
    	int k=0;
    	while(k<n) 
    	{
    		int z=0,y=0,x=2;
    		int px=0,py=1,pz=0;
    		int temp,sum=2;
    		for(int i=1;i<8;i++)
    		{
    			z+=pz;
    			y+=py;
    			x+=px;
    			temp=array[z][y][x];
    			array[z][y][x]=array[0][0][2];
    			array[0][0][2]=temp;
    			if(i==sum)
    			{
    				if(py==1)
    				{
    					pz=1;
    					py=0;
    					sum+=2;
    					continue;
    				}
    				if(pz==1)
    				{
    					pz=0;
    					py=-1;
    					sum+=2;
    					continue;
    				}
    				if(py==-1)
    				{
    					pz=-1;
    					py=0;
    					sum+=2;
    					continue;
    				}
    				
    			}
    			
    		}
    		for(int i=0;i<3;i++)
    		{
    			for(int j=0;j<3;j++)
    			{
    				for(int t=0;t<3;t++)
    				{
    					System.out.print(array[i][j][t]+" ");
    				}
    				System.out.println();
    			}
    			System.out.println();
    		
    	}
    	k++;
    	System.out.println();
    	}
	}
}