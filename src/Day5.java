import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Day5 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5");
        ArrayList<Long> mins = new ArrayList<>();
        ArrayList<Long> maxs = new ArrayList<>();
        int i = 0;
        long amountOfFresh = 0;
        String currentInstruction = "n/a";
            while (i < fileData.size()) {
                currentInstruction = fileData.get(i);
                if (!currentInstruction.isEmpty()){
                    long min = Long.parseLong(currentInstruction.split("-")[0]);
                    long max = Long.parseLong(currentInstruction.split("-")[1]);
                    mins.add(min);
                    maxs.add(max);
                    i++;
                }else{
                    break;
                }
            }
            Collections.sort(mins);
        Collections.sort(maxs);
        for (int x = 0; x < maxs.size(); x++){
            long currentMax = maxs.get(x);
            long currentMin = mins.get(x);
            if (x>0 && currentMin < maxs.get(x-1)){
                currentMin = maxs.get(x-1);
                currentMin+=1;
            }
            amountOfFresh+= Math.abs(currentMin-currentMax) + 1;
            if (x>0 && currentMin == maxs.get(x-1)){
                amountOfFresh-=1;
            }
        }
        System.out.println(amountOfFresh);
        System.out.println(mins);
        System.out.println(maxs);
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
