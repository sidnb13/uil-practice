import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Mixup {
    public static void main(String[] args) throws IOException {
        String fileName = "Mixup".toLowerCase() + ".dat";
        String path = "./datadump/2010/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(path));
        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            List<String> words = Arrays.asList(scan.nextLine().split("\\s"));
            words.forEach(x -> {
                for (int j = x.length() - 1; j >= 0; j--)
                    System.out.print(x.charAt(j) + (j == 0 ? " " : ""));
            });
            System.out.println();
        }
    }
}