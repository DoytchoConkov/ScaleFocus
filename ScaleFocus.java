import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScaleFocus {
    public static void main(String[] args) {
        System.out.println("Please enter codded string:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Map<Character, Integer> characters = new LinkedHashMap<>();


        Pattern pattern = Pattern.compile("(\\d{2}#\\(\\d+\\))+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String afterJChar = s.substring(matcher.start(), matcher.end());
            s = s.replace(afterJChar, "");
            int charNumber = Integer.parseInt(afterJChar.substring(0, 2));
            int counter = Integer.parseInt(afterJChar.substring(4, afterJChar.length() - 1));
            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + counter);
            matcher = pattern.matcher(s);
        }

        Pattern patternOnly = Pattern.compile("(\\d{2}#)+");
        Matcher matcherOnly = patternOnly.matcher(s);
        while (matcherOnly.find()) {
            String afterJChar = s.substring(matcherOnly.start(), matcherOnly.end());
            s = s.replace(afterJChar, "");
            int charNumber = Integer.parseInt(afterJChar.substring(0, 2));
            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + 1);
            matcherOnly = patternOnly.matcher(s);
        }

        Pattern patternOnly2 = Pattern.compile("\\d\\(\\d+\\)");
        Matcher matcherOnly2 = patternOnly2.matcher(s);
        while (matcherOnly2.find()) {
            String afterJChar = s.substring(matcherOnly2.start(), matcherOnly2.end());
            s = s.replace(afterJChar, "");
            int charNumber = Integer.parseInt(afterJChar.substring(0, 1));
            int counter = Integer.parseInt(afterJChar.substring(2, afterJChar.length() - 1));
            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + counter);
            matcherOnly2 = patternOnly2.matcher(s);
        }


        for (int i =0;i<s.length();i++ ) {
            characters.putIfAbsent((char) ('a' + Integer.parseInt(""+s.charAt(i)) - 1), 0);
            characters.put((char) ('a' + Integer.parseInt(""+s.charAt(i))- 1), characters.get((char) ('a' + Integer.parseInt(""+s.charAt(i)) - 1)) + 1);
        }

        System.out.println("The result is:");

        for (int number: characters.values() ) {
            System.out.print(number+" ");
        }
    }
}

