import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

     static List<String> workFile;
    public static void main(String[] args) throws IOException {

        ReadMDFile();
        System.out.println(workFile.get(20));
        SaveMDFile();
    }

   static void ReadMDFile()throws IOException {
        String fileName = "src\\testFile.md";
       workFile = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
    }
	void SearchImagesInMDFile(){
	;
	}
	void EditMDFile(){
	;
	}
	  static void SaveMDFile() throws IOException {
        Files.write(Paths.get("src\\out.md"), workFile);
    }
}
