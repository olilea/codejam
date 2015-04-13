import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Oliver Lea
 */
public class StandingOvation {

    public static void main(String args[]) throws IOException {
        List<String> inputLines = Files.readAllLines(Paths.get("input.txt"));

        int numberOfTestCases = Integer.valueOf(inputLines.get(0));
        inputLines.remove(0);
        int[] solved = inputLines.stream()
                .map(s -> s.split(" ")[1])
                .mapToInt(StandingOvation::solve)
                .toArray();

        File outputFile = new File("output.out");
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < numberOfTestCases; i++) {
            bufferedWriter.write(String.format("Case #%d: %d", i + 1, solved[i]));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static int solve(String inputString) {
        int totalAdded = 0;
        int total = Character.getNumericValue(inputString.charAt(0));
        int[] input = new int[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            input[i] = Character.getNumericValue(inputString.charAt(i));
        }
        for (int i = 1; i < input.length; i++) {
            int var = input[i];
            if (var != 0 && total < i) {
                int added = i - total;
                totalAdded += added;
                total += added;
            }
            total += var;
        }
        System.out.println("Input: " + inputString + " - " + totalAdded);
        return totalAdded;
    }
}
