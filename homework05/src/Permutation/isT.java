package Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//判断能否通过栈获得 
public class isT {
	public void isOrnot(String str) {
		String[] strs = str.split("");
		int i;
		for (i = strs.length - 1; i > 0; i--) {  //遍历新的字符串，从右边开始
			int behind = Integer.parseInt(strs[i]);
			int former = Integer.parseInt(strs[i - 1]);   //将字符串转换为数字
			if (former - behind >= 2 ) {    //当前面的数字比后面的数字大2以上
				int cnt = former - behind - 1;     //behind和former中间的数
				for (int j = 0; j < i - 1; j++) {    //在此数前面找有没有在former和behind的数
					int num = Integer.parseInt(strs[j]);
					if (num > behind && num < former ) {   
						cnt--;   
					}
				}
				if (cnt == 0)     //所有中间的数都在前面出现过
					continue;
				else {        //中间数没出现，写入“不可以通过栈获得.txt”文件中
					try {
						FileWriter fw=new FileWriter("h:\\不可以通过栈获得.txt",true);
				        fw.append(new String(str)+'\n');
				        fw.close();
				        break;
						}catch(Exception e) {
							e.printStackTrace();
						}
					break;    //终止遍历
				}
			}
		}
		if (i == 0) {   //可以通过栈获得的，写入"d:\\可以通过栈获得.txt"
			//将可以通过的放入一个文件里面
			try {
				FileWriter fw=new FileWriter("g:\\可以通过栈获得.txt",true);
				fw.append(new String(str)+'\n');
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		isT T = new isT();
		File filePath = new File("h:\\file.txt");   //打开全排列文件
		String s = null;  
		try {    //读取文件的每一行
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

