import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day32016 {
    static void main() {
        ArrayList<String> fileData = getFileData("src/data2016day3");
        int counter = 0;
        for (int i = 0; i < fileData.size(); i+=3) {
            int a = Integer.parseInt(fileData.get(i));
            int b = Integer.parseInt(fileData.get(i+1));
            int c = Integer.parseInt(fileData.get(i+2));
            if (a + b > c && a + c > b && b + c > a) {
                counter++;
            };
        }
        System.out.println(counter);
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line.split(" {2,}")[1]);
            }
            Scanner d = new Scanner(f);
            while (d.hasNextLine()) {
                String line = d.nextLine();
                if (!line.isEmpty())
                    fileData.add(line.split(" {2,}")[2]);
            }
            Scanner x = new Scanner(f);
            while (x.hasNextLine()) {
                String line = x.nextLine();
                if (!line.isEmpty())
                    fileData.add(line.split(" {2,}")[3]);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
