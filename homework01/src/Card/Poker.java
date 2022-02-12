package Card;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 娲楃墝鎺掑簭
 */
public class Poker {
 
	public static void main(String[] args) {
 
		//鍑嗗鑺辫壊
		ArrayList<String> color = new ArrayList<String>();
		color.add("鈾�");
		color.add("鈾�");
		color.add("鈾�");
		color.add("鈾�");
		
		//鍑嗗鏁板瓧
		ArrayList<String> number = new ArrayList<String>();
		Collections.addAll(number,"A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		//瀹氫箟涓�涓猰ap闆嗗悎锛氱敤鏉ュ皢鏁板瓧涓庢瘡涓�寮犵墝杩涜瀵瑰簲
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		int index = 0;
		for (String thisNumber : number) {
			for (String thisColor : color) {
				map.put(index++, thisColor+thisNumber);
			}
		}		
		//鍔犲叆澶у皬鐜�
		map.put(index++, "灏忕帇");
		map.put(index++, "澶х帇");
		
		//涓�鍓�54寮犵殑鐗� ArrayList閲岃竟涓�0-53鐨勬暟鐨勬柊鐗�
		ArrayList<Integer> cards = new ArrayList<Integer>();
		
		for (int i = 0; i <= 53; i++) {
			cards.add(i);
		}
		//瀵瑰簲鏁板瓧褰㈠紡娌℃礂涔嬪墠鐨勭墝锛屽畾涔夊瓧绗︿覆褰㈠紡鐨勭墝
		ArrayList<String> sBefore = new ArrayList<String>();
		for (Integer key : cards) {
			sBefore.add(map.get(key));
		}
		//鐪嬬墝
		System.out.println("娲楃墝鍓�"+sBefore);
		
		//娲楃墝
		Collections.shuffle(cards);
		
		//鍒涘缓娲楀ソ鐨勭墝
		ArrayList<Integer> after = new ArrayList<Integer>();
		
		//閬嶅巻杩欏壇娲楀ソ鐨勭墝锛岄亶鍘嗕竴閬�
		for (int i = 0; i < cards.size(); i++) {
					after.add(cards.get(i));
			}
		
		//瀵瑰簲鏁板瓧褰㈠紡娲楀ソ涔嬪悗鐨勭墝锛屽畾涔夊瓧绗︿覆褰㈠紡鐨勭墝
		
		ArrayList<String> sAfter = new ArrayList<String>();
		
		for (Integer key1 : after) {
			sAfter.add(map.get(key1));
		}
		//鐪嬬墝
		System.out.println("娲楃墝鍚�"+sAfter);	
	}
}
