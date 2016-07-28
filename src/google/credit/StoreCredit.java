package google.credit;

import google.Algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class StoreCredit implements Algorithm {
	private static int idx = 1;

	@Override
	public List<String> solution(Path inputPath) {
//		
//		// Print the lines in a file, then "done"
//		try (Stream<String> lines = Files.lines(inputPath, StandardCharsets.UTF_8)) {
//			lines.skip(1).forEach(line -> {
//				StringBuilder result = new StringBuilder();
//				line.chars().forEach(c -> {
//					int code = charMap.get((char) c);
//					if ((result.length() > 0) && (result.charAt(result.length() - 1) == ("" + code).charAt(0))) {
//						result.append(' ');
//					}
//					result.append(code);
//				});
//				writeToFile(outputPath, result);
//			});
//			lines.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		StoreCredit sc = new StoreCredit();
		List<Integer> prices = new ArrayList<Integer>();
		prices.add(150);
		prices.add(24);
		prices.add(79);
		prices.add(50);
		prices.add(88);
		prices.add(345);
		prices.add(3);
		sc.solve(200, prices);
	}
	
	private int[] solve(int sum, List<Integer> prices) {
		int idx = 0;
		int[] ret = new int[2];
		boolean sumFound = false;
		
		for (;;) {
			sumFound = false;
			for (int i = idx; i < prices.size(); i++) {
				if (i != prices.size() - 1 && prices.get(idx) + prices.get(i) == sum) {
					ret[0] = idx;
					ret[1] = i;
					sumFound = true;
					break;
				}
			}
			if (sumFound) {
				break;
			}
			idx++;
		}
System.out.printf("%d %d", ret[0], ret[1]);
		return ret;
	}
}
