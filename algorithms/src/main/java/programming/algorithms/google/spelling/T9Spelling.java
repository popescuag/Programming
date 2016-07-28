package programming.algorithms.google.spelling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import programming.algorithms.google.Algorithm;

public class T9Spelling implements Algorithm {
	private static Map<Character, Integer> charMap = new HashMap<Character, Integer>();

	static {
		charMap.put('a', 2);
		charMap.put('b', 22);
		charMap.put('c', 222);
		charMap.put('d', 3);
		charMap.put('e', 33);
		charMap.put('f', 333);
		charMap.put('g', 4);
		charMap.put('h', 44);
		charMap.put('i', 444);
		charMap.put('j', 5);
		charMap.put('k', 55);
		charMap.put('l', 555);
		charMap.put('m', 6);
		charMap.put('n', 66);
		charMap.put('o', 666);
		charMap.put('p', 7);
		charMap.put('q', 77);
		charMap.put('r', 777);
		charMap.put('s', 7777);
		charMap.put('t', 8);
		charMap.put('u', 88);
		charMap.put('v', 888);
		charMap.put('w', 9);
		charMap.put('x', 99);
		charMap.put('y', 999);
		charMap.put('z', 9999);
		charMap.put(' ', 0);
	}

	@Override
	public List<String> solution(Path inputPath) {
		List<String> resultList = new ArrayList<String>();
		// Print the lines in a file, then "done"
		try (Stream<String> lines = Files.lines(inputPath, StandardCharsets.UTF_8)) {
			lines.skip(1).forEach(line -> {
				StringBuilder result = new StringBuilder();
				line.chars().forEach(c -> {
					int code = charMap.get((char) c);
					if ((result.length() > 0) && (result.charAt(result.length() - 1) == ("" + code).charAt(0))) {
						result.append(' ');
					}
					result.append(code);
				});
				resultList.add(result.toString());
			});
			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
