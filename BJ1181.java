import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Word> wordSet = new HashSet<>();
        List<Word> wordList;
        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                wordSet.add(new Word(br.readLine()));
            }
            wordList = new ArrayList<>(wordSet);
            wordList.sort(new Comparator<Word>() {
                @Override
                public int compare(Word a, Word b) {
                    if (a.word.length() != b.word.length()) {
                        return a.word.length() - b.word.length();
                    } else {
                        return a.word.compareTo(b.word);
                    }
                }
            });
            for (Word i : wordList) {
                sb.append(i.word).append('\n');
            }
            System.out.print(sb);
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}

class Word {
    String word;

    Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // 동일한 매모리 주소이면 true
        if (!(o instanceof Word)) return false;  // Word의 객체 조차 아니면 false
        Word w = (Word) o;
        return word.equals(w.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);  // word 문자열 기준 해시코드 생성
    }
}
