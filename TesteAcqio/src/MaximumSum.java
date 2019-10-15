import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximumSum {

    public static void main(String[] args) {
        int[] integerArray;
        try {
            integerArray = populateArrayWithInput();
        } catch (InputMismatchException ex) {
            System.out.println("Entrada inválida!");
            return;
        }

        int maxSum = calculateMaxSum(integerArray);
        System.out.println(String.format(
            "O resultado dos dois números cuja soma é a maior dentre todas as possíveis é: %d",
            maxSum)
        );
    }

    /**
     * Notação de Tempo: big-O (n)
     * Notação de espaço:
     *
     * Esta função possui notação de tempo big-O(n)
     * pois seu tempo de execução depende diretamente
     * do tamanho da entrada do 'size'
     */
    private static int[] populateArrayWithInput() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números que será digitado: (Mínimo 2)");
        int size = scanner.nextInt();
        if (size < 2) size = 2;
        int[] integerArray = new int[size];

        for (int i = 0; i <= size -1; i++) {
            System.out.println(String.format("Digite um número inteiro: [%d/%d]", i + 1, size));
            int integerInput = scanner.nextInt();
            integerArray[i] = integerInput;

        }
        return integerArray;
    }

    /**
     * Notação de Tempo: big-O (n)
     * Notação de espaço:
     *
     * Esta função possui notação de tempo big-O(n)
     * pois seu tempo de execução depende diretamente
     * do tamanho do array de entrada, no caso, o 'integerArray'
     */
    private static int calculateMaxSum(int[] integerArray) {
        int maxValue = 0;
        int previousMaxValue = 0;

        for (int currInteger : integerArray) {
            if (currInteger > maxValue) {
                maxValue = currInteger;
            } else if (currInteger > previousMaxValue) {
                previousMaxValue = currInteger;
            }
        }

        return maxValue + previousMaxValue;
    }
}
