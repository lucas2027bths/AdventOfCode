import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day1");
        int currentPos = 50;
        int amountZero = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            String direction = currentInstruction.substring(0,1);
            int amount = Integer.parseInt(currentInstruction.substring(1));
            if (direction.equals("L")){
                for (int x = 0; x < amount; x++){
                   currentPos = MoveLeft(currentPos);
                    if (currentPos == 0){
                        amountZero++;
                    }
                }
            }
            if (direction.equals("R")){
                for (int x = 0; x < amount; x++){
                    currentPos = MoveRight(currentPos);
                    if (currentPos == 0){
                        amountZero++;
                    }
                }
            }
        }
        System.out.println(amountZero);
    }
    public static int MoveLeft(int currentPos){
        if (currentPos - 1 == -1){
           currentPos = 99;
        }else{
            currentPos -= 1;
        }
        return currentPos;
    }
    public static int MoveRight(int currentPos){
        if (currentPos + 1 == 100){
            currentPos = 0;
        }else{
            currentPos += 1;
        }
        return currentPos;
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
