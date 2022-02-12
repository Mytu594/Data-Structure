package forest;
import java.util.LinkedList;
import java.util.Scanner;
import forest.HNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Huffman {
	private String str;// 最初用于压缩的字符串    
    private HNode root;// 哈夫曼二叉树的根节点
    private boolean flag;// 标记字符是否已存在
    private LinkedList<CharData> charList;// 存储不同字符的队列 相同字符存在同一位置
    private LinkedList<HNode> NodeList;// 存储节点的队列
    private class CharData // 以CharData类来统计出现的字符和个数
    {
         int num = 1; // 字符个数
         char c; // 字符
         public CharData(char ch)
         {
             c = ch;
         }
    }
    //统计字符串中字符以及字符的出现次数
    private void getCharNum(String str) 
    {
    	for (int i = 0; i < str.length(); i++) 
    	{
            char ch = str.charAt(i); // 从给定的字符串中取出字符
            flag = true;
            for (int j = 0; j < charList.size(); j++) 
            {
                CharData data = charList.get(j);
                if(ch == data.c) // 字符对象链表中有相同字符
                { 
                   data.num++;//将个数加1
                   flag = false;
                   break;
                }
            }
            if(flag)// 字符对象链表中没有相同字符
            {
                charList.add(new CharData(ch));//创建新对象加入链表
            }
    	}
    }
    //将出现的字符创建成单个的结点对象
    private void creatNodes() 
    {
    	for (int i = 0; i < charList.size(); i++) 
    	{
            String data = charList.get(i).c + "";
            int count = charList.get(i).num;
            HNode node = new HNode(data, count); // 创建节点对象
            NodeList.add(node); // 加入到节点链表
        }
    }
    //对节点权值升序排序
    private void Sort(LinkedList<HNode> nodelist) 
    {
        for (int i = 0; i < nodelist.size() - 1; i++) 
        {
            for (int j = i + 1; j < nodelist.size(); j++) 
            {
                HNode temp;
                if (nodelist.get(i).count > nodelist.get(j).count)
                {
                    temp = nodelist.get(i);
                    nodelist.set(i, nodelist.get(j));
                    nodelist.set(j, temp);
                }
            }
        }
    }
    //构建哈夫曼树
    private void creatTree() 
    {
    	while (NodeList.size() > 1)
    	{// 当节点数目大于一时
            // 4.取出权值最小的两个节点，生成一个新的父节点
            // 5.删除权值最小的两个节点，将父节点存放到列表中
            HNode left = NodeList.poll();
            HNode right = NodeList.poll();

            // 在构建哈夫曼树时设置各个结点的哈夫曼编码
            left.code = "0";
            right.code = "1";
            setCode(left);
            setCode(right);

            int parentWeight = left.count + right.count;// 父节点权值等于子节点权值之和
            HNode parent = new HNode(parentWeight, left, right);

            NodeList.addFirst(parent); // 将父节点置于首位
            Sort(NodeList); // 重新排序，避免新节点权值大于链表首个结点的权值
        }
    }
    public void creatHfmTree(String str) 
    {
        this.str = str;
        NodeList = new LinkedList<HNode>();
        charList = new LinkedList<CharData>();
        getCharNum(str);
        creatNodes();
        Sort(NodeList);
        creatTree();//构建哈夫曼树
        root = NodeList.get(0);
    }
    //以上为建树
    private void setCode(HNode root) //编码
    {
    	if (root.lChild != null) 
    	{
            root.lChild.code = root.code + "0";
            setCode(root.lChild);
        }
        if (root.rChild != null)
        {
            root.rChild.code = root.code + "1";
            setCode(root.rChild);
        }
    }
    private void output(HNode node)
    {
    	if (node.lChild == null && node.rChild == null) 
    	{
            System.out.println(node.data + ": " + node.code);
        }
        if (node.lChild != null) 
        {
            output(node.lChild);
        }
        if (node.rChild != null) 
        {
            output(node.rChild);
        }
    }
    public void output() //输出
    {
        output(root);
    }
    private String hfmCodeStr = "";
    private void search(HNode root, String c) 
    {
        if (root.lChild == null && root.rChild == null) 
        {
            if (c.equals(root.data)) 
            {
                hfmCodeStr += root.code; // 找到字符，将其哈夫曼编码拼接到最终返回二进制字符串的后面
            }
        }
        if (root.lChild != null) 
        {
            search(root.lChild, c);
        }
        if (root.rChild != null) 
        {
            search(root.rChild, c);
        }
    }
    public String toHufmCode(String str) // 哈夫曼编码连接成的字符串
    {
    	for (int i = 0; i < str.length(); i++) 
        {
            String c = str.charAt(i) + "";
            search(root, c);
        }
        return hfmCodeStr;
    }
    //以上为编码
    
    String result="";// 保存解码的字符串
    boolean target = false; // 解码标记
    private void matchCode(HNode root, String code)//匹配字符哈夫曼编码，找到对应的字符
    {
        if (root.lChild == null && root.rChild == null) 
        {
            if (code.equals(root.code)) 
            {
                result += root.data; // 找到对应的字符，拼接到解码字符穿后
                target = true; // 标志置为true
            }
        }
        if (root.lChild != null) 
        {
            matchCode(root.lChild, code);
        }
        if (root.rChild != null) 
        {
            matchCode(root.rChild, code);
        }
    }
    public String CodeToString(String codeStr) //解码
    {
        int start = 0;
        int end = 1;
        while(end <= codeStr.length())
        {
            target = false;
            String s = codeStr.substring(start, end);
            matchCode(root, s); // 解码
            // 每解码一个字符，start向后移
            if(target)
                start = end;
            end++;
        }
        return result;
    }
    public static void main(String[] args) {
    	Huffman huff = new Huffman();// 创建哈弗曼对象
    	/*System.out.println("请输入字符串:");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
        huff.creatHfmTree(str);// 构造树
        huff.output(); // 显示字符的哈夫曼编码
        // 将目标字符串利用生成好的哈夫曼编码生成对应的二进制编码
        String hufmCode = huff.toHufmCode(str); 
        System.out.println("编码:" + hufmCode);
        // 将上述二进制编码再翻译成字符串
        System.out.println("解码：" + huff.CodeToString(hufmCode));*/

		File filePath = new File("E:\\360MoveData\\Users\\10317\\Desktop\\DataStructur--lxh\\datafile.txt");   //打开全排列文件
		String s = null;  
		try {    //读取文件的每一行
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				 huff.creatHfmTree(s);// 构造树
				 huff.output();// 显示字符的哈夫曼编码
				// 将目标字符串利用生成好的哈夫曼编码生成对应的二进制编码
				 String hufmCode = huff.toHufmCode(s); 
			     System.out.println("编码:" + hufmCode);
			     // 将上述二进制编码再翻译成字符串
			     System.out.println("解码：" + huff.CodeToString(hufmCode)); 
			}
			System.out.println("Done!");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}        
    }
}
