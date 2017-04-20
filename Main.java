import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static List<String> workFile;
  static int numberString = -1;
    public static void main(String[] args) throws IOException {
        ReadMDFile();
        for(int i = numberString + 1; i<workFile.size(); i++)
            ReplaceStringInList();
        SaveMDFile();
    }

    static void ReplaceStringInList(){
        String tempStr;
        tempStr = SearchImagesInMDFile();
        if(tempStr.compareTo("0") != 0) {
            tempStr = EditMDFile(tempStr);
            workFile.set(numberString, tempStr);
        }
    }
   static void ReadMDFile()throws IOException {
        String fileName = "src\\testFile.md";
       workFile = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
    }

    static String SearchImagesInMDFile(){
        String currentStr = "";
        String strImg = "";
        for (int i = numberString + 1; i < workFile.size(); i++){
            currentStr = workFile.get(i);
            if (CheckStr(currentStr)){
                numberString = i;
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

    static String EditMDFile(String tegStr){
        Pattern p = Pattern.compile("\\s*\\!\\[(.+)\\](.+)");
        Matcher m = p.matcher(tegStr);
        if (m.matches()) {
            System.out.println(m.group(1));
        } else {
            System.out.println("Error with first matcher");
        }

        Pattern p1 = Pattern.compile("(\\/).+(\\.)");
        Matcher m1 = p1.matcher(tegStr);
        String wordImg = "";
        if(m1.find()){
            wordImg = m1.group();
            wordImg = wordImg.substring(0, wordImg.length()-1);
            String[] am = wordImg.split("/");
            wordImg = am[am.length-1];
            wordImg = wordImg.replace('-', ' ');
            wordImg = wordImg.substring(0, 1).toUpperCase() + wordImg.substring(1);
            System.out.println(wordImg);
        } else {
            System.out.println("Error with second matcher");
        }
        tegStr = tegStr.replaceAll(m.group(1), wordImg);
        return tegStr;
    }

    static void SaveMDFile() throws IOException {
        Files.write(Paths.get("src\\out.md"), workFile);
    }

}
