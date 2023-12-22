package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAY3 {
    public static void main(String[] args) throws IOException {
        System.out.println(part1());
    }

    public static int part1() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/resources/Day3.txt"));
        int n = 0;
        List<Character> numbers = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0; i < strings.size(); i++) {
            int k = 0;
            while (k < strings.get(i).length()) {
                String s1 = strings.get(i).substring(k);
                if (numbers.contains(strings.get(i).charAt(k))) {
                    System.out.println(s1);
                    System.out.println(i);
                    int i1 = s1.contains(".") ? s1.indexOf('.') + k : k+1;
                    System.out.println(i1);
                    String substring = strings.get(i).substring(k, i1);
                    boolean b = false;
                    if (!numbers.contains(substring.charAt(substring.length() - 1)) ||
                            (k > 0 && strings.get(i).charAt(k - 1) != '.')
                    )
                        b = true;
                    else {
                        if (i > 0) {
                            String substring1 = strings.get(i - 1).substring(k > 0 ? k - 1 : k, s1.indexOf('.') + k + 1);
                            for (char c : substring1.toCharArray()) {
                                if (!numbers.contains(c) && c != '.') {
                                    b = true;
                                    break;
                                }
                            }
                        }

                        if (i < strings.size() - 1 && !b) {
                            String substring1 = strings.get(i + 1).substring(k > 0 ? k - 1 : k, s1.indexOf('.') + k + 1);
                            for (char c : substring1.toCharArray()) {
                                if (!numbers.contains(c) && c != '.') {
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (b) {
                        StringBuilder value = new StringBuilder();
                        for (char c : substring.toCharArray()) {
                            if (!numbers.contains(c)) {
                                n += Integer.parseInt((value.length() == 0) ? "0" : value.toString());
                                ;
                                value = new StringBuilder();
                            } else value.append(c);
                        }
                        n += Integer.parseInt((value.length() == 0) ? "0" : value.toString());
                        ;
                    }
                    k += s1.indexOf('.');
                } else {
                    k++;
                }
            }
        }
        return n;
    }
}
