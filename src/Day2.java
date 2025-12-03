import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Day2 {
    static long sum = 0;
    public static void main(String[] args) {
        String input = "1-14,46452718-46482242,16-35,92506028-92574540,1515128146-1515174322,56453-79759,74-94,798-971,49-66,601-752,3428-4981,511505-565011,421819-510058,877942-901121,39978-50500,9494916094-9494978970,7432846301-7432888696,204-252,908772-990423,21425-25165,1030-1285,7685-9644,419-568,474396757-474518094,5252506279-5252546898,4399342-4505058,311262290-311393585,1895-2772,110695-150992,567521-773338,277531-375437,284-364,217936-270837,3365257-3426031,29828-36350";
        String[] items = input.split(",");

        for (int i = 0; i < items.length; i++) {
            String[] nums = items[i].split("-");
            long min = Long.parseLong(nums[0]);
            long max = Long.parseLong(nums[1]);


            for (long j = min; j <= max; j++) {
                check(Objects.toString(j));
            }
        }
        System.out.println(sum);
    }

    public static void check(String num) {

        Pattern pattern = Pattern.compile("^(.*)\\1+$");
        //for part 1 just remove the +
        Matcher matcher = pattern.matcher(num);
        if (matcher.find()) {
             sum += Long.parseLong(num);
        }
    }
}