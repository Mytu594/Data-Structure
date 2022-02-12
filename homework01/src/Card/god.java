package Card;

class Cards{
	public String card(int index) {
		String[] s = {"鈾�","鈾�","鈾�","鈾�"};
		String[] n = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String str1 = "";
		str1 += s[index%4]+n[index%13]; //鐢熸垚涓�寮犵墝
		return str1;
	}
}
public class god extends Cards {

	public String[] shuffle(String[] cards) {
		String[] changed = new String[54];
		int N=52;
		for(int i=0,j=N-1,cnt=0;cnt<54;i++,j--,cnt++) {
			changed[cnt] = cards[i];
			changed[++cnt]=cards[j];
		}
		return changed;
	}
	public static void main(String[] args) {
		Cards2 c = new Cards2();
		System.out.println("鍘熷厛鐨勭墝锛�");
		String[] cards = new String[54];
		for(int i=0; i<52; i++) {
			cards[i] = c.card(i);
			//姣忔杈撳嚭13寮犵墝
			if(i%13 == 0)
				System.out.println();
			System.out.print(cards[i]+" ");
		}
		cards[52]="澶х帇";
		cards[53]="灏忕帇";
		System.out.println(cards[52]+" "+cards[53]);
		System.out.println("娲楀悗鐨勭墝锛�");
		String[] newCards = new String[54];
		newCards = c.shuffle(cards);
		for(int i=0; i<54; i++) {
			if(i%13 == 0)
				System.out.println();
			System.out.print(newCards[i]+" ");
		}
	}
}