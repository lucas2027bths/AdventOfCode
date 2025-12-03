import java.util.*;

public class Day12023 {

    static void main() {
        ArrayList<String> fileData = Main.getFileData("src/data2023day12");

        String[] nums = {
                "zero","one","two","three","four","five","six","seven","eight","nine"
        };

        int sum = 0;

        for (String line : fileData) {
            String parsed = "";
            for (int i = 0; i < line.length(); i++) {

                char c = line.charAt(i);

                if (Character.isDigit(c)) {
                    parsed += c;
                } else {
                    for (int n = 0; n < nums.length; n++) {
                        if (line.startsWith(nums[n], i)) {
                            parsed += n;
                        }
                    }
                }
            }
            int first = parsed.charAt(0) - '0';
            int last = parsed.charAt(parsed.length() - 1) - '0';

            sum += first * 10 + last;
        }

        System.out.println(sum);
    }
}
