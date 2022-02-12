package stack_other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
//判断能否通过栈获得 
public class isT {
	public void isOrnot(String str) {
		String[] strs = str.split("");
		int i;
		for (i = strs.length - 1; i > 0; i--) {
			int behind = Integer.parseInt(strs[i]);
			int former = Integer.parseInt(strs[i - 1]);
			if (behind > former) {
				if (behind - former >= 2) {
					int cnt = behind - former -1;
					for (int j = 0; j < i - 1; j++) {
						int num = Integer.parseInt(strs[i - 1]);
						if (num < behind && num > former) {
							cnt--;
						}
					}
					if (cnt == 0)
						continue;
					else {
						System.out.println("不可以通过栈获得");
						break;
					}
				}
			}
		}
		if (i == 0) {
			//将可以通过的放入一个文件里面
			try {
			System.out.println(new String(str));
            FileWriter fw=new FileWriter("d:\\file6.txt",true);
            fw.append(new String(str)+'\n');
            fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("可以通过栈获得");
		}
	}
	public static void main(String[] args) {
		isT T = new isT();
		/*Scanner reader = new Scanner(System.in);
		String str = reader.next();
		reader.close();
		//T.isOrnot();*/
		File filePath = new File("D:\\file.txt");
		BufferedReader br;
		String s = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				System.out.println(s + "：");
				T.isOrnot(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
