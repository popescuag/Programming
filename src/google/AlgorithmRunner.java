package google;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AlgorithmRunner {
	public static void main(String[] args) throws IOException {
		//receives an algorithm implementation class, input and output files
		if (args == null || args.length != 3) {
			System.out.println("3 arguments are required: class, input and output file");
			return;
		}
		// read a file
		final Path inputPath = FileSystems.getDefault().getPath("input",args[1]);
		Path thePath = FileSystems.getDefault().getPath("output", args[2]);
		Files.deleteIfExists(thePath);
		final Path outputPath = Files.createFile(thePath);
		try {
			Class<?> clazz = Class.forName(args[0]);
			if (Algorithm.class.isAssignableFrom(clazz)) {
			//if (clazz.isInstance(Algorithm.class)) {
				@SuppressWarnings("unchecked")
				Class<? super Algorithm> cls = (Class<? super Algorithm>) clazz;
				Object t = cls.newInstance();
				Method m = cls.getMethod("solution", new Class[] {Path.class});
				long time = System.nanoTime();
				@SuppressWarnings("unchecked")
				List<String> results = (List<String>) m.invoke(t, new Object[] {inputPath});
				writeToFile(outputPath, results);
System.out.println("Took " + (System.nanoTime() - time) / 1000000 + " ms to complete.");
			} else {
System.out.println(String.format("Class %1s doesn't implement Algorithm interface", args[0]));
			}
		} catch (IllegalArgumentException | InvocationTargetException | ClassNotFoundException
				| NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void writeToFile(Path outputPath, List<String> results) {
		AtomicInteger idx = new AtomicInteger();
		results.stream().forEach(line -> {
			try {
				Files.write(outputPath, (String.format("Case #%1$d: %2$s\n", idx.incrementAndGet(), line)).getBytes(),new OpenOption[] 
				        {StandardOpenOption.APPEND});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		});
	}	

	
/*	
	public static void main(String[] args) throws IOException {
		//receives an algorithm implementation class, input and output files
		if (args == null || args.length != 3) {
			System.out.println("3 arguments are required: class, input and output file");
			return;
		}
		// read a file
		final Path inputPath = FileSystems.getDefault().getPath("input",args[1]);
		Path thePath = FileSystems.getDefault().getPath("output", args[2]);
		Files.deleteIfExists(thePath);
		final Path outputPath = Files.createFile(thePath);
		try {
			@SuppressWarnings("unchecked")
			Class<? super Algorithm> cls = (Class<? super Algorithm>) Class.forName(args[0]);
			Object t = cls.newInstance();
			Method m = cls.getMethod("solution", new Class[] {Path.class, Path.class});
			long time = System.nanoTime();
			m.invoke(t, new Object[] {inputPath, outputPath});
System.out.println("Took " + (System.nanoTime() - time) / 1000000 + " ms to complete.");			
		} catch (IllegalArgumentException | InvocationTargetException | ClassNotFoundException
				| NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
