package week6;
public class MatrixMultiply {
	static int MN; //表示矩阵链中矩阵的数目 
	static int[]p; //存放各个矩阵的维数
	static int [][][]A;//存放要进行连乘的多个矩阵
	static int [][]m; //用来存放Ai到Aj的最少乘次数
	static int [][]s; //用来存放Ai到Aj的最后断开位置 
	//构造函数
	public MatrixMultiply() {
		MN=0;
		int[] p = {5, 200, 2, 100, 30, 200};
	}
	//构造函数,L为矩阵的数目 
	public MatrixMultiply(int L)  {  
		MN=5; 
		int[] p = {5, 200, 2, 100, 30, 200};
		A=new int [MN][][];  
		m=new int [MN+1][MN+1]; 
		s=new int [MN+1][MN+1];  //随机生成连乘矩阵的维数[1-11]   
	 
		//随机生成各个矩阵 
		for(int i=0;i<MN;i++) 
		{   
			A[i]=new int [p[i]][p[i+1]]; 
			CreatMatrix(A[i],p[i],p[i+1]); 
		} 
	 } 
	 //创建矩阵a，维数为m*n 随机数填充数组内容
	 public  void CreatMatrix(int[][] a, int m, int n) {
		 // TODO Auto-generated method stub
		 for(int i=0;i<m;i++)
			 for(int j=0;j<n;j++)    
		 a[i][j]=(int) Math.round(Math.random()*50)-10; 
	 }
	 //输出连乘的所有矩阵 
	 public void printAllM() 
	 {  
		 for (int i=0;i<this.MN;i++)
		 {    
			 System.out.println("A"+(i+1)+": "+A[i].length +"*"+A[i][0].length ); 
			 printM(A[i]); 
		 } 
	 }
	 //输出单个矩阵的值
	 public void printM(int[][] a) {
		 for(int i=0;i<a.length;i++)
		 {
			 System.out.print("   ");
			 for(int j=0;j<a[i].length;j++)
				 System.out.print("  "+a[i][j]);
			 System.out.println();
   		 }
    } 
    public static void main(String[]args) {
   	 	//构造函数分配内存空间
   	 	MatrixMultiply M=new MatrixMultiply(7);
   	 	M.printAllM();
   	 	int[] p = {5, 200, 2, 100, 30, 200};
   	 	M.matrixChain(p,M.m,M.s);
   	 	System.out.print("矩阵链所需的最少乘次数为："+M.m[1][M.MN]);
   	 	System.out.println();
   	 	String []s=new String[M.MN+1];
   	 	for(int i=1;i<=M.MN;i++)
        {
   	 		s[i]="A"+i;
       	}
   	 	M.traceback(M.s,1,M.MN,s);
   	 	System.out.print("矩阵连乘最优连乘顺序：");
   	 	for(int i=1;i<=M.MN;i++)
   	 	{
   	 		System.out.print(s[i]);
   	 	}  
    }   
    public void traceback(int[][] s, int i, int j, String[] c) {
   	 	if(i==j)return;
        traceback(s,i,s[i][j],c);
        traceback(s,s[i][j]+1,j,c);
        c[i]="("+c[i];
        c[j]=c[j]+")";
        System.out.println("矩阵连乘 A"+i+","+s[i][j]+"和 A"+(s[i][j]+1)+","+j);
    }
	//作用：计算矩阵连乘时，矩阵链的最少乘次数 
    private void matrixChain(int[] p, int[][] m, int[][] s) 
    {
   	 	int n=p.length-1;//矩阵链长度为1,不需要进行乘运算，即m[i][i]值为0 
   	 	for(int i=1;i<=n;i++)
   	 		m[i][i]=0;
   	 	for(int r=2;r<=n;r++)
   	 	{
   	 		for(int i=1;i<=n-r+1;i++)
   	 		{
   	 			int j=i+r-1;
   	 			m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
   	 			s[i][j]=i;
   	 			for(int k=i+1;k<j;k++)
   	 			{
   	 				int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
   	 				if(t<m[i][j])
   	 				{
   	 					m[i][j]=t;
   	 					s[i][j]=k;
   	 				}
   	 			}
   	 		}
   	 	}
   	 }
}