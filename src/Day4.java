import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day4 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day4");
        long sum = 0;
        long oldersum = -1;
        while (sum > oldersum) {
            oldersum = sum;
            for (int i = 0; i < fileData.size(); i++) {
                String currentinstruction = fileData.get(i);
                String lastInstruction = "";
                String nextInstruction = "";
                if (i < fileData.size()-1){
                    nextInstruction = fileData.get(i+1);
                }
                if (i > 0){
                    lastInstruction = fileData.get(i-1);
                }
                for (int x = 0; x < currentinstruction.length();x++){
                    int amount = (checkRight(currentinstruction,x))+ (checkLeft(currentinstruction,x)) + (checkUp(x,lastInstruction)) + (checkDown(x,nextInstruction)) + (checkRight(nextInstruction,x)) + (checkLeft(nextInstruction,x)) +(checkRight(lastInstruction,x)) +(checkLeft(lastInstruction,x));
                    if (currentinstruction.charAt(x) == '@' && amount < 4) {
                        fileData.set(i,currentinstruction.substring(0,x) + "." + currentinstruction.substring(x+1));
                        currentinstruction = fileData.get(i);
                        sum += 1;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static int checkRight(String CurrentInstruction, int index){
        if ( !(CurrentInstruction.isEmpty()) && index < CurrentInstruction.length()-1 && CurrentInstruction.substring(index+1,index+2).equals("@")) {
            return 1;
        }
        return 0;
    }
    public static int checkLeft(String CurrentInstruction, int index){
        if (!(CurrentInstruction.isEmpty()) && index - 1 >= 0 && CurrentInstruction.substring(index-1,index).equals("@")) {
            return 1;
        }
        return 0;
    }
    public static int checkDown(int index,String nextInstruction){
            String nextLine = nextInstruction;
            if (!(nextLine.equals("")) && nextLine.substring(index,index+1).equals("@")){
                return 1;
            };
        return 0;
    }
    public static int checkUp(int index,String nextInstruction){
            String nextLine = nextInstruction;
            if (!(nextLine.equals("")) && nextLine.substring(index,index+1).equals("@")){
                return 1;
            };
        return 0;
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
