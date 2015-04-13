import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oliver Lea
 */
public class OminousOmino {

    private static final int X = 0;
    private static final int R = 1;
    private static final int C = 2;

    public static void main(String[] args) throws IOException {
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isReader);
        int numberOfCases = Integer.valueOf(bufferedReader.readLine());
        for (int i = 0; i < numberOfCases; i++) {
            String[] splitInput = bufferedReader.readLine().split(" ");
            int[] vals = new int[splitInput.length];
            for (int j = 0; j < splitInput.length; j++) {
                vals[j] = Integer.valueOf(splitInput[j]);
            }
            System.out.format(String.format("Case #%d: %s", i + 1, determineWinner(vals[X], vals[R], vals[C], false)));
        }
    }

    private static String determineWinner(int x, int r, int c, boolean swapped) {
        final int area = r * c;
        if (x >= 7) return "RICHARD";
        if ((x == 1 && r == 1 && c ==1) || (x == 2 && r == 2 && c == 1) || (x == 2 && r == 1 && c == 2)) return "GABRIEL";
        if (x >= area || ((area % x) != 0)) return "RICHARD";
        for (int i = 0, rc = 1, rr = x; rc <= rr && rr >= rc; ++i, ++rc, --rr) {
            if (x >= 4) {
                if (((rc >= (c - i)) && (rr >= r))
                        || ((rc >= c) && (rr >= (r - i)))) {
                    return "RICHARD";
                }
            } else if (rc >= c && rr >= r) {
                return "RICHARD";
            }
        }
        if (!swapped && x >= 4) return determineWinner(x, c, r, true);
        return "GABRIEL";
    }
}
