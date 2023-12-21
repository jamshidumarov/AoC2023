package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DAY1 {
    public static void main(String[] args) throws IOException {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static long part1() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day1.txt"));
        List<Character> numbers = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        long sum = 0;
        for (String s : strings) {
            char[] chars = s.toCharArray();
            int n = 0;
            for (char ch : chars) {
                if (numbers.contains(ch)) {
                    n += (ch - '0') * 10;
                    break;
                }
            }

            for (int i = chars.length - 1; i >= 0; i--) {
                if (numbers.contains(chars[i])) {
                    n += chars[i] - '0';
                    break;
                }
            }
            sum += n;
        }
        return sum;
    }

    public static long part2() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day1.txt"));
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i);
        }
        long sum = 0;
        for (String string : strings) {
            String fk = "0";
            String lk = "0";
            Integer firstIndex = null;
            Integer lastIndex = null;
            for (String key : map.keySet()) {
                if (!Objects.equals(0, firstIndex)) {
                    int f = string.indexOf(key);
                    if (f >= 0 && (firstIndex == null || firstIndex > f)) {
                        fk = key;
                        firstIndex = f;
                    }
                }

                if (!string.endsWith(lk)) {
                    int l = string.lastIndexOf(key);
                    if (l >= 0 && (lastIndex == null || lastIndex < l)) {
                        lk = key;
                        lastIndex = l;
                    }
                }
            }
            sum += map.get(fk) * 10 + map.get(lk);
        }
        return sum;
    }
}
