import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class ScaleFocus {
    public static void main(String[] args) {
        System.out.println("Please enter codded string:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // better solution:

        Map<Integer, Integer> characters = new LinkedHashMap<>();

        String[] tokens = s.split("#");

        if (tokens.length > 1) {
            for (int i = 0; i < tokens.length - 1; i++) {
                if (tokens[i + 1].charAt(0) == '(') {
                    int index = tokens[i + 1].indexOf(")");
                    int charKey = Integer.parseInt(tokens[i].substring(tokens[i].length() - 2));
                    int charCounter = Integer.parseInt(tokens[i + 1].substring(1, index));
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 2);
                    tokens[i + 1] = tokens[i + 1].substring(index + 1);
                    characters.putIfAbsent(charKey, 0);
                    characters.put(charKey, characters.get(charKey) + charCounter);
                } else {
                    int charKey = Integer.parseInt(tokens[i].substring(tokens[i].length() - 2));
                    characters.putIfAbsent(charKey, 0);
                    characters.put(charKey, characters.get(charKey) + 1);
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 2);
                }
                while (tokens[i].contains("(")) {
                    int startIndex = tokens[i].indexOf("(");
                    int endIndex = tokens[i].indexOf(")");
                    int charKey = Integer.parseInt(tokens[i].substring(startIndex - 1),startIndex);
                    int charCounter = Integer.parseInt(tokens[i + 1].substring(startIndex + 1, endIndex));
                    characters.putIfAbsent(charKey, 0);
                    characters.put(charKey, characters.get(charKey) + charCounter);
                    tokens[i] = tokens[i].replace(tokens[i].substring(startIndex - 1, endIndex+1 ), "");
                }

                for (int j = 0; j < tokens[i].length(); j++) {
                    int charKey = Integer.parseInt(tokens[i].substring(j, j + 1));
                    characters.putIfAbsent(charKey, 0);
                    characters.put(charKey, characters.get(charKey) + 1);
                }
            }
        }
        int index = tokens.length - 1;
        while (tokens[index].contains("(")) {
            int startIndex = tokens[index].indexOf("(");
            int endIndex = tokens[index].indexOf(")");
            int charKey = Integer.parseInt(tokens[index].substring(startIndex - 1,startIndex));
            int charCounter = Integer.parseInt(tokens[index].substring(startIndex + 1, endIndex));
            characters.putIfAbsent(charKey, 0);
            characters.put(charKey, characters.get(charKey) + charCounter);
            tokens[index] = tokens[index].replace(tokens[index].substring(startIndex - 1, endIndex+1 ), "");
        }
        for (int j = 0; j < tokens[index].length(); j++) {
            System.out.println(tokens[index].substring(j,j+1));
            int charKey = Integer.parseInt(tokens[index].substring(j, j + 1));
            characters.putIfAbsent(charKey, index);
            characters.put(charKey, characters.get(charKey) + 1);
        }

        System.out.println("The result is:");
        for (int i = 0; i < 27; i++) {
            System.out.print(characters.get(i) != null ? characters.get(i)+ " " : 0 + " ");
        }

//        Map<Character, Integer> characters = new LinkedHashMap<>();
//
//
//        Pattern pattern = Pattern.compile("(\\d{2}#\\(\\d+\\))+");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            String afterJChar = s.substring(matcher.start(), matcher.end());
//            s = s.replace(afterJChar, "");
//            int charNumber = Integer.parseInt(afterJChar.substring(0, 2));
//            int counter = Integer.parseInt(afterJChar.substring(4, afterJChar.length() - 1));
//            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
//            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + counter);
//            matcher = pattern.matcher(s);
//        }
//
//        Pattern patternOnly = Pattern.compile("(\\d{2}#)+");
//        Matcher matcherOnly = patternOnly.matcher(s);
//        while (matcherOnly.find()) {
//            String afterJChar = s.substring(matcherOnly.start(), matcherOnly.end());
//            s = s.replace(afterJChar, "");
//            int charNumber = Integer.parseInt(afterJChar.substring(0, 2));
//            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
//            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + 1);
//            matcherOnly = patternOnly.matcher(s);
//        }
//
//        Pattern patternOnly2 = Pattern.compile("\\d\\(\\d+\\)");
//        Matcher matcherOnly2 = patternOnly2.matcher(s);
//        while (matcherOnly2.find()) {
//            String afterJChar = s.substring(matcherOnly2.start(), matcherOnly2.end());
//            s = s.replace(afterJChar, "");
//            int charNumber = Integer.parseInt(afterJChar.substring(0, 1));
//            int counter = Integer.parseInt(afterJChar.substring(2, afterJChar.length() - 1));
//            characters.putIfAbsent((char) ('a' + charNumber - 1), 0);
//            characters.put((char) ('a' + charNumber - 1), characters.get((char) ('a' + charNumber - 1)) + counter);
//            matcherOnly2 = patternOnly2.matcher(s);
//        }
//
//
//        for (int i =0;i<s.length();i++ ) {
//            characters.putIfAbsent((char) ('a' + Integer.parseInt(""+s.charAt(i)) - 1), 0);
//            characters.put((char) ('a' + Integer.parseInt(""+s.charAt(i))- 1), characters.get((char) ('a' + Integer.parseInt(""+s.charAt(i)) - 1)) + 1);
//        }
//
//        System.out.println("The result is:");
//
//        for (int number: characters.values() ) {
//            System.out.print(number+" ");
//        }
    }
}

