package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAY2 {
    public static void main(String[] args) throws IOException {
        System.out.println(part1());
    }

    public static int part1() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day2.txt"));
        int i = 1;
        int n = 0;
        for (String string : strings) {
            int red = 12;
            int green = 13;
            int blue = 14;
            for (String s : string.substring(string.indexOf(":") + 2).split("; ")) {
                for (String s1 : s.split(", ")) {
                    int value = Integer.parseInt(s1.substring(0, s1.indexOf(' ')));
                    System.out.println(s1 + "-------------" + value + "------");
                    if (s1.endsWith("red")) red -= value;
                    else if (s1.endsWith("green")) green -= value;
                    else blue -= value;
                }
            }
            if (red >= 0 && green >= 0 && blue >= 0) n += i;
            i++;
        }
        return n;
    }
}
