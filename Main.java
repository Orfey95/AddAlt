import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> workFile;
    public static void main(String[] args) throws IOException {

        ReadMDFile();
        //System.out.println(workFile.get(20));
        SearchImagesInMDFile();
        //SaveMDFile(); 
    }

    static void ReadMDFile()throws IOException {
        String fileName = "src\\testFile.md";
        workFile = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
    }
    static String SearchImagesInMDFile(){
        String currentStr = "";
        String strImg = "";
        for (int i = 0; i < workFile.size(); i++){
            currentStr = workFile.get(i);
            if (CheckStr(currentStr)){
                strImg = currentStr;
                System.out.println(strImg);
                return strImg;
            }
        }
        return "0";
    }

    static boolean CheckStr(String currentStr) {
        Pattern p = Pattern.compile("^(.+|)\\!\\[.+\\]\\(.+\\)");
        Matcher m = p.matcher(currentStr);
        return m.matches();
    }

    void EditMDFile(){
        ;
    }

    static void SaveMDFile() throws IOException {
        Files.write(Paths.get("src\\out.md"), workFile);
    }
}
