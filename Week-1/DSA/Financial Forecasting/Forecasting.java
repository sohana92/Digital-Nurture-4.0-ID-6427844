public class Forecasting {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double pv, double rate, int years) {
        if (years == 0) {
            return pv;
        }
        return (1 + rate) * futureValueRecursive(pv, rate, years - 1);
    }

    // Optimized version using memoization (optional)
    public static double futureValueMemo(double pv, double rate, int years, double[] memo) {
        if (years == 0) return pv;
        if (memo[years] != 0) return memo[years];
        memo[years] = (1 + rate) * futureValueMemo(pv, rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000; // ₹10,000
        double growthRate = 0.08; // 8% growth
        int years = 5;

        // Simple recursion
        double result = futureValueRecursive(presentValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + Math.round(result));

        // Optimized with memoization
        double[] memo = new double[years + 1];
        double memoResult = futureValueMemo(presentValue, growthRate, years, memo);
        System.out.println("Future Value (Memoized): " + Math.round(memoResult));
    }
}
