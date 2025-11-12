import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int groupWordCount = 0;
            String text;
            for (int i = 0; i < N; i++) {
                if (GroupWordChecker.countGroupWord(br.readLine())) {
                    groupWordCount++;
                }
            }
            System.out.print(groupWordCount);
        } catch (IOException | NumberFormatException e) {
            System.out.print(e.getMessage());

        }
    }
}

class GroupWordChecker {
    public static boolean countGroupWord(String text) {
        Set<Character> seenChars = new HashSet<>();
        boolean isGroupWord = true;

        for (int i = 1; i < text.length(); i++) {
            char prev = text.charAt(i - 1);
            char curr = text.charAt(i);

            if (prev != curr) {
                if (seenChars.contains(curr)) {
                    isGroupWord = false;
                    break;
                } else {
                    seenChars.add(prev);
                }
            } else {
                continue;
            }
        }
        return isGroupWord;
    }
}
