import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuel {
    public static void main(String[] args) throws IOException {
        String fileName = "Fuel".toLowerCase() + ".dat";
        String sidPath = "./datadump/2010/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(sidPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int d = scan.nextInt();
            scan.nextLine();

            ArrayList<Pair> ds = new ArrayList<>();
            String[] spt = scan.nextLine().split("\\s");

            //System.out.println(Arrays.toString(spt));

            for (int j = 0; j < spt.length - 1; j += 2)
                ds.add(new Pair(Integer.parseInt(spt[j]), Integer.parseInt(spt[j + 1])));
            for (int j = spt.length / 2; j < d; j++)
                ds.add(new Pair(0, 0));

            /*for (Pair p : ds)
                System.out.println(p.plants + " " + p.height + " " + p.dayNum);
            System.out.println();*/

            System.out.printf("Data Set %d%n", i + 1);
            System.out.printf("%s%n", display(ds, d));
        }

    }

    static String display(ArrayList<Pair> dataSet, int n) {
        StringBuilder res = new StringBuilder();
        int leaves = 0, rfs = 0, pdf = 0;

        for (int i = 1; i <= n; i++) {
            Pair set = dataSet.get(i - 1);
            //System.out.printf("%d Leaves: %d RFS: %d PDF: %d%n", i, leaves, rfs, pdf);

            if (leaves != 0) {
                if (rfs != 0) {
                    pdf += rfs / 17;
                    rfs = rfs % 17;
                }
                rfs += leaves / 177;
                leaves = leaves % 177;
            }

            leaves += set.plants * set.height * 25;

            res.append(String.format("Day %d %d" + (i == n ? "" : ", "), i, pdf));
        }
        return res.toString();
    }
}

class Pair {
    int plants;
    int height;
    Pair(int p, int h) {
        plants = p;
        height = h;
    }
}