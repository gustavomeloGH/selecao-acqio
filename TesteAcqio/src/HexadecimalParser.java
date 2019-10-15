import java.util.Scanner;

public class HexadecimalParser {

    private static final int START_ASCII_LETTERS = 65;      //Big-O notation in Space complexity: O(1)
    private static final int END_ASCII_LETTERS = 70;        //Big-O notation in Space complexity: O(1)

    private static final int START_ASCII_SYMBOLS = 48;      //Big-O notation in Space complexity: O(1)
    private static final int END_ASCII_SYMBOLS = 57;        //Big-O notation in Space complexity: O(1)
    private static final int ADDITIONAL_START_LETTERS = 10; //Big-O notation in Space complexity: O(1)

    private static final int INT_ERROR = -1;                //Big-O notation in Space complexity: O(1)

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);           //Big-O notation in Space complexity: O(1)

        System.out.println("Digite um valor em Hexadecimal para conversão:");
        String input = scanner.nextLine();                  //Big-O notation in Space complexity: O(1)

        int result = parseHexInt(input);
        String msg = ( INT_ERROR == result ) ?              //Big-O notation in Space complexity: O(1)
            "[ERROR]: O valor de entrada não é um Hexadecimal válido!" :
            String.format(
                    "[SUCCESS]: O valor de %s em Hexadecimal para Decimal é: %d",
                    input, result);

        System.out.println(msg);
    }

    /**
     * Big-O notation in Time complexity: Big-O (n)
     *
     * This function has Big-O (n) time analysis
     * complexity because its execution time depends
     * directly on the size of the input,
     * in this case, the size of the 'input' string
     *
     *  */
    private static int parseHexInt(String input) {
        int result = 0;                                 //Big-O notation in Space complexity: O(1)
        int hexPower = 1;                               //Big-O notation in Space complexity: O(1)
        int length = input.length();                    //Big-O notation in Space complexity: O(1)

        for (int i = length - 1; i >= 0; i--) {         //Big-O notation in Space complexity: O(n)
            int ascii = (int) input.charAt(i);          //Big-O notation in Space complexity: O(1)
            int decimalValue = getDecimalValue(ascii);  //Big-O notation in Space complexity: O(1)

            if (INT_ERROR == decimalValue)
                return INT_ERROR;

            result += decimalValue * hexPower;
            hexPower *= 16;
        }

        return result;
    }

    /**
     * Big-O notation in Time complexity: Big-O (1)
     *
     * This function has Big-O (1) time analysis
     * complexity because regardless of the input
     * value, its execution time will always be
     * constant.
     *
     *  */
    private static int getDecimalValue(int ascii) {
        if (belongsHexSymbols(ascii))
            return (ascii - START_ASCII_SYMBOLS);

        if (belongsHexLetters(ascii))
            return (ascii - START_ASCII_LETTERS) + ADDITIONAL_START_LETTERS;

        return INT_ERROR;
    }

    /**
     * Big-O notation in Time complexity: Big-O (1)
     *
     * This function has Big-O (1) time analysis
     * complexity because regardless of the input
     * value, its execution time will always be
     * constant.
     *
     *  */
    private static boolean belongsHexSymbols(int ascii) {
        return (ascii >= START_ASCII_SYMBOLS && ascii <= END_ASCII_SYMBOLS);
    }

    /**
     * Big-O notation in Time complexity: Big-O (1)
     *
     * This function has Big-O (1) time analysis
     * complexity because regardless of the input
     * value, its execution time will always be
     * constant.
     *
     *  */
    private static boolean belongsHexLetters(int ascii) {
        return (ascii >= START_ASCII_LETTERS && ascii <= END_ASCII_LETTERS);
    }

}
