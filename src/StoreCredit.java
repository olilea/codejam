import java.util.Scanner;

/**
 * @author Oliver Lea
 */
public class StoreCredit {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; ++i) {
            int credit = scanner.nextInt();
            int numItems = scanner.nextInt();
            int[] items = new int[numItems];
            for (int j = 0; j < numItems; ++j) {
                items[j] = scanner.nextInt();
            }
            end:
            for (int j = 0; j < numItems; j++) {
                for (int k = 0; k < numItems; k++) {
                    if (j != k && (items[j] + items[k]) == credit) {
                        System.out.println(String.format("Case #%d: %d %d", i + 1, j+1, k+1));
                        break end;
                    }
                }
            }
        }
    }
}
