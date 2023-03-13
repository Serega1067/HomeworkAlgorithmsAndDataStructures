import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        final RBTree tree = new RBTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("Finish");
                } catch (Exception ignored) {

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}