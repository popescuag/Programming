package google.reverse;

import google.Algorithm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReverseWords implements Algorithm {
	@Override
	public List<String> solution(Path inputPath) {
		// Print the lines in a file, then "done"
		List<String> result = new ArrayList<String>();
		try (Stream<String> lines = Files.lines(inputPath,
				StandardCharsets.UTF_8)) {
			lines.skip(1).forEach(line -> {
				String[] words = line.split(" ");
				StringBuilder builder = new StringBuilder();
				for (int i = words.length - 1; i >= 0; i--) {
					builder.append(" ");
					builder.append(words[i]);
				}
				result.add(builder.toString());
				});
			lines.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
