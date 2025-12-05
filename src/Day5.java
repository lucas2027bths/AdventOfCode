import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day5 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5");
        ArrayList<Long> numbers = new ArrayList<>();
        int i = 0;
        int amountOfFresh = 0;
        String currentInstruction = "n/a";
            while (i < fileData.size()) {
                currentInstruction = fileData.get(i);
                if (!currentInstruction.isEmpty()){
                    i++;
                }else{
                    break;
                }
            }
        for (int x = i+1; x < fileData.size(); x++){
            currentInstruction = fileData.get(x);
            long num = Long.parseLong(currentInstruction);
            numbers.add(num);
        }
        for (int y = 0; y < fileData.size(); y++){
            currentInstruction = fileData.get(y);
            if (!currentInstruction.isEmpty()){
                long min = Long.parseLong(currentInstruction.split("-")[0]);
                long max = Long.parseLong(currentInstruction.split("-")[1]);
                for (int z = 0; z < numbers.size(); z++){
                    if (numbers.get(z) >= min && numbers.get(z)<=max){
                        numbers.remove(z);
                        z-=1;
                        amountOfFresh+=1;
                    }
                }
            }else{
                break;
            }
        }
        System.out.println(numbers);
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
