package forest;

public class HuffmanTree {
	public int[][] huffmanCoding(int[] W){
		int n=W.length;
		int m=2*n-1;
		HuffmanNode[] HN=new HuffmanNode[m];
		int i;
		for(i=0;i<n;i++) {
			HN[i]=new HuffmanNode(W[i]);
		}
		for(i=n;i<m;i++) {
			HuffmanNode min1=selectMin(HN,i-1);
			min1.flag=1;
			HuffmanNode min2=selectMin(HN,i-1);
			min2.flag=1;
			HN[i]=new HuffmanNode();
			min1.parent=HN[i];
			min2.parent=HN[i];
			HN[i].lchild=min1;
			HN[i].rchild=min2;
			HN[i].weight=min1.weight+min2.weight;
		}
		int[][] HuffCode=new int[n][n];
		for(int j=0;j<n;j++) {
			int start=n-1;
			for(HuffmanNode c=HN[j],p=c.parent;p!=null;c=p,p=p.parent)
				if(p.lchild.equals(c))
					HuffCode[j][start--]=0;
				else
					HuffCode[j][start--]=1;
			HuffCode[j][start]=-1;
		}
		return HuffCode;
	}
	private HuffmanNode selectMin(HuffmanNode[] HN,int end) {
		HuffmanNode min=HN[end];
		for(int i=0;i<=end;i++) {
			HuffmanNode h=HN[i];
			if(h.flag==0&&h.weight<min.weight) {
				min=h;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[] W= {23,11,5,3,29,14,7,8};
		HuffmanTree T=new HuffmanTree();
		int[][] HN=T.huffmanCoding(W);
		System.out.println("¹þ·òÂü±àÂëÎª:");
		for(int i=0;i<HN.length;i++) {
			System.out.print(W[i]+" ");
			for(int j=0;j<HN[i].length;j++) {
				if(HN[i][j]==-1) {
					for(int k=j+1;k<HN[i].length;k++) {
						System.out.println(HN[i][k]);
					break;
					}
				}
			}
			System.out.println();
		}
	}
}
