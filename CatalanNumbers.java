public class CatalanNumbers {

    // method to calculate nth catalan number
    public static int catalan(int n) {
        // base case: c0 and c1 are always 1
        if (n <= 1) {
            return 1;
        }

        int result = 0;

        // sum of catalan(i) * catalan(n-i-1) for all i
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - i - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10; // print first 10 catalan numbers
        for (int i = 0; i < n; i++) {
            System.out.print(catalan(i) + " ");
        }
    }
}
