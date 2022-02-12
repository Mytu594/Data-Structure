package horse;

import java.util.Scanner;
import java.util.Random;
public class d_2_2 {

	public static void main(String[] args) {
    	System.out.println("������һ������n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] rect = new int[n + 1][n + 1];

        int x = 0, y = 1; // ��ǰ������λ��
        int px = 1, py = 0; // x/y �ڵ�ǰѭ�����������
        int pn = n; // �÷����ϻ���Ҫ���ٸ����֣���ݼ�����Ϊ˳ʱ����������
        int sum = n; // ��ǰ����������յ�λ��

        for (int i = 1; i <= n * n; i++) { // ��ת����ѭ��
            // �Ƶ���һ����(��һ�η���1->5 x����Ϊ1�� y������Ϊ0�� �ڶ��η���Ϊ6->9,x����Ϊ0��y����Ϊ1��pn����һ��)
            x += px;
            y += py;
            rect[x][y] = i;
            if (i == sum) { // ����÷�������һ����
                if (px == 1 || px == -1) { // x��������Ϊ0����Ϊ���� -> ����
                    pn = pn - 1; // �����Ϊ�����ʱ�򣬸÷��������ֵĸ��������һ��
                    sum = sum + pn;
                    py = px;
                    px = 0;
                } else { // x������Ϊ0�� y��������Ϊ0����Ϊ���� -> ����
                    sum = sum + pn;
                    px = -py;
                    py = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(rect[j][i] + "\t"); // ��ת��ԭ���
            }
            System.out.println();
        }
        
    }

}