import java.util.ArrayList;

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
        for (int x = 0; x < data.get(1).length; x++){
            long currentSum;
            String operator = data.get(dataSize-1)[x];
            if (operator.equals("+")){
                currentSum = 0;
            }
            else{
                currentSum = 1;
            }
            for (int i = 0; i < dataSize - 1; i++){
                int num = Integer.parseInt(data.get(i)[x]);
                System.out.println(data.get(i)[x]);
                if (operator.equals("+")){
                    currentSum += num;
                }else{
                    currentSum *= num;
                }
                System.out.println("Current Sum" + currentSum + "Operator is" + operator);
            }
            sum += currentSum;
        }
        System.out.println(sum);
    }


    public static ArrayList<String> getFileData(String fileName) {
        return Day5.getFileData(fileName);
    }
}

