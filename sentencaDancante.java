import java.util.Scanner;

public class sentencaDancante {
    final static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        while (LER.hasNext()) {
            String frase = LER.nextLine();
            System.out.println(transformarSentencaDancante(frase));
        }
    }

    public static String transformarSentencaDancante(String frase) {
        char[] fraseC = frase.toCharArray();
        boolean ultimoEhMaiusculo = false;
        for (int i = 0; i < fraseC.length; i++) {
            if (Character.isLetter(fraseC[i]) && ultimoEhMaiusculo) {
                fraseC[i] = Character.toLowerCase(fraseC[i]);
                ultimoEhMaiusculo = false;
            } else if (Character.isLetter(fraseC[i]) && !ultimoEhMaiusculo) {
                fraseC[i] = Character.toUpperCase(fraseC[i]);
                ultimoEhMaiusculo = true;
            }
        }

        return new String(fraseC);
    }
}
