package kwic.pipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Pipes {
    public static ArrayList<ArrayList<String>> TO_ITERABLE(String content) {
        return new ArrayList<>(new ArrayList<String>(List.of(content.split("\n"))).stream().filter(line -> line != "").map(line -> new ArrayList<String>(List.of(line.split(" ")))).collect(Collectors.toList()));
    }

    public static String TO_STRING(ArrayList<ArrayList<String>> _lines) {
        ArrayList<String> lines = new ArrayList<String>();
        for (ArrayList<String> _line : _lines) {
            String line = String.join(" ", _line);
            lines.add(line);
        }
        return String.join("\n", lines);
    }

    public static ArrayList<ArrayList<String>> SHIFT(ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> shiftedLinesAll = new ArrayList<>();
        for (ArrayList<String> words : lines) {
            ArrayList<ArrayList<String>> thisShiftedLines = new ArrayList<>();
            int length = words.size();
            for (int i = 0; i < length; i++) {
                ArrayList<String> _words = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    _words.add(words.get((i + j) % length));
                }
                thisShiftedLines.add(_words);
            }
            shiftedLinesAll.addAll(thisShiftedLines);
        }
        return shiftedLinesAll;
    }


    public static ArrayList<ArrayList<String>> LEXI(ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> alphabetized = new ArrayList<>();
        for (ArrayList<String> words : lines) {
            alphabetized.add(words);
        }

        alphabetized.sort((ArrayList<String> a, ArrayList<String> b) -> String.join(" ", a).toLowerCase(Locale.ROOT).compareTo(String.join(" ", b).toLowerCase(Locale.ROOT)));
        return alphabetized;
    }


}
