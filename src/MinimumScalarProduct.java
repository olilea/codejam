import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oliver Lea
 */
public class MinimumScalarProduct {

    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        for (int i = 0; i < cases; ++i) {
            int vectorLength = s.nextInt();
            long[] vectorOne = new long[vectorLength];
            long[] vectorTwo = new long[vectorLength];
            IntStream.range(0, vectorLength).forEach(x -> vectorOne[x] = s.nextLong());
            IntStream.range(0, vectorLength).forEach(x -> vectorTwo[x] = s.nextLong());
            System.out.println(String.format("Case #%d: %s", i + 1, solve(vectorOne, vectorTwo, vectorLength)));
        }
    }

    private static BigInteger solve(long[] vectorOne, long[] vectorTwo, int vectorLength) {
        Arrays.sort(vectorOne);
        Arrays.sort(vectorTwo);
        BigInteger product = BigInteger.ZERO;
        for (int i = 0; i < vectorLength; ++i) {
            product = product.add(BigInteger.valueOf(vectorOne[i] * vectorTwo[vectorLength - 1 - i]));
        }
        return product;
    }
}
