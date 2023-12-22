package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DAY2 {
    public static void main(String[] args) throws IOException {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day2.txt"));
        int i = 1;
        int n = 0;
        Map<String, Integer> limits = Map.of("red", 12, "green", 13, "blue", 14);
        for (String string : strings) {
            boolean b = true;
            for (String s : string.substring(string.indexOf(":") + 2).split("; ")) {
                for (String s1 : s.split(", ")) {
                    int value = Integer.parseInt(s1.substring(0, s1.indexOf(' ')));
                    if (limits.get(s1.substring(s1.indexOf(' ') + 1)) < value){
                        b = false;
                        break;
                    }
                }
                if (!b) break;
            }
            if (b) n += i;
            i++;
        }
        return n;
    }

    public static int part2() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day2.txt"));
        int n = 0;
        for (String string : strings) {
            int red = 1;
            int green = 1;
            int blue = 1;
            for (String s : string.substring(string.indexOf(":") + 2).split("; ")) {
                for (String s1 : s.split(", ")) {
                    int value = Integer.parseInt(s1.substring(0, s1.indexOf(' ')));
                    if (s1.endsWith("red") && red < value) red = value;
                    else if (s1.endsWith("green") && green < value) green = value;
                    else if (s1.endsWith("blue") && blue < value) blue = value;
                }
            }
            n += (red * green * blue);
        }
        return n;
    }
}
