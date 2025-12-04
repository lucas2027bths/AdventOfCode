import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day4");
        for (int i = 0; i < fileData.size(); i++) {
            System.out.println("new line");
            String currentinstruction = fileData.get(i);
            String nextInstruction = "";
            String LastInstruction = "";
            if (i < fileData.size()-1){
                LastInstruction = fileData.get(i+1);
            }
            if (i > 0){
                nextInstruction = fileData.get(i-1);
            }
            for (int x = 0; x < currentinstruction.length();x++){
                System.out.println("THE CURRENT CHARACTER IS" + currentinstruction.charAt(x));
                System.out.println();
                System.out.println("check right");
                System.out.println(checkRight(currentinstruction,x));
                System.out.println("check left");
                System.out.println(checkLeft(currentinstruction,x));
                System.out.println("check up");
                System.out.println(checkUp(x,nextInstruction));
                System.out.println("check down");
                System.out.println(checkDown(x,LastInstruction));
                System.out.println();
                System.out.println("check north west ");

                System.out.println("DIAGONAL DOWN");
                System.out.println("check right");
                System.out.println(checkRight(LastInstruction,x));
                System.out.println("check left");
                System.out.println(checkLeft(LastInstruction,x));
                System.out.println("DIAGONAL UP");
                System.out.println("check right");
                System.out.println(checkRight(nextInstruction,x));
                System.out.println("check left");
                System.out.println(checkLeft(nextInstruction,x));
            }
        }

    }

    public static boolean checkRight(String CurrentInstruction, int index){
        if ( !(CurrentInstruction.equals("")) && index < CurrentInstruction.length()-1 && CurrentInstruction.substring(index+1,index+2).equals("@")) {
            return true;
        }
        return false;
    }
    public static boolean checkLeft(String CurrentInstruction, int index){
        if (!(CurrentInstruction.equals("")) && index - 1 >= 0 && CurrentInstruction.substring(index-1,index).equals("@")) {
            return true;
        }
        return false;
    }
    public static boolean checkDown(int index,String nextInstruction){
        ArrayList<String> fileData = getFileData("src/day4");
            String nextLine = nextInstruction;
            if (!(nextLine.equals("")) && nextLine.substring(index,index+1).equals("@")){
                return true;
            };
        return false;
    }
    public static boolean checkUp(int index,String nextInstruction){
        ArrayList<String> fileData = getFileData("src/day4");
            String nextLine = nextInstruction;
            if (!(nextLine.equals("")) && nextLine.substring(index,index+1).equals("@")){
                return true;
            };
        return false;
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
