import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        HashMap<String, Integer> vars = new HashMap<>();
        vars.put("a",0);
        vars.put("b",0);
        vars.put("c",0);
        vars.put("d",0);
        for (int i = 0; i < fileData.size(); i++) {
            String currentInstruction = fileData.get(i);
            String instructionName = currentInstruction.split(" ")[0];

            switch (instructionName) {
                case "cpy" -> {
                    String value = (currentInstruction.split(" ")[1]);
                    String variable = currentInstruction.split(" ")[2];
                    if (vars.containsKey(value)) {
                        vars.put(variable, vars.get(value));
                    } else {
                        vars.put(variable, Integer.parseInt(value));
                        System.out.println(vars);
                    }
                }
                case "inc" -> {
                    String variable = currentInstruction.split(" ")[1];
                    vars.put(variable, vars.get(variable) + 1);
                }
                case "dec" -> {
                    String variable = currentInstruction.split(" ")[1];
                    vars.put(variable, vars.get(variable) - 1);
                }
                case "jnz" -> {
                    String variable = currentInstruction.split(" ")[1];
                    String step = currentInstruction.split(" ")[2];
                    if (vars.containsKey(variable)) {
                        if (vars.get(variable) != 0){
                            i -= 1;
                            i += Integer.parseInt(step);
                        }
                    } else{
                        if (Integer.parseInt(variable) != 0){
                            i -= 1;
                            i += Integer.parseInt(step);
                        }
                    }
                }
            }
        }
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
