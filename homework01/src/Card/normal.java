package Card;

class Cards3 {
	public String card(int index) {
		String[] s = {"鈾�","鈾�","鈾�","鈾�"};
		String[] n = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String str1 = "";
		str1 += s[index%4]+n[index%13]; //鐢熸垚涓�寮犵墝
		return str1;
	}
	public String[] shuffle(String[] cards) {
	
		//鍦ㄥ悓涓�涓暟缁勪腑娲楃墝
		String[] changed = new String[54];
		int size = 0;
		int size1 = (int)(Math.random()*(28-22)+22); //闅忔満浜х敓22-28鑼冨洿鐨勭墝
		int size2 = 54-size1;
		int num = Math.min(size1,size2);
		int nums1 = 0, nums2 = size1;
		while(size < 2*num) {
			//闅忔満浜х敓0-4寮犵墝
			int putl = (int)(Math.random()*(4-0)+0);
			int putr = (int)(Math.random()*(4-0)+0);
			for(int i=nums1, n=0; nums1<size1 && n<putl; i++) {
				changed[size++] = cards[i];
				nums1++;
				n++;
			}
			for(int j=nums2, m=0; nums2<2*num && m<putr; j++) {
				changed[size++] = cards[j];
				nums2++;
				m++;
			}
		}
		//澶嶅埗鍓╀綑鏁扮粍鍏冪礌
		for(int k=2*num; size<54; k++) {
			changed[size++] = cards[k];
		}
		return changed;
	}
}
public class normal {
	public static void main(String[] args) {
		Cards3 c = new Cards3();
		System.out.println("鍘熷厛鐨勭墝锛�");
		String[] cards = new String[54];
		for(int i=0; i<52; i++) {
			cards[i] = c.card(i);
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