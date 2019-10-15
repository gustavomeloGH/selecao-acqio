import java.util.Scanner;

public class HexadecimalParser {

    private static final int START_ASCII_LETTERS = 65;
    private static final int END_ASCII_LETTERS = 70;

    private static final int START_ASCII_SYMBOLS = 48;
    private static final int END_ASCII_SYMBOLS = 57;
    private static final int ADDITIONAL_START_LETTERS = 10;

    private static final int INT_ERROR = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valor em Hexadecimal para conversão:");
        String input = scanner.nextLine();

        int result = parseHexInt(input);
        String msg = ( INT_ERROR == result ) ?
            "[ERROR]: O valor de entrada não é um Hexadecimal válido!" :
            String.format(
                    "[SUCCESS]: O valor de %s em Hexadecimal para Decimal é: %d",
                    input, result);

        System.out.println(msg);
    }

    /**
     * Notação de Tempo: big-O (n)
     * Notação de espaço:
     *
     * Esta função possui notação de tempo big-O(n)
     * pois seu tempo de execução depende diretamente
     * do tamanho da entrada, no caso, o 'input'
     */
    private static int parseHexInt(String input) {
        int result = 0;
        int hexPower = 1;
        int length = input.length();

        for (int i = length - 1; i >= 0; i--) {
            int ascii = (int) input.charAt(i);
            int decimalValue = getDecimalValue(ascii);

            if (INT_ERROR == decimalValue)
                return INT_ERROR;

            result += decimalValue * hexPower;
            hexPower *= 16;
        }

        return result;
    }

    /**
     * Notação de Tempo: big-O (1)
     *
     * Esta função possui notação de tempo big-O(1)
     * pois independente do valor de entrada,
     * o tempo de execução será sempre constante
     */
    private static int getDecimalValue(int ascii) {
        if (belongsHexSymbols(ascii))
            return (ascii - START_ASCII_SYMBOLS);

        if (belongsHexLetters(ascii))
            return (ascii - START_ASCII_LETTERS) + ADDITIONAL_START_LETTERS;

        return INT_ERROR;
    }


    /**
     * Notação de Tempo: big-O (1)
     *
     * Esta função possui notação de tempo big-O(1)
     * pois independente do valor de entrada,
     * o tempo de execução será sempre constante
     */
    private static boolean belongsHexSymbols(int ascii) {
        return (ascii >= START_ASCII_SYMBOLS && ascii <= END_ASCII_SYMBOLS);
    }

    /**
     * Notação de Tempo: big-O (1)
     *
     * Esta função possui notação de tempo big-O(1)
     * pois independente do valor de entrada,
     * o tempo de execução será sempre constante
     */
    private static boolean belongsHexLetters(int ascii) {
        return (ascii >= START_ASCII_LETTERS && ascii <= END_ASCII_LETTERS);
    }

}
