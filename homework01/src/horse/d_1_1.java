package horse;

public class d_1_1 {
	public static void main(String[] args) {
		char[] s = {'a','b','c','d','e','f','g'};
		int rand = (int)(Math.random()*100+1);
		System.out.println("����Ԫ�ؾ��ƶ�"+rand+"��λ");
		Movement m = new Movement();
		m.move(s,rand);
		
		//�½�һ������
		/*char[] ch = new char[size];
		for(int i=0; i<size; i++) {
			ch[(i+rand)%size] = s[i];
		}
		for(char str:ch) {
			System.out.print(str+" ");
		}*/
		
	}
}
class Movement {
	public void move(char[] ch,int r) {
		for(int i=0; i<r; i++) {
			//�������ÿһ��Ԫ�������
			char temp = ch[ch.length-1];
			for(int j=ch.length-1; j>0; j--) {
				ch[j] = ch[j-1];
			}
			ch[0] = temp;
			for(int k=0; k<ch.length; k++) {
				System.out.print(ch[k]+" ");
			}
			System.out.println();
		}
	}
}