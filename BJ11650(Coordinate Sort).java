import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<Coordinate> coordinateList = new ArrayList<>();

        try (CoordinateReader cr = new CoordinateReader()) {
            int num = cr.nextInt();

            for (int i = 0; i < num; i++) {
                int x = cr.nextInt();
                int y = cr.nextInt();
                coordinateList.add(new Coordinate(x, y));
            }
            
            coordinateList.sort(new Comparator<Coordinate>() {
                @Override
                public int compare(Coordinate a, Coordinate b) {
                    if (a.x != b.x) {
                        return a.x - b.x;
                    } else {
                        return a.y - b.y;
                    }
                }
            });

            for (Coordinate element : coordinateList) {
                sb.append(element.x).append(' ').append(element.y).append('\n');
            }
            System.out.print(sb);


        } catch (IOException | IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }
    }
}

class CoordinateReader implements AutoCloseable {
    final BufferedReader br;

    public CoordinateReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int nextInt() throws IOException {
        boolean isMinus = false;
        int ret = 0;
        int k = br.read();
        while (k <= ' ') {
            k = br.read();
        }

        if(k == '-'){
            isMinus = true;
            k = br.read();
        }
        do {
            ret = ret * 10 + k - '0';
        } while ((k = br.read()) >= '0' && k <= '9');
        if(isMinus){
            ret *= -1;
        }
        return ret;
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
