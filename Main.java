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
        //ReadMDFile();
        //SearchImagesInMDFile();
        //EditMDFile(SearchImagesInMDFile());
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

    static String EditMDFile(String tempStr){
        Pattern p = Pattern.compile("\\!\\[(.+)\\](.+)");
        Matcher m = p.matcher(tempStr);
        if (m.matches()) {
            System.out.println(m.group(1));
        } else {
            System.out.println("Error");
        }

        Pattern p1 = Pattern.compile("(\\/).+(\\.)");
        Matcher m1 = p1.matcher(tempStr);
        String a = "";
        if(m1.find()){
            a = m1.group();
            a = a.substring(0, a.length()-1);
            String[] am = a.split("/");
            a = am[am.length-1];
            a = a.replace('-', ' ');
            a = a.substring(0, 1).toUpperCase() + a.substring(1);
            System.out.println(a);
        } else {
            System.out.println("Error");
        }
        if(m.group(1).compareTo(a) != 0) {
            tempStr = tempStr.replaceAll(m.group(1), a);
        }
        return tempStr;
    }

    static void SaveMDFile() throws IOException {
        Files.write(Paths.get("src\\out.md"), workFile);
    }
}
