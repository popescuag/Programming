package google.cookies;

import google.Algorithm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Adi on 4/13/14.
 */
public class Cookies implements Algorithm {
	@Override
	public List<String> solution(Path inputPath) {
		// Print the lines in a file, then "done"
		List<String> result = new ArrayList<String>();
		try (Stream<String> lines = Files.lines(inputPath, StandardCharsets.UTF_8)) {
			lines.skip(1).forEach(line -> {
				String[] input = line.split(" ");
				solveTest(input[0], input[1], input[2], inputPath, result);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private void solveTest(String c, String f, String x, Path inputPath, List<String> result) {
        double pace = 2;
        double time = 0;
        double current = 0;

        double farmCost = Double.parseDouble(c);
        double farmIncrement = Double.parseDouble(f);
        double total = Double.parseDouble(x);
		
        while (current < total) {
            //check if we should add a farm or let the cookies accumulate
            if (total / pace > ((farmCost - current) / pace + (total / (pace + farmIncrement)))) {
                //add a farm
                time += farmCost / pace;
                pace += farmIncrement;
                current = 0;
            } else {
                //let the cookies accumulate
                time += (total - current) / pace;
                current = total;
            }
        }
		result.add(String.format("%1$.7f", time));
	}
}
