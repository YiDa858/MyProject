
public class main {
	//KMP�㷨�����߼���str��������pattern��ģʽ��
	public static int kmp(String str,String pattern)
	{
	    //Ԥ��������next����
	    int[] next=getNexts(pattern);
	    int j=0;
	    //��ѭ�����������ַ���
	    for(int i=0;i<str.length();i++)
	    {
	        while(j>0&&str.charAt(i)!=pattern.charAt(j))
	        {
	            //�������ַ�ʱ����ѯnext���鲢�ı�ģʽ�������
	            j=next[j];
	        }
	        if(str.charAt(i)==pattern.charAt(j))
	        {
	            j++;
	        }
	        if(j==pattern.length())
	        {
	            //ƥ��ɹ��������±�
	            return i-pattern.length()+1;
	        }
	    }
	    return -1;
	}
	//����next����
	private static int[] getNexts(String pattern)
	{
	    int[] next=new int[pattern.length()];
	    int j=0;
	    for(int i=2;i<pattern.length();i++)
	    {
	        while(j!=0&&pattern.charAt(j)!=pattern.charAt(i-1))
	        {
	            //��next[i+1]�������ݵ�next[j]
	            j=next[j];
	        }
	        if(pattern.charAt(j)==pattern.charAt(i-1))
	        {
	            j++;
	        }
	        next[i]=j;
	    }
	    return next;
	}

	public static void main(String[] args)
	{
	    String str="ATGTGAGCTGGTGTGTGCFAA";
	    String pattern="GTGTGCF";
	    int index=kmp(str,pattern);
	    System.out.println("�״γ��ֵ�λ��:"+index);
	}

}
