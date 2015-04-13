import java.util.Scanner;

/**
 * @author Oliver Lea
 */
public class ReverseWords {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numCases; i++) {
            String[] items = scanner.nextLine().split(" ");
            String[] reverse = new String[items.length];
            for (int x = items.length-1; x >= 0; --x) {
                reverse[items.length-1-x] = items[x];
            }
            System.out.println(String.format("Case #%d: %s", i+1, join(" ", reverse)));
        }
    }

    private static String join(String delim, String... toJoin) {
        StringBuilder sb = new StringBuilder();
        sb.append(toJoin[0]);
        for (int i = 1; i < toJoin.length; i++) {
            sb.append(delim);
            sb.append(toJoin[i]);
        }
        return sb.toString();
    }
}
