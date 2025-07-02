import java.util.Scanner;

public class fraseCompleta {
    final static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {
        int n = LER.nextInt();
        for (int i = 0; i < n; i++) {
            String frase = LER.nextLine();
            System.out.println(verificarFrase(frase));
        }

    }

    public static String verificarFrase(String frase) {
        char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        frase = frase.toLowerCase();
        int contLetras = 0;
        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (frase.charAt(i) == alfabeto[j] && frase.charAt(i) != '*') {
                    contLetras++;
                    alfabeto[j] = '*';
                    break;
                }
            }
        }

        if (contLetras == 26) {
            return "frase completa";
        } else if (contLetras >= 13) {
            return "frase quase completa";
        }
        return "frase mal elaborada";
    }
}
