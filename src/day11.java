import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day11 {
    void main(){
        ArrayList<String> fileData = getFileData("src/day11");
        ArrayList<String> names = new  ArrayList<>();
        ArrayList<String> devices = new  ArrayList<>();
        ArrayList<String> rows = new  ArrayList<>();
        for(String c : fileData){
           devices.add(c.split(": ")[0]);
           names.add(c.split(": ")[1]);
        }
        int start = devices.indexOf("you");
        final int youIndex = start;

        while (!devices.get(youIndex).isEmpty()){
            start = youIndex;
            String currentDevice = "";
            ArrayList<Integer> indexArray = new ArrayList<>();
            ArrayList<String> StringArray = new ArrayList<>();
            System.out.println("RUN AGAIN");
            System.out.println(start);
            while(!(currentDevice.equals("out")) && !(devices.get(youIndex).isEmpty()) && start > -1){
                indexArray.add(start);
                StringArray.add(currentDevice);
                String currentRow = names.get(start);
                if (currentRow.isEmpty()){
                    System.out.println("empty!");
                    int currentIndex = indexArray.get(indexArray.size()-2);
                    String currentString = StringArray.get(StringArray.size()-1);
                    System.out.println("THIS IS MY CURRENT STRING " + currentString);
                    System.out.println(names.get(currentIndex));
                    names.set(currentIndex,names.get(currentIndex).replaceAll(currentString,""));
                    break;
                }
                currentDevice = currentRow.split(" ")[0];
                System.out.println(currentDevice);
                start = devices.indexOf(currentDevice);
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
                fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

