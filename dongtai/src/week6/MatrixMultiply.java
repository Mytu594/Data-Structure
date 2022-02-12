package week6;
public class MatrixMultiply {
	static int MN; //��ʾ�������о������Ŀ 
	static int[]p; //��Ÿ��������ά��
	static int [][][]A;//���Ҫ�������˵Ķ������
	static int [][]m; //�������Ai��Aj�����ٳ˴���
	static int [][]s; //�������Ai��Aj�����Ͽ�λ�� 
	//���캯��
	public MatrixMultiply() {
		MN=0;
		int[] p = {5, 200, 2, 100, 30, 200};
	}
	//���캯��,LΪ�������Ŀ 
	public MatrixMultiply(int L)  {  
		MN=5; 
		int[] p = {5, 200, 2, 100, 30, 200};
		A=new int [MN][][];  
		m=new int [MN+1][MN+1]; 
		s=new int [MN+1][MN+1];  //����������˾����ά��[1-11]   
	 
		//������ɸ������� 
		for(int i=0;i<MN;i++) 
		{   
			A[i]=new int [p[i]][p[i+1]]; 
			CreatMatrix(A[i],p[i],p[i+1]); 
		} 
	 } 
	 //��������a��ά��Ϊm*n ����������������
	 public  void CreatMatrix(int[][] a, int m, int n) {
		 // TODO Auto-generated method stub
		 for(int i=0;i<m;i++)
			 for(int j=0;j<n;j++)    
		 a[i][j]=(int) Math.round(Math.random()*50)-10; 
	 }
	 //������˵����о��� 
	 public void printAllM() 
	 {  
		 for (int i=0;i<this.MN;i++)
		 {    
			 System.out.println("A"+(i+1)+": "+A[i].length +"*"+A[i][0].length ); 
			 printM(A[i]); 
		 } 
	 }
	 //������������ֵ
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
   	 	//���캯�������ڴ�ռ�
   	 	MatrixMultiply M=new MatrixMultiply(7);
   	 	M.printAllM();
   	 	int[] p = {5, 200, 2, 100, 30, 200};
   	 	M.matrixChain(p,M.m,M.s);
   	 	System.out.print("��������������ٳ˴���Ϊ��"+M.m[1][M.MN]);
   	 	System.out.println();
   	 	String []s=new String[M.MN+1];
   	 	for(int i=1;i<=M.MN;i++)
        {
   	 		s[i]="A"+i;
       	}
   	 	M.traceback(M.s,1,M.MN,s);
   	 	System.out.print("����������������˳��");
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
        System.out.println("�������� A"+i+","+s[i][j]+"�� A"+(s[i][j]+1)+","+j);
    }
	//���ã������������ʱ�������������ٳ˴��� 
    private void matrixChain(int[] p, int[][] m, int[][] s) 
    {
   	 	int n=p.length-1;//����������Ϊ1,����Ҫ���г����㣬��m[i][i]ֵΪ0 
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