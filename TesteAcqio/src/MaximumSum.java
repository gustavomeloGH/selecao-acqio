public class MaximumSum {

    public static void main(String[] args) {
        int[] integerArray = new int[] {5,2,4};
        if (integerArray.length < 2) {
            System.out.println("O array deve ter tamanho mínimo igual a 2");
            return;
        }

        int maxSum = calculateMaxSum(integerArray);
        System.out.println(String.format(
            "O resultado dos dois números cuja soma é a maior dentre todas as possíveis é: %d",
            maxSum)
        );
    }

    /**
     * Notação de Tempo: big-O (n-1)
     *
     * Esta função possui notação de tempo big-O(n-1)
     * pois seu tempo de execução depende diretamente
     * do tamanho do array de entrada - 1, pois inicia
     * a interação a partir do 2º elemento do array
     */
    private static int calculateMaxSum(int[] integerArray) {
        int maxValue = integerArray[0];
        int previousMaxValue = 0;

        for (int i = 1; i < integerArray.length; i++) {
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
