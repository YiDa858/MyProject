import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Student_Management {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(Path.of("D:\\Microsoft VS Code\\CODE_FIELD\\C_SINGLE\\exercise\\history.txt"),StandardCharsets.UTF_8);	//���ڶ�ȡ
		PrintWriter out=new PrintWriter("D:\\Microsoft VS Code\\CODE_FIELD\\C_SINGLE\\exercise\\history.txt",StandardCharsets.UTF_8);	//����д��
		in.close();
		out.close();
	}

}
