import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

    static long sum = 0;
    void main() {
        ArrayList<String> fileData = getFileData("src/day3");
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            StringBuilder builder = new StringBuilder();
            int deletes = currentInstruction.length() - 12;
            for (int j = 0; j < currentInstruction.length(); j++) {
                while (!builder.isEmpty() && currentInstruction.charAt(j) > builder.charAt(builder.length()-1) && deletes > 0){
                    deletes=- 1;
                    builder.deleteCharAt(builder.length()-1);
                }
                builder.append(currentInstruction.charAt(j));
            }
            System.out.println(builder.toString());
            sum += Long.parseLong(builder.substring(0,12));
        }
        System.out.println(sum);
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
