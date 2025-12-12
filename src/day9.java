import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day9 {
    void main(){
        ArrayList<String> fileData = getFileData("src/day9");
        long currentMax = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String currentInst = fileData.get(i);
            int length = Integer.parseInt(currentInst.split(",")[0]);
            int width  = Integer.parseInt(currentInst.split(",")[1]);
            for (int x = i+1; x < fileData.size() - 1; x++) {
                String thisIsnt = fileData.get(x);
                int thislength = Integer.parseInt(thisIsnt.split(",")[0]);
                int thiswidth  = Integer.parseInt(thisIsnt.split(",")[1]);
                int resultingLength = Math.abs(thislength - length)+1;
                int resultingWidth= Math.abs(thiswidth - width)+1;

                long resultingArea = (long) resultingLength *resultingWidth;
                if (resultingArea > currentMax) {
                    currentMax = resultingArea;
                }
            }
        }
        System.out.println(currentMax);
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
