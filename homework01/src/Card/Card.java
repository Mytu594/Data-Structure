package Card;

import java.util.*;
public class Card {
	int N = 52;
	int cnt = 0;
	public void cards() {
		String[] list = new String [N];
		String[] type = {"黑桃","红桃","梅花","方块"};
		String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				list[cnt] = type[j] + number[i];
				cnt++;
			}
		}
		System.out.println("洗牌前的顺序为：");
		for (cnt = 0; cnt < N; cnt++) {
			System.out.print(list[cnt]+" ");
		}
		System.out.println();
		this.Shuffle(list);
	}
	public void Shuffle(String[] a) {
		Random rand = new Random();
		String[] array = new String[N];
		for (int k = 0; k < 3; k++) {   //洗牌三次
			int num1 = rand.nextInt(7)+22;
			int nums1 = 0, nums2 = num1;
			int num2 = Math.min(num1, N - num1);
			for (cnt = 0; cnt < 2 * num2;) {
				int num3 = rand.nextInt(4)+0;
				int num4 = rand.nextInt(4)+0;
				for (int i = nums1, n = 0; nums1 < num1 && n < num3; i++) {
					array[cnt++] = a[i];
					nums1++;
					n++;
				}
				for (int i = nums2 , m = 0; nums2 < 2 * num2 && m < num4; i++) {
					array[cnt++] = a[i];
					nums2++;
					m++;
				}
			}
			for (int i = 2 * num2; cnt < N; i++) {
				array[cnt++] = a[i];
			}
			for (int i = 0; i < N; i++) {
				a[i] = array[i];
			}
		}
		System.out.println("洗牌后：");
		for (cnt = 0; cnt < N; cnt++) {
			System.out.print(array[cnt]+" ");
		}
	}
	public static void main(String[] args) {
		Card c = new Card();
		c.cards();
	}
}