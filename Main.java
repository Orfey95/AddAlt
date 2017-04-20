import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> workFile;
    static int numberString = -1;
    
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scannerDir = new Scanner(System.in);
                System.out.println("Input directory or file name(.md) or input exit for close program:");
                String dirOrFile = scannerDir.next();
                if (dirOrFile.compareTo("exit") == 0 || dirOrFile.compareTo("Exit") == 0 || dirOrFile.compareTo("EXIT") == 0)
                    break;
                File userFile = new File(dirOrFile);
                if (getFileExtension(userFile).compareTo("md") != 0 && getFileExtension(userFile).compareTo("") != 0) {
                    System.out.println("Incorrect input");
                }
                if (getFileExtension(userFile).compareTo("md") == 0) {
                    ReadMDFile(dirOrFile);
                    for (int i = numberString + 1; i < workFile.size(); i++)
                        ReplaceStringInList();
                    SaveMDFile(dirOrFile);
                }
                if (getFileExtension(userFile).compareTo("") == 0) {
                    processFilesFromFolder(userFile);
                }
            }
            catch (Exception e){
                System.out.println("Incorrect input");
            }            
        }
    }
    
    static void processFilesFromFolder(File folder) throws IOException{
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }
 
            if (getFileExtension(entry).compareTo("md") == 0) {
                System.out.println(entry.getPath());
                ReadMDFile(entry.getPath());
                for (int i = numberString + 1; i < workFile.size(); i++)
                    ReplaceStringInList();
                SaveMDFile(entry.getPath());
                numberString = -1;
                workFile.clear();
            }
        }
    }

private static String getFileExtension(File file) {
    String fileName = file.getName();
    // если в имени файла есть точка и она не является первым символом в названии файла
    if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
    // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
    return fileName.substring(fileName.lastIndexOf(".")+1);
    // в противном случае возвращаем заглушку, то есть расширение не найдено
    else return "";
    }

    static void ReplaceStringInList(){
        String tempStr;
        tempStr = SearchImagesInMDFile();
        if(tempStr.compareTo("0") != 0) {
            tempStr = EditMDFile(tempStr);
            workFile.set(numberString, tempStr);
        }
    }
    
    static void ReadMDFile(String fileName)throws IOException {
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
            String[] masWithSplit = wordImg.split("/");
            wordImg = masWithSplit[masWithSplit.length-1];
            wordImg = wordImg.replace('-', ' ');
            wordImg = wordImg.replace('_', ' ');
            wordImg = wordImg.substring(0, 1).toUpperCase() + wordImg.substring(1);
            System.out.println(wordImg);
        } else {
            System.out.println("Error with second matcher");
        }
        tegStr = tegStr.replaceAll(m.group(1), wordImg);
        return tegStr;
    }

    static void SaveMDFile(String path) throws IOException {
        Files.write(Paths.get(path), workFile);
    }

}
