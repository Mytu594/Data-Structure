package Card;


public class F extends Cards{

	public String[] shuffle(String[] cards) {
		//分成随机两部，分别分存进不同数组
			int size1 = (int)(Math.random()*(28-22)+22); //随机产生22-28范围的牌
			int size2 = 54 - size1;
			String[] left = new String[size1];
			String[] right = new String[size2];
			for(int i=0; i<size1; i++) {
				left[i] = cards[i];
			}
			int j = 0;
			while(j<size2 && size1<54) {
				right[j] = cards[size1];
				j++;
				size1++;
			}
			//将分出的相等长度的两部分存进新建数组
			String[] changed = new String[54];
			int p = Math.min(size1,size2);
			int k = 0;
			int size = 0;
			while(k<p && size<2*p) {
				changed[size] = right[k];
				changed[size+1] = left[k];
				k++;
				size += 2;
			}
			//将较大的数组剩余部分存进新建数组的剩余部分
			if(size1 < size2) {
				for(int q=2*p; q<(size2-size1+1); q++) {
					changed[q] = right[size1];
					size1++;
				}
			}
			if(size1 > size2) {
				for(int q=2*p; q<(size1-size2+1); q++) {
					changed[q] = right[size2];
					size2++;
				}
			}
			return changed;
			
		}
	
		public static void main(String[] args) {
			Cards2 c = new Cards2();
			System.out.println("原先的牌：");
			String[] cards = new String[54];
			for(int i=0; i<52; i++) {
				cards[i] = c.card(i);
				//每次输出13张牌
				if(i%13 == 0)
					System.out.println();
				System.out.print(cards[i]+" ");
			}
			cards[52]="大王";
			cards[53]="小王";
			System.out.println(cards[52]+" "+cards[53]);
			System.out.println("洗后的牌：");
			String[] newCards = new String[54];
			newCards = c.shuffle(cards);
			for(int i=0; i<54; i++) {
				if(i%13 == 0)
					System.out.println();
				System.out.print(newCards[i]+" ");
			}
		}
	}