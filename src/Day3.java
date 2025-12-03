import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    static long sum = 0;
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day3");
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            findLargest(currentInstruction);
        }
        System.out.println(sum);
    }

public static void findLargest(String currentInst){
        long firstMax = 0;
    for (int i = 0; i < currentInst.length(); i++) {
        String currentNum = currentInst.substring(i, i + 1);
        String toParse;
        for (int x = i+1; x < currentInst.length(); x++) {
            toParse = currentNum;
            for (int p = x; p < currentInst.length(); p++) {
                if (toParse.length() < 12){
                    toParse += currentInst.substring(p,p+1);
                }else{
                    break;
                }
            }
            if (Long.parseLong(toParse) > firstMax){
                firstMax = Long.parseLong(toParse);
            }
        }
    }
    System.out.println(firstMax);
    sum+=firstMax;
}


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
