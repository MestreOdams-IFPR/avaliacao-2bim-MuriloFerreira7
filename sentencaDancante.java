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
        fraseC[0] = Character.toUpperCase(fraseC[0]);
        boolean ultimoEhMaiusculo = true;
        for (int i = 1; i < fraseC.length; i++) {
            if (Character.isLetter(fraseC[i]) && ultimoEhMaiusculo) {
                fraseC[i] = Character.toLowerCase(fraseC[i]);
            } else {
                
            }
        }

        String retorno = "";
        for (int i = 0; i < fraseC.length; i++) {
            retorno += fraseC[i];
        }
        return retorno;
    }
}
