import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {

    static  String workFile;
    public static void main(String[] args) throws IOException {

        ReadMDFile();
        System.out.println(workFile);
    }

   static void ReadMDFile()throws IOException {
        String fileName = "src\\testFile.md";
       workFile = new String(Files.readAllBytes(Paths.get(fileName)));
    }
	void SearchImagesInMDFile(){
	;
	}
	void EditMDFile(){
	;
	}
	void SaveMDFile(){
	    ;
	}
}
