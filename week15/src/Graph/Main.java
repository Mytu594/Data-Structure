package Graph;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
        int vexNum = 0;
        int arcNum = 0;
        while(true) {
            System.out.print("请输入要建立无向图的总顶点数和总边数，以空格隔开：");
            try {
                vexNum = sc.nextInt();
                arcNum = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入不合法！");
                continue;
            }
        }
        
        ALGraph aLGraph = new ALGraph(vexNum, arcNum);
        System.out.println("由深度优先遍历得：");
        aLGraph.dFSTraverse();
        System.out.println("由广度优先遍历得：");
        aLGraph.bFSTraverse();

        sc.close();
	}

}
