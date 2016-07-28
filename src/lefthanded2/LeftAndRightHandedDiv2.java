package lefthanded2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeftAndRightHandedDiv2 {
    private Pattern pattern = Pattern.compile("RL");
    
    public int count2(String S) {
	int count = 0;
	for (Matcher matcher = pattern.matcher(S);matcher.find(); count++);
	return count;
    }
    
    public int count(String S) {
	int count = 0;
	
	for (int i = 0; i < S.length(); i++) {
	    if (i != S.length() - 1 && (S.charAt(i) == 'R' && S.charAt(i + 1) == 'L')) {
		count ++;
	    }
	}
	return count;
    }
}
