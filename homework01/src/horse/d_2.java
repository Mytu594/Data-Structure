package horse;

import java.util.*;
public class d_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输出数组的维度:");
		Scanner reader=new Scanner(System.in);
        int num=reader.nextInt();
        int step[][]= {{0,1},{1,0},{0,-1},{-1,0}};
        int h=num,w=num;
        int [][]array=new int[num][num];
        
        ArrayList<Integer> re=new ArrayList<Integer>();
        re.add(1);
        int[][] flag=new int[h][w];
        flag[0][0]=1;
        int count=1,x=0,y=0;
        for(int a=0;count<(w*h);a=(a+1)%num) {
        	int newx=x+step[a][0],newy=y+step[a][1];
        	while(newx>=0&&newx<h&&newy>0&&newy<w) {
        		if(flag[newx][newy]==1) {
        			break;
        		}
        		int t=array[newx][newy];
        		count++;
        		flag[newx][newy]=1;
        		re.add(t);
        		x=newx;
        		y=newy;
        		newx=x+step[a][0];
        		newy=y+step[a][1];
        	}
        
        }
   
	}
}


