import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Oliver Lea
 */
public class InfiniteHouseOfPancakesWRONG {

    public static void main(String[] args) throws IOException {
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isReader);
        int numberOfCases = Integer.valueOf(bufferedReader.readLine());
        for (int i = 0; i < numberOfCases; ++i) {
            int numOfEaters = Integer.valueOf(bufferedReader.readLine());
            Queue<Integer> eaters = new PriorityQueue<>(Comparator.reverseOrder());
            String[] splitLine = bufferedReader.readLine().split(" ");
            for (int j = 0; j < numOfEaters; ++j) {
                eaters.add(Integer.valueOf(splitLine[j]));
            }
            System.out.println(String.format("Case #%d: %d", i + 1, solve(eaters)));
        }
    }

    private static int solve(Queue<Integer> eaters) {
        int minutes = 0;
        while (eaters.peek() != 0) {
            if ((eaters.peek() & 1) == 1) normalMinute(eaters);
            else if (eaters.peek() >= 4) {
                List<Integer> removed = new ArrayList<>();
                removed.add(eaters.remove());
                while (!eaters.isEmpty() && eaters.peek().equals(removed.get(0))) {
                    removed.add(eaters.remove());
                }
                boolean special = (eaters.isEmpty() || (removed.size()) <= (removed.get(0) - eaters.peek())) && (splitUp(removed.get(0)) < (removed.get(0)-removed.size()));
                for (Integer re : removed) {
                    eaters.add(re);
                }
                if (special) specialMinute(eaters);
                else normalMinute(eaters);
            } else {
                normalMinute(eaters);
            }
            ++minutes;
        }
        return minutes;
    }

    private static void specialMinute(Queue<Integer> currentEaters) {
        int highest = currentEaters.remove();
        currentEaters.add(highest / 2);
        currentEaters.add(splitUp(highest));
    }

    private static int splitUp(int toSplit) {
        return (toSplit & 1) == 0 ? toSplit/2 : (toSplit/2)+1;
    }

    private static void normalMinute(Queue<Integer> currentEaters) {
        List<Integer> eaters = new ArrayList<>(currentEaters);
        currentEaters.clear();
        ListIterator<Integer> iter = eaters.listIterator(eaters.size());
        while (iter.hasPrevious()) {
            currentEaters.add(iter.previous() - 1);
        }
    }
}
