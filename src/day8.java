import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class day8 {
    void main(){
        ArrayList<String> fileData = getFileData("src/day8");
        ArrayList <String> vectorSet = new ArrayList<>();
        String smallestVector = "";
        String smallestSecondVector = "";
        String key = "";
        String key2 = "";
        double currentMax = Double.MAX_VALUE; //i need biggest value to compare to for smallest just in case
        boolean changed = true;
        while (changed ) {
            currentMax = 100000000; //set it high so comparison works
            changed = false;
            for (int out = 0; out < fileData.size(); out++) {
                String currentVector = fileData.get(out);
                for (int in = out+1; in < fileData.size(); in++) {
                    String nextVector = fileData.get(in);
                    double distance = calculateDistance(currentVector, nextVector);
                    key = nextVector + "|" + currentVector;
                    key2 = currentVector + "|" + nextVector;
                    if (vectorSet.contains(key) || vectorSet.contains(key2)) {
                        continue;
                    }
                    if (distance < currentMax) {
                        currentMax = distance;
                        smallestVector = currentVector;
                        smallestSecondVector = nextVector;
                        changed = true;

                        if (vectorSet.contains(smallestVector)){
                            int indx = vectorSet.indexOf(smallestVector);
                            String merged = vectorSet.get(indx) + smallestSecondVector;
                            vectorSet.set(indx, merged);
                        }else if(vectorSet.contains(smallestSecondVector)){
                            int indx = vectorSet.indexOf(smallestSecondVector);
                            String merged = vectorSet.get(indx) + smallestVector;
                            vectorSet.set(indx, merged);
                        }else{
                            vectorSet.add(key);
                        }
                    }
                }
                }
            }
        System.out.println(vectorSet.size());
        }

    public static double calculateDistance(String A, String B){
        String[] ANums = A.split(",");
        String [] BNums = B.split(",");
        int p1 = Integer.parseInt(ANums[0]);
        int p2 = Integer.parseInt(ANums[1]);
        int p3 = Integer.parseInt(ANums[2]);

        int q1 = Integer.parseInt(BNums[0]);
        int q2 = Integer.parseInt(BNums[1]);
        int q3 = Integer.parseInt(BNums[2]);

        return Math.sqrt(Math.pow(p1-q1,2)+Math.pow(p2-q2,2)+Math.pow(p3-q3,2));
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
