import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day3");
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            System.out.println(findLargest(currentInstruction));
        }
    }

public static String findLargest(String currentInst){
        int firstMax = 0;
        int nextMax = 0;
        int firstPos = 0;
        int secondPos = 0;
    for (int i = 0; i < currentInst.length(); i++) {
        int currentNum = Integer.parseInt(currentInst.substring(i,i+1));
        if (currentNum > firstMax){
            firstMax = currentNum;
            firstPos = i;
        }
    }
    System.out.println("first pos" + firstPos);
    for (int i = 0; i < currentInst.length(); i++) {
        int currentNum = Integer.parseInt(currentInst.substring(i,i+1));
        if (currentNum < firstMax && currentNum > nextMax ){
            nextMax = currentNum;
            secondPos = i;
        }
    }
    if (secondPos < firstPos){
        int tmp = firstMax;
        firstMax = nextMax;
        nextMax = tmp;
    }

    return "" + firstMax + nextMax ;
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
