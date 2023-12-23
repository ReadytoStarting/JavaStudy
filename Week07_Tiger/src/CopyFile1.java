import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try (FileReader in=new FileReader("C:\\Users\\DS\\Desktop\\text.txt");
			FileWriter out=new FileWriter("copy.txt")){
			int c;
			while ((c=in.read())!=-1) {
				out.write(c);
			}
		}
	}

}
