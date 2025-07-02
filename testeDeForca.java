import java.util.Scanner;

public class testeDeForca {
    final static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        while (LER.hasNext()) {
            int[] forcaCandidatos = new int[LER.nextInt()];
            int k = LER.nextInt();
            forcaCandidatos = lerVet(forcaCandidatos);
            forcaCandidatos = selectionSort(forcaCandidatos, k);
            System.out.println(somarForcaCandidatos(forcaCandidatos, k));
        }
    }

    public static int somarForcaCandidatos(int[] forcaCandidatos, int k) {
        int soma = 0;
        for (int i = 0; i < k; i++) {
            soma += forcaCandidatos[i];
        }
        return soma;
    }

    public static int[] selectionSort(int[] vet, int k) {
        for (int i = 0; i < vet.length; i++) {
            int maior = vet[i];
            int posMaior = i;
            for (int j = i+1; j < vet.length; j++) {
                if (vet[j] > maior) {
                    maior = vet[j];
                    posMaior = j;
                }
            }
            if (posMaior != i) {
                swap(vet, posMaior, i);
            }
            k--;
            if (k==0) {
                break;
            }
        }
        return vet;
    }

    public static int[] swap(int[] vet, int pos1, int pos2) {
        int temp = vet[pos1];
        vet[pos1] = vet[pos2];
        vet[pos2] = temp;
        return vet;
    }

    public static int[] lerVet(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = LER.nextInt();
        }
        return vet;
    }

}
