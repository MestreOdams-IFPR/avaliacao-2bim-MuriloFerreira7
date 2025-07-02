import java.util.Scanner;

public class buscaPelosCristais {
    final static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        int cont = 1;
        while (true) {
            int n = LER.nextInt();
            int nConsultas = LER.nextInt();
            if (n == nConsultas && nConsultas == 0) {
                break;
            }
            int[] cristais = new int[n];
            cristais = lerVet(cristais);
            cristais = mergeSort(cristais);
            System.out.printf("CASE# %d:\n", cont);
            for (int i = 0; i < nConsultas; i++) {
                int cristal = LER.nextInt();
                if (buscaExiste(cristais, cristal)) {
                    System.out.printf("%d found at %d\n", cristal, (busca(cristais, cristal)+1));
                } else {
                    System.out.printf("%d not found\n", cristal);
                }
            }
            cont++;
        }
    }

    public static boolean buscaExiste(int[] vet, int valor) {
        return buscaBinariaRecExiste(vet, valor, 0, vet.length - 1);
    }

    public static boolean buscaBinariaRecExiste(int[] vet, int valor, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (int) (inicio + fim) / 2;
            if (valor == vet[meio]) {
                return true;
            } else if (valor > vet[meio]) {
                return buscaBinariaRecExiste(vet, valor, meio+1, fim);
            } else {
                return buscaBinariaRecExiste(vet, valor, inicio, meio-1);
            }
        }
        return false;
    }

    public static int busca(int[] vet, int valor) {
        return buscaBinariaRec(vet, valor, 0, vet.length - 1);
    }

    public static int buscaBinariaRec(int[] vet, int valor, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (int) (inicio + fim) / 2;
            if (valor == vet[meio]) {
                return meio;
            } else if (valor > vet[meio]) {
                return buscaBinariaRec(vet, valor, meio+1, fim);
            } else {
                return buscaBinariaRec(vet, valor, inicio, meio-1);
            }
        }
        return -1;
    }

    public static int[] lerVet(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = LER.nextInt();
        }
        return vet;
    }

    public static void print(int[] vet) {
        for (int i : vet) {
            System.out.print(i + " ");
        }
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
