/**
 * 
 */
package j8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Call this program with two arguments; a regular expression and a string. The
 * program prints the text, from the string, that matches the first capturing
 * group in the regular expression.
 */
public class RegexExample {
    public static void main(String[] args) {
//        String regex = args[0];
//        String content = args[1];
//
//        Pattern pat = Pattern.compile(regex);
//        Matcher mat = pat.matcher(content);
//
//        if (mat.matches()) {
//            if (mat.groupCount() > 0) {
//                System.out.println("Group: " + mat.group(1));
//            } else {
//                System.out.println("Group: ");
//            }
//        } else {
//            System.out.println("No match!");
//        }
    	String urlDef = "/vcom/admin/user/(\\d)+";
    	String urlApp = "/vcom/admin/user/34ee";
System.out.println(urlDef + (urlApp.matches(urlDef) ? " matches " : " doesn't match ") + urlApp);
    }
}