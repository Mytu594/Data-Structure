package Permutation;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Arrange {	
	static int[] bits=new int[] {1,2,3,4,5};
	public static void main(String[] args) throws IOException{
		sort("",bits);
		System.out.println("Done");
	}
	private static void sort(String prefix,int[] a) {
		if(a.length==1) {
			try {      //向文件中写入
				File file=new File("g:\\file1.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(prefix+a[0]+"\n");
				bw.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<a.length;i++) {
			sort(prefix+a[i],copy(a,i));
		}
	}
	private static int[] copy(int[] a,int index) {
		int[] b=new int[a.length-1];
		System.arraycopy(a, 0, b, 0, index);
		System.arraycopy(a,index+1,b,index,a.length-index-1);
		return b;
	}
}