import java.util.ArrayList;
public class Day32016 {
    static void main() {
        ArrayList<String> fileData = getFileData("src/data2016day3");
        int counter = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            int a = Integer.parseInt(currentInstruction.split(" {2,}")[1]);
            int b = Integer.parseInt(currentInstruction.split(" {2,}")[2]);
            int c = Integer.parseInt(currentInstruction.split(" {2,}")[3]);
            if (a + b > c && a + c > b && b + c > a) {
                counter++;
            };
        }
        System.out.println(counter);

    }
    public static ArrayList<String> getFileData(String fileName) {
        return Main.getFileData(fileName);
    }
}
