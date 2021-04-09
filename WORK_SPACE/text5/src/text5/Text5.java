package text5;

import java.util.Scanner;

public class Text5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s=in.nextLine();
		int flag=0;
		int ret=0;
		char[] m=s.toCharArray();
		int ml=m.length;
		for(char a:m)
		{
			if(a==' ')flag++;
			ret++;
			if(flag==2)break;
		}
		switch(m[ret])
		{
			case 'a':m[ret]='A';break;
			case 'b':m[ret]='B';break;
			case 'c':m[ret]='C';break;
			case 'd':m[ret]='D';break;
			case 'e':m[ret]='E';break;
			case 'f':m[ret]='F';break;
			case 'g':m[ret]='G';break;
			case 'h':m[ret]='H';break;
			case 'i':m[ret]='I';break;
			case 'j':m[ret]='J';break;
			case 'k':m[ret]='K';break;
			case 'l':m[ret]='L';break;
			case 'm':m[ret]='M';break;
			case 'n':m[ret]='N';break;
			case 'o':m[ret]='O';break;
			case 'p':m[ret]='P';break;
			case 'q':m[ret]='Q';break;
			case 'r':m[ret]='R';break;
			case 's':m[ret]='S';break;
			case 't':m[ret]='T';break;
			case 'u':m[ret]='U';break;
			case 'v':m[ret]='V';break;
			case 'w':m[ret]='W';break;
			case 'x':m[ret]='X';break;
			case 'y':m[ret]='Y';break;
			case 'z':m[ret]='Z';break;
		}
		int i=0;
		char p[]=new char[ml];
		int q=ret;
		for(i=0;ret<ml;i++)
		{
			if(m[ret]=='.')
			{
				p[i++]=',';
				break;
			}
			p[i]=m[ret++];
		}
		switch(m[0])
		{
			case 'A':m[0]='a';break;
			case 'B':m[0]='b';break;
			case 'C':m[0]='c';break;
			case 'D':m[0]='d';break;
			case 'E':m[0]='e';break;
			case 'F':m[0]='f';break;
			case 'G':m[0]='g';break;
			case 'H':m[0]='h';break;
			case 'I':m[0]='i';break;
			case 'J':m[0]='j';break;
			case 'K':m[0]='k';break;
			case 'L':m[0]='l';break;
			case 'M':m[0]='m';break;
			case 'N':m[0]='n';break;
			case 'O':m[0]='o';break;
			case 'P':m[0]='p';break;
			case 'Q':m[0]='q';break;
			case 'R':m[0]='r';break;
			case 'S':m[0]='s';break;
			case 'T':m[0]='t';break;
			case 'U':m[0]='u';break;
			case 'V':m[0]='v';break;
			case 'W':m[0]='w';break;
			case 'X':m[0]='x';break;
			case 'Y':m[0]='y';break;
			case 'Z':m[0]='z';break;
		}
		for(int w=0;w<q;w++)
		{
			p[i++]=m[w];
		}
		p[--i]='?';
		for(char o:p)
		{
			System.out.print(o);
		}
	}

}
