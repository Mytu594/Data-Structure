package Graph;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
        int vexNum = 0;
        int arcNum = 0;
        while(true) {
            System.out.print("������Ҫ��������ͼ���ܶ��������ܱ������Կո������");
            try {
                vexNum = sc.nextInt();
                arcNum = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("���벻�Ϸ���");
                continue;
            }
        }
        
        ALGraph aLGraph = new ALGraph(vexNum, arcNum);
        System.out.println("��������ȱ����ã�");
        aLGraph.dFSTraverse();
        System.out.println("�ɹ�����ȱ����ã�");
        aLGraph.bFSTraverse();

        sc.close();
	}

}
