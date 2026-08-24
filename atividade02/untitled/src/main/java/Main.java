import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    // vetor com mil posicoes
    VetorInteiros vetorMil = new VetorInteiros(1000);
    // vetor com dez mil posicoes
    VetorInteiros vetorDezMil = new VetorInteiros(10000);
    // vetor com cem mil posicoes
    VetorInteiros vetorCemMil = new VetorInteiros(100000);

    private long inicio;
    private long fim;
    private final Random random = new Random(67);

    void main() throws InterruptedException {
        IO.println("  populando os vetores com numeros aleatorios:   ");
        Thread.sleep(4000);
        IO.println("vetor de mil elementos: ");
        Thread.sleep(2000);
        popular(vetorMil, 1000, 2000);
        IO.println("vetor de 10 mil elementos: ");
        Thread.sleep(2000);
        popular(vetorDezMil, 10000, 20000);
        IO.println("vetor de 100 mil elementos: ");
        Thread.sleep(2000);
        popular(vetorCemMil, 100000, 200000);

        IO.println("   Usando busca linear em todos os vetores:   ");
        Thread.sleep(4000);
        IO.println(" Buscando o primeiro elemento no Vetor de mil: (melhor caso: O(1))" );
        Thread.sleep(2000);
        buscaLinear(vetorMil, vetorMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de mil: (caso intermediário: O(n/2))");
        buscaLinear(vetorMil, vetorMil.get( (vetorMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de mil (segundo pior caso: O(n)): ");
        buscaLinear(vetorMil, vetorMil.get(vetorMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de mil: (pior caso: O(n))");
        buscaLinear(vetorMil, -2);
        Thread.sleep(4000);

        IO.println(" Buscando o primeiro elemento no Vetor de dez mil: (melhor caso: O(1))" );
        Thread.sleep(2000);
        buscaLinear(vetorDezMil, vetorDezMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de dez mil: (caso intermediário: O(n/2))");
        buscaLinear(vetorDezMil, vetorDezMil.get( (vetorDezMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de dez mil (segundo pior caso: O(n)): ");
        buscaLinear(vetorDezMil, vetorDezMil.get(vetorDezMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de dez mil: (pior caso: O(n))");
        Thread.sleep(3000);
        buscaLinear(vetorDezMil, -2);
        Thread.sleep(4000);

        IO.println(" Buscando o primeiro elemento no Vetor de cem mil: (melhor caso: O(1))" );
        Thread.sleep(2000);
        buscaLinear(vetorCemMil, vetorCemMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de cem mil: (caso intermediário: O(n/2))");
        buscaLinear(vetorCemMil, vetorCemMil.get( (vetorCemMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de cem mil (segundo pior caso: O(n)): ");
        buscaLinear(vetorCemMil, vetorCemMil.get(vetorCemMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de cem mil: (pior caso: O(n))");
        Thread.sleep(3000);
        buscaLinear(vetorCemMil, -2);
        Thread.sleep(4000);

        IO.println("   Usando busca binaria em todos os vetores:   ");
        Thread.sleep(4000);
        IO.println(" Buscando o primeiro elemento no Vetor de mil: (pior caso: O(log n))" );
        Thread.sleep(2000);
        buscaBinaria(vetorMil, vetorMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de mil: (melhor caso: O(1) )");
        buscaBinaria(vetorMil, vetorMil.get( (vetorMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de mil (segundo pior caso: O(log n)): ");
        buscaBinaria(vetorMil, vetorMil.get(vetorMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de mil: (pior caso: O(log n))");
        buscaBinaria(vetorMil, -2);
        Thread.sleep(4000);

        IO.println(" Buscando o primeiro elemento no Vetor de dez mil: (pior caso: O(log n))" );
        Thread.sleep(2000);
        buscaBinaria(vetorDezMil, vetorDezMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de dez mil: (melhor caso: O(1))");
        buscaBinaria(vetorDezMil, vetorDezMil.get( (vetorDezMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de dez mil (segundo pior caso: O(log n)): ");
        buscaBinaria(vetorDezMil, vetorDezMil.get(vetorDezMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de dez mil: (pior caso: O(log n))");
        Thread.sleep(3000);
        buscaBinaria(vetorDezMil, -2);
        Thread.sleep(4000);

        IO.println(" Buscando o primeiro elemento no Vetor de cem mil: (pior caso: O(log n))" );
        Thread.sleep(2000);
        buscaBinaria(vetorCemMil, vetorCemMil.get(0));
        Thread.sleep(3000);
        IO.println("Buscando o elemento do meio de Vetor de cem mil: (melhor caso: O(1))");
        buscaBinaria(vetorCemMil, vetorCemMil.get( (vetorCemMil.obterTamanho()-1)/2 ));
        Thread.sleep(3000);
        IO.println("Buscando o ultimo elemento do vetor de cem mil (segundo pior caso: O(n)): ");
        buscaBinaria(vetorCemMil, vetorCemMil.get(vetorCemMil.obterTamanho()-1));
        Thread.sleep(3000);
        IO.println("Buscando elemento inexistente no vetor de cem mil: (pior caso: O(log n))");
        Thread.sleep(3000);
        buscaBinaria(vetorCemMil, -2);
        Thread.sleep(4000);

        IO.println(" Comparando com o metodo Arrays.binarySearch do java: ");
        Thread.sleep(3000);
        IO.println("medindo os tempos do vetor mil: ");
        Thread.sleep(2000);
        IO.println("primeiro elemento: ");
        //Arrays.binarySearch( vetorMil, vetorMil.get(0));
        Arrays.binarySearch( Arrays.copyOf(vetorMil, 999) , vetorMil.get(0));
    }

    private void popular(Vetor<Integer> vetor, int quantidade, int range) {
        while (vetor.obterTamanho() < quantidade) {
            vetor.inserirOrdenado(random.nextInt(range));
        }
    }

    // iremos calcular o tempo em ms de forma um pouco diferente
    // ao inves do que temos no sigaa.
    // ao inves de:
    // long duracao = = (fim - inicio) / 1000000;
    // usaremos um valor double para retorno.
    // motivo: algumas operações levam menos de 1ms para serem concluidas
    // e tipos long não tem casas decimais. o que faz com que o resultado seja truncado pra 0
    // ao usar double pra mostrar o tempo das operações
    // temos mais precisão em casos onde a busca leva
    // menos de 1ms para ser concluida,
    // e mantemos precisão em casos onde a busca
    private double calcTempo() {
        return (double) (fim - inicio) / 1000000;
    }
    // lista os dados
    private void listarEstatisticas(int comparacoes, int indice) {
        IO.println(
                String.format(
                        """
                        n° de comparações: %d
                        tempo total em ms: %.2f
                        indice do elemento: %d""",
                        comparacoes, calcTempo(), indice
                )
        );
    }
    // busca linear para vetores não ordenados
    public int buscaLinear(Vetor<Integer> vetor, int alvo) {
        inicio = System.nanoTime();
        int comparacoes = 0;

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            comparacoes++;
            if (vetor.get(i) == alvo) {
                fim = System.nanoTime();
                listarEstatisticas(comparacoes, i);
                return i;
            }
        }
        fim = System.nanoTime();
        listarEstatisticas(comparacoes, -1);
        return -1;
    }
    // busca linear para vetores ordenados
    public int buscaLinearOrdenada(Vetor<Integer> vetor, int alvo) {
        inicio = System.nanoTime();
        int comparacoes = 0;

        for (int i = 0; i < vetor.obterTamanho(); i++) {
            comparacoes++;
            if (vetor.get(i) == alvo) {
                fim = System.nanoTime();
                listarEstatisticas(comparacoes, i);
                return i;
            }
            if (vetor.get(i) > alvo) {
                fim = System.nanoTime();
                listarEstatisticas(comparacoes, -1);
                return -1;
            }
        }
        fim = System.nanoTime();
        listarEstatisticas(comparacoes, -1);
        return -1;
    }
    // busca binaria
    public int buscaBinaria(Vetor<Integer> vetor, int alvo) {
        inicio = System.nanoTime();
        int comparacoes = 0;
        int inicioBusca = 0;
        int fimBusca = vetor.obterTamanho() - 1;

        while (inicioBusca <= fimBusca) {
            comparacoes++;
            int meio = (inicioBusca + fimBusca) / 2;

            if (vetor.get(meio) == alvo) {
                fim = System.nanoTime();
                listarEstatisticas(comparacoes, meio);
                return meio;
            }
            if (vetor.get(meio) > alvo) {
                fimBusca = meio - 1;
            } else {
                inicioBusca = meio + 1;
            }
        }
        fim = System.nanoTime();
        listarEstatisticas(comparacoes, -1);
        return -1;
    }
}
