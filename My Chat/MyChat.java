import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chat = scanner.nextLine();
        try {
            FileWriter letsgo = new FileWriter("chat.txt", true);
            letsgo.write(chat + "\n");
            letsgo.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
