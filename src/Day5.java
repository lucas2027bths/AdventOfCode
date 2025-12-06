import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day5 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5");
        class Range {
            public long min = 0;
            public long max = 0;

            public Range(long min, long max) {
                this.min = min;
                this.max = max;
            }
        }
        ArrayList<Range> ranges = new ArrayList<>();
        int i = 0;
        long amountOfFresh = 0;
        String currentInstruction = "n/a";
        while (i < fileData.size()) {
            currentInstruction = fileData.get(i);
            if (!currentInstruction.isEmpty()) {
                long min = Long.parseLong(currentInstruction.split("-")[0]);
                long max = Long.parseLong(currentInstruction.split("-")[1]);
                ranges.add(new Range(min, max));
                i++;
            } else {
                break;
            }
        }
        ranges.sort(Comparator.comparingLong(r -> r.min)); // I found out you can sort objects by using a comparator to tell it exactly what to sort by / compare which is cool. hopefully I just remember this for later since this is super helpful
        long currentMin = ranges.get(0).min;
        long currentMax = ranges.get(0).max;
        for (int x = 1; x < ranges.size(); x++) { //this took me 4 hours i hate math
            Range r = ranges.get(x);
            if (r.min <= currentMax + 1) {
                currentMax = Math.max(currentMax, r.max);
            } else {
                amountOfFresh += (currentMax - currentMin + 1);
                currentMin = r.min;
                currentMax = r.max;
            }
        }
        amountOfFresh += (currentMax - currentMin + 1);

        System.out.println(amountOfFresh);
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
