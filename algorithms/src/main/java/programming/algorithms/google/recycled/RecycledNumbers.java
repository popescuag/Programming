package programming.algorithms.google.recycled;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import programming.algorithms.google.Algorithm;

public class RecycledNumbers implements Algorithm {
	private static int idx = 1;

	
	public void solutionOld(Path inputPath, Path outputPath) {
		// Print the lines in a file, then "done"
		try (Stream<String> lines = Files.lines(inputPath, StandardCharsets.UTF_8)) {
			lines.skip(1).forEach(line -> {
				int spaceIdx = line.indexOf(" ");
				int min = Integer.parseInt(line.substring(0, spaceIdx)); 
				int max = Integer.parseInt(line.substring(spaceIdx + 1));		
				StringBuilder result = new StringBuilder();
				result.append(getPairsCount(min, max));
				writeToFile(outputPath, result);
			});
			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public List<String> solution(Path inputPath) {
		List<String> result = new ArrayList<String>();
		try (Stream<String> lines = Files.lines(inputPath, StandardCharsets.UTF_8)) {
			lines.skip(1).forEach(line -> {
				int spaceIdx = line.indexOf(" ");
				int min = Integer.parseInt(line.substring(0, spaceIdx)); 
				int max = Integer.parseInt(line.substring(spaceIdx + 1));		
				result.add("" + getPairsCount(min, max));
			});
			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	private void writeToFile(Path outputPath, StringBuilder builder) {
		//write to file the output
		try {
			Files.write(outputPath, (String.format("Case #%1$d: %2$s\n", (idx++), builder.toString())).getBytes(),new OpenOption[] 
                    {StandardOpenOption.APPEND});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getPairsCount(int min, int max) {
		int count = 0;
		for (int i = min; i <= max; i++) {
			count += getPermutations(i).stream().filter(p -> (p >= min && p <= max)).count();
		}
		return count;
	}
	
	//operations on Strings, 19 secs with large input
	private List<Integer> getPermutations(int n) {
		List<Integer> perms = new ArrayList<Integer>();
		
		String s = new String("" + n);
		int count = s.length();
		if (count == 1) {
			//nothing to perm
			return perms;
		}
		for (int i = 1; i < count; i++) {
			//build the permutation
			int perm = Integer.parseInt(s.substring(i) + s.substring(0, i));
			if (n < perm && ! perms.contains(perm)) {
				perms.add(perm);
			}
		}
		return perms;
	}
	
	/*
	 //Operations with numbers, 55 secs with large input
	private List<Integer> getPermutations(int n) {
		List<Integer> perms = new ArrayList<Integer>();
		
		int count = numberLength(n);
		if (count == 1) {
			//nothing to perm
			return perms;
		}
		for (int i = 1; i < count; i++) {
			//build the permutation
			int perm = (int) (n % Math.pow(10, i) * Math.pow(10, count - i) + (int) (n / Math.pow(10, i))); 
			if (n < perm && ! perms.contains(perm)) {
				perms.add(perm);
			}
		}
		return perms;
	}
	*/
	
	private int numberLength(int n) {
		int l = 0;
		for(;n>0;n/=10,l++);
		return l;
	}
	
	public static void main(String[] args) {
System.out.println(new RecycledNumbers().numberLength(36123410));
System.out.println(12345%100);
//		
		List<Integer> perms = new RecycledNumbers().getPermutations(1234);
for (int i = 0; i < perms.size(); i++) {
System.out.println(perms.get(i));
}
	}
}
