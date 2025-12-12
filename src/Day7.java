import javax.management.MBeanServerDelegateMBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day7 {
    ArrayList<String[]> data = new ArrayList<>();
    static long amountOfSplits = 0;
    public static ArrayList<String> fileData = getFileData("src/day7");
    public static void main() {
        ArrayList<String> fileData = getFileData("src/day7");
        int startPoint = fileData.getFirst().indexOf("S");
        Beam(startPoint, 0);
        System.out.println(amountOfSplits);
        for (int i = 0; i < fileData.size(); i++) {
            System.out.println(fileData.get(i));
        }
    }

    public static void Beam(int charIndex, int lineStart) {
        amountOfSplits++;
        for (int i = lineStart ; i < fileData.size(); i++) {
            String currentInst = fileData.get(i);
            if (currentInst.charAt(charIndex) == '|') {
                return;
            }
            if (currentInst.charAt(charIndex) == '^') {
                Beam(charIndex+1, i);
                Beam(charIndex-1, i);
                break;
            }
            fileData.set(i, currentInst.substring(0,charIndex) + "|"+ currentInst.substring(charIndex+1));
        }
    }



    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}