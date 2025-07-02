public class algoritmosDeOrdenacao {
    public static void main(String[] args) {
        
    }

    public static int[] insertionSort(int[] vet) {
        int[] vetOrdenado = vet.clone();
        int posCerta;
        int movimentacao = 0;
        for (int i = 1; i < vetOrdenado.length; i++) {
            posCerta = procurarPosCerta(vetOrdenado, i);
            if (posCerta != i) {
                inserirValor(vetOrdenado, i, posCerta);
                movimentacao += 3;
            }
        }
        System.out.println("insertion: " + movimentacao);
        return vetOrdenado;
    }

    public static int[] inserirValor(int[] vet, int i, int posCerta) {
        int temp = vet[i];
        vet[i] = 0;
        for (int j = i; j > posCerta; j--) {
            swap(vet, j, j - 1);
        }
        vet[posCerta] = temp;
        return vet;
    }

    public static int procurarPosCerta(int[] vet, int i) {
        int posCerta = i;
        for (int j = i; j > 0; j--) {
            if (vet[i] < vet[j - 1]) {
                posCerta--;
            } else {
                break;
            }
        }
        return posCerta;
    }

    public static int[] swap(int[] vet, int pos1, int pos2) {
        int temp = vet[pos1];
        vet[pos1] = vet[pos2];
        vet[pos2] = temp;
        return vet;
    }

    public static int[] mergeSort(int[] vet) {
        int[] vetOrdenado = vet.clone();
        vetOrdenado = mergeSortRec(vet, 0, vet.length);
        return vetOrdenado;
    }

    public static int[] mergeSortRec(int[] vet, int inicio, int fim) {
        int meio;
        if (inicio < fim - 1) {
            meio = (inicio + fim) / 2;
            vet = mergeSortRec(vet, inicio, meio);
            vet = mergeSortRec(vet, meio, fim);
            mesclar(vet, inicio, meio, fim);
        }
        return vet;
    }

    public static int[] mesclar(int[] vet, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio;
        int k = 0;
        int[] vetAux = new int[fim - inicio];
        while (i < meio && j < fim) {
            if (vet[i] <= vet[j]) {
                vetAux[k] = vet[i];
                k++;
                i++;
            } else {
                vetAux[k] = vet[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            vetAux[k] = vet[i];
            k++;
            i++;
        }

        while (j < fim) {
            vetAux[k] = vet[j];
            k++;
            j++;
        }

        for (int l = inicio; l < fim; l++) {
            vet[l] = vetAux[l - inicio];
        }
        return vet;
    }

}
