package Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//�ж��ܷ�ͨ��ջ��� 
public class isT {
	public void isOrnot(String str) {
		String[] strs = str.split("");
		int i;
		for (i = strs.length - 1; i > 0; i--) {  //�����µ��ַ��������ұ߿�ʼ
			int behind = Integer.parseInt(strs[i]);
			int former = Integer.parseInt(strs[i - 1]);   //���ַ���ת��Ϊ����
			if (former - behind >= 2 ) {    //��ǰ������ֱȺ�������ִ�2����
				int cnt = former - behind - 1;     //behind��former�м����
				for (int j = 0; j < i - 1; j++) {    //�ڴ���ǰ������û����former��behind����
					int num = Integer.parseInt(strs[j]);
					if (num > behind && num < former ) {   
						cnt--;   
					}
				}
				if (cnt == 0)     //�����м��������ǰ����ֹ�
					continue;
				else {        //�м���û���֣�д�롰������ͨ��ջ���.txt���ļ���
					try {
						FileWriter fw=new FileWriter("h:\\������ͨ��ջ���.txt",true);
				        fw.append(new String(str)+'\n');
				        fw.close();
				        break;
						}catch(Exception e) {
							e.printStackTrace();
						}
					break;    //��ֹ����
				}
			}
		}
		if (i == 0) {   //����ͨ��ջ��õģ�д��"d:\\����ͨ��ջ���.txt"
			//������ͨ���ķ���һ���ļ�����
			try {
				FileWriter fw=new FileWriter("g:\\����ͨ��ջ���.txt",true);
				fw.append(new String(str)+'\n');
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		isT T = new isT();
		File filePath = new File("h:\\file.txt");   //��ȫ�����ļ�
		String s = null;  
		try {    //��ȡ�ļ���ÿһ��
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				T.isOrnot(s);
			}
			System.out.println("Done!");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

