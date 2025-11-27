import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        try (EachReader er = new EachReader()) {

            List<Integer> list = er.readAndDivide();

            list.sort(Comparator.reverseOrder());

            for (int i : list) {
                System.out.print(i);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }
    }

    static class EachReader implements AutoCloseable {
        final BufferedReader br;

        public EachReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public List<Integer> readAndDivide() throws IOException {
            final List<Integer> list = new ArrayList<>();
            String text = br.readLine();
            for (int i = 0; i < text.length(); i++) {
                list.add(text.charAt(i) - '0');
            }
            return list;
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}
