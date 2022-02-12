package forest;
import java.util.LinkedList;
import java.util.Scanner;
import forest.HNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Huffman {
	private String str;// �������ѹ�����ַ���    
    private HNode root;// �������������ĸ��ڵ�
    private boolean flag;// ����ַ��Ƿ��Ѵ���
    private LinkedList<CharData> charList;// �洢��ͬ�ַ��Ķ��� ��ͬ�ַ�����ͬһλ��
    private LinkedList<HNode> NodeList;// �洢�ڵ�Ķ���
    private class CharData // ��CharData����ͳ�Ƴ��ֵ��ַ��͸���
    {
         int num = 1; // �ַ�����
         char c; // �ַ�
         public CharData(char ch)
         {
             c = ch;
         }
    }
    //ͳ���ַ������ַ��Լ��ַ��ĳ��ִ���
    private void getCharNum(String str) 
    {
    	for (int i = 0; i < str.length(); i++) 
    	{
            char ch = str.charAt(i); // �Ӹ������ַ�����ȡ���ַ�
            flag = true;
            for (int j = 0; j < charList.size(); j++) 
            {
                CharData data = charList.get(j);
                if(ch == data.c) // �ַ���������������ͬ�ַ�
                { 
                   data.num++;//��������1
                   flag = false;
                   break;
                }
            }
            if(flag)// �ַ�����������û����ͬ�ַ�
            {
                charList.add(new CharData(ch));//�����¶����������
            }
    	}
    }
    //�����ֵ��ַ������ɵ����Ľ�����
    private void creatNodes() 
    {
    	for (int i = 0; i < charList.size(); i++) 
    	{
            String data = charList.get(i).c + "";
            int count = charList.get(i).num;
            HNode node = new HNode(data, count); // �����ڵ����
            NodeList.add(node); // ���뵽�ڵ�����
        }
    }
    //�Խڵ�Ȩֵ��������
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
    //������������
    private void creatTree() 
    {
    	while (NodeList.size() > 1)
    	{// ���ڵ���Ŀ����һʱ
            // 4.ȡ��Ȩֵ��С�������ڵ㣬����һ���µĸ��ڵ�
            // 5.ɾ��Ȩֵ��С�������ڵ㣬�����ڵ��ŵ��б���
            HNode left = NodeList.poll();
            HNode right = NodeList.poll();

            // �ڹ�����������ʱ���ø������Ĺ���������
            left.code = "0";
            right.code = "1";
            setCode(left);
            setCode(right);

            int parentWeight = left.count + right.count;// ���ڵ�Ȩֵ�����ӽڵ�Ȩֵ֮��
            HNode parent = new HNode(parentWeight, left, right);

            NodeList.addFirst(parent); // �����ڵ�������λ
            Sort(NodeList); // �������򣬱����½ڵ�Ȩֵ���������׸�����Ȩֵ
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
        creatTree();//������������
        root = NodeList.get(0);
    }
    //����Ϊ����
    private void setCode(HNode root) //����
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
    public void output() //���
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
                hfmCodeStr += root.code; // �ҵ��ַ����������������ƴ�ӵ����շ��ض������ַ����ĺ���
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
    public String toHufmCode(String str) // �������������ӳɵ��ַ���
    {
    	for (int i = 0; i < str.length(); i++) 
        {
            String c = str.charAt(i) + "";
            search(root, c);
        }
        return hfmCodeStr;
    }
    //����Ϊ����
    
    String result="";// ���������ַ���
    boolean target = false; // ������
    private void matchCode(HNode root, String code)//ƥ���ַ����������룬�ҵ���Ӧ���ַ�
    {
        if (root.lChild == null && root.rChild == null) 
        {
            if (code.equals(root.code)) 
            {
                result += root.data; // �ҵ���Ӧ���ַ���ƴ�ӵ������ַ�����
                target = true; // ��־��Ϊtrue
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
    public String CodeToString(String codeStr) //����
    {
        int start = 0;
        int end = 1;
        while(end <= codeStr.length())
        {
            target = false;
            String s = codeStr.substring(start, end);
            matchCode(root, s); // ����
            // ÿ����һ���ַ���start�����
            if(target)
                start = end;
            end++;
        }
        return result;
    }
    public static void main(String[] args) {
    	Huffman huff = new Huffman();// ��������������
    	/*System.out.println("�������ַ���:");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
        huff.creatHfmTree(str);// ������
        huff.output(); // ��ʾ�ַ��Ĺ���������
        // ��Ŀ���ַ����������ɺõĹ������������ɶ�Ӧ�Ķ����Ʊ���
        String hufmCode = huff.toHufmCode(str); 
        System.out.println("����:" + hufmCode);
        // �����������Ʊ����ٷ�����ַ���
        System.out.println("���룺" + huff.CodeToString(hufmCode));*/

		File filePath = new File("E:\\360MoveData\\Users\\10317\\Desktop\\DataStructur--lxh\\datafile.txt");   //��ȫ�����ļ�
		String s = null;  
		try {    //��ȡ�ļ���ÿһ��
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((s = br.readLine()) != null) {
				 huff.creatHfmTree(s);// ������
				 huff.output();// ��ʾ�ַ��Ĺ���������
				// ��Ŀ���ַ����������ɺõĹ������������ɶ�Ӧ�Ķ����Ʊ���
				 String hufmCode = huff.toHufmCode(s); 
			     System.out.println("����:" + hufmCode);
			     // �����������Ʊ����ٷ�����ַ���
			     System.out.println("���룺" + huff.CodeToString(hufmCode)); 
			}
			System.out.println("Done!");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}        
    }
}
