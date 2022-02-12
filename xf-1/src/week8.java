
public class week8 {
	public static void optimalBinarySearchTree(float []a,float []b,float[][] m,int [][]s,float[][] w)
	{
		int n=b.length;
		for(int i=0;i<n;i++)
		{
			w[i+1][i]=a[i];
			m[i+1][i]=0;
		}
		for(int r=0;r<n;r++)
			for(int i=1;i<n-r;i++)
			{
				int j=i+r;
				w[i][j]=w[i][j-1]+a[j]+b[j];
				m[i][j]=m[i][i-1]+m[i+1][j]; //m[i][i-1]��ʾ�������ļ������� Ϊ0  i�����ܵ�i-1��λ��
				s[i][j]=i;
				for(int k=i+1;k<=j;k++)
				{
					float t=m[i][k-1]+m[k+1][j];
					if(t<m[i][j])
					{
						m[i][j]=t;
						s[i][j]=k;
					}
				}
				m[i][j]+=w[i][j];
			}
	}
	//��ӡ
	public static void display(float[][] s) {
		for(int i=0;i<s.length;i++)
		{
			for(int j=0;j<s[i].length;j++)
			{
				System.out.print(s[i][j]+" ");
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		float []a= {2,3,1,1,1};
		float []b= {3,3,1,1};
		float[][] m=new float[5][5];  //������������T(i, j)��ƽ����������(ƽ������)(��������)
		int[][] s=new int[5][5];      //������������T(i, j)�ĸ��ڵ�Ԫ��
		float[][] w=new float[5][5];  //������������T(i, j)�ĸ��ʺ�
		int n=b.length;
		optimalBinarySearchTree(a,b,m,s,w);
		System.out.println("ƽ����������(ƽ������):");
		display(m);
		System.out.println("�洢���ĸ��ʺ�: ");
		display(w);
		//���Ŷ������������
		System.out.println("���Ŷ�����������ڵ�Ԫ��: ");
		for(int i=0;i<s.length;i++)
		{
			for(int j=0;j<s[i].length;j++)
			{
				System.out.print(s[i][j]+" ");
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}

}
