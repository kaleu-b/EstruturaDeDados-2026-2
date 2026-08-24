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
        IO.println("populando os vetores com numeros aleatorios: ");
        Thread.sleep(2000);
        IO.println("vetor de mil elementos: ");
        Thread.sleep(1000);
        popular(vetorMil, 1000, 2000);
        IO.println("vetor de 10 mil elementos: ");
        Thread.sleep(1000);
        popular(vetorDezMil, 10000, 2000);
        IO.println("vetor de 100 mil elementos: ");
        Thread.sleep(1000);
        popular(vetorCemMil, 100000, 200000);

        buscaLinear(vetorMil, 0);

        buscaBinaria(vetorCemMil, 100000 - 1);
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
    // e tipos double não tem casas decimais.
    // ao usar double pra mostrar o tempo das operações
    // temos mais precisão em casos onde a busca leva
    // menos de 1ms para ser concluida,
    // e mantemos precisão em casos onde a busca
    private double calcTempo() {
        return (double) (fim - inicio) / 1_000_000;
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
        int comparacoes = 0;
        inicio = System.nanoTime();
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
        int comparacoes = 0;
        inicio = System.nanoTime();
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
        int comparacoes = 0;
        int inicioBusca = 0;
        int fimBusca = vetor.obterTamanho() - 1;
        inicio = System.nanoTime();

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
