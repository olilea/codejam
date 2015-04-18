import java.util.Scanner;

/**
 * @author Oliver Lea
 */
public class MushroomMonster {

    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        for (int i = 0; i < cases; ++i) {
            int mi = s.nextInt();
            int[] ms = new int[mi];
            for (int x = 0; x < mi; ++x) {
                ms[x] = s.nextInt();
            }
            System.out.println(String.format("Case #%d: %d %d", i + 1, solve1(ms), solve2(ms)));
        }
    }

    private static int solve1(int[] ms) {
        int t = 0;
        for (int i = 1; i < ms.length; ++i) {
            if (ms[i - 1] > ms[i]) {
                t += ms[i - 1] - ms[i];
            }
        }
        return t;
    }

    private static int solve2(int[] ms) {
        int rate = 0;
        for (int i = 1; i < ms.length; ++i) {
            if (rate < (ms[i - 1] - ms[i])) {
                rate = ms[i - 1] - ms[i];
            }
        }
        int t = 0;
        for (int i = 0; i < ms.length - 1; ++i) {
            t += ms[i] > rate ? rate : ms[i];
        }
        return t;
    }
}
