package programming.algorithms.google;

import java.nio.file.Path;
import java.util.List;

@FunctionalInterface
public interface Algorithm {
	List<String> solution(Path inputPath);
}
