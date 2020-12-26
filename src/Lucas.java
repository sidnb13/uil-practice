public class Lucas {
    public static void main(String[] args) {
        for (int i = 0; i < 31; i++)
            System.out.println(L(i));
    }

    static int L(int n) {
        if (n == 0)
            return 2;
        else if (n == 1)
            return 1;
        else
            return L(n - 1) + L(n - 2);
    }
}