package horse;

import java.util.Scanner;
import java.util.Random;
public class d_2_2 {

	public static void main(String[] args) {
    	System.out.println("请输入一个整数n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] rect = new int[n + 1][n + 1];

        int x = 0, y = 1; // 当前遍历的位置
        int px = 1, py = 0; // x/y 在当前循环方向的增量
        int pn = n; // 该方向上还需要多少个数字（会递减，因为顺时针往里缩）
        int sum = n; // 当前遍历方向的终点位置

        for (int i = 1; i <= n * n; i++) { // 翻转矩阵循环
            // 移到下一个点(第一次方向1->5 x增量为1， y的增量为0， 第二次方向为6->9,x增量为0，y增量为1，pn减少一个)
            x += px;
            y += py;
            rect[x][y] = i;
            if (i == sum) { // 到达该方向的最后一个点
                if (px == 1 || px == -1) { // x的增量不为0，则为竖向 -> 横向
                    pn = pn - 1; // 竖向变为横向的时候，该方向上数字的个数会减少一个
                    sum = sum + pn;
                    py = px;
                    px = 0;
                } else { // x的增量为0， y的增量不为0，则为横向 -> 竖向
                    sum = sum + pn;
                    px = -py;
                    py = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(rect[j][i] + "\t"); // 翻转复原输出
            }
            System.out.println();
        }
        
    }

}