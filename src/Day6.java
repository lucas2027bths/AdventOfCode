import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    ArrayList<String> fileData = getFileData("src/day6");
    ArrayList<String[]> data = new ArrayList<>();
    static long sum = 0;
    void main(){
        for (int i = 0; i < fileData.size(); i++){
            String currentInstruction = fileData.get(i);
            String[] instructions = currentInstruction.split(" +");
            data.add(instructions);
        }
        int dataSize = data.size();
        for (int x =    0; x < data.get(1).length; x++){
            long currentSum;
            System.out.println("New column started");
            String operator = data.get(dataSize-1)[x];
            if (operator.equals("+")){
                currentSum = 0;
            }
            else{
                currentSum = 1;
            }
            int greatestLength = 0;
            for (int i = 0; i < dataSize - 1; i++){
                String num = data.get(i)[x];
                int length = num.length();
                if (length > greatestLength){
                    greatestLength = length;
                }
            }
            System.out.println("Our Greatest Length: " + greatestLength);
            for (int f = greatestLength-1; f > -1;f--){
                String totalNum = "";
                //get nums
                for (int i = 0; i < dataSize - 1; i++){
                    String num = data.get(i)[x];
                    String desiredPart = "";
                    if (num.length()-1 >= f && num.charAt(f)!='.'){
                        desiredPart = "" + num.charAt(f);
                    }
                    System.out.println("Our Original Number is" + num);
                    System.out.println("Our desired part is " + desiredPart);
                    totalNum += desiredPart;
                }
                System.out.println("total num is" + totalNum);
                long num = Integer.parseInt(totalNum);
                if (operator.equals("+")){
                    currentSum += num;
                }else{
                    currentSum *= num;
                }
                System.out.println("Current sum is " + currentSum + "The Operator should be " +operator);
            }
            System.out.println("THE FINAL CURRENT SUM IS " + currentSum);
            System.out.println();
            sum += currentSum;
        }
//        System.out.println(sum);
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

