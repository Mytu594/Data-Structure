package Card;

class Cards2 {
	public String card(int index) {
		String[] s = {"鈾�","鈾�","鈾�","鈾�"};
		String[] n = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String str1 = "";
		str1 += s[index%4]+n[index%13]; //鐢熸垚涓�寮犵墝
		return str1;
	}
	public String[] shuffle(String[] cards) {
		//鍦ㄥ悓涓�涓暟缁勪腑娲楃墝
		int size1 = (int)(Math.random()*(28-22)+22); //闅忔満浜х敓22-28鑼冨洿鐨勭墝
		int size2 = 54 - size1;
		String[] changed = new String[54];
		int p = Math.min(size1,size2);
		int size = 1;
		int i = 0;
		int j = p;
		while(size<2*p && i<p && j<54) {
			changed[size-1] = cards[i];
			changed[size] = cards[j];
			size += 2;
			i++;
			j++;
		}
		//澶嶅埗鍓╀綑鏁扮粍鍏冪礌
		for(int k=2*p; size<54; k++) {
			changed[size++] = cards[k];
		}
		return changed;
	}
}
public class profession {
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