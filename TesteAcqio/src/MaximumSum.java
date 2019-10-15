public class MaximumSum {

    public static void main(String[] args) {
        int[] integerArray = new int[] {-2, 1, -1, 0};       //Big-O notation in Space complexity: O(n)

        if (integerArray.length < 2) {
            System.out.println("O array deve ter tamanho mínimo igual a 2");
            return;
        }

        int maxSum = calculateMaxSum(integerArray);         //Big-O notation in Space complexity: O(1)
        System.out.println(String.format(
            "O resultado dos dois números cuja soma é a maior dentre todas as possíveis é: %d",
            maxSum)
        );
    }

    /**
     * Big-O notation in Time complexity: Big-O (n-1)
     *
     * This function has Big-O (n-1) time analysis
     * complexity because its execution time depends
     * on the size of the input array - 1,
     * because interaction starts from the 2nd array element
     *
     *  */
    private static int calculateMaxSum(int[] integerArray) {
        int maxValue = integerArray[0];                     //Big-O notation in Space complexity: O(1)
        int previousMaxValue = 0;                           //Big-O notation in Space complexity: O(1)

        for (int i = 1; i < integerArray.length; i++) {     //Big-O notation in Space complexity: O(n)
            if (integerArray[i] > maxValue) {
                previousMaxValue = maxValue;
                maxValue = integerArray[i];
            } else if (integerArray[i] > previousMaxValue) {
                previousMaxValue = integerArray[i];
            }
        }

        return maxValue + previousMaxValue;
    }
}
