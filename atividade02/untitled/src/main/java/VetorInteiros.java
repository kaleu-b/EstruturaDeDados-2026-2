import java.util.Random;

public class VetorInteiros {

    private int comparacoes = 0;
    private long inicio;// = System.nanoTime();
    private long fim;// = System.nanoTime();

    Random r = new Random(67);
    public Vetor<Integer> vetor;

    public VetorInteiros(int qtde){
        vetor = new Vetor<>(qtde);
    }

    private int gerarNumero(int range){
        return r.nextInt(range);
    }

    public void popular(int quantidade, int range){
        while (vetor.obterTamanho() <= quantidade){
            int sorteado = gerarNumero(range);
            vetor.inserirOrdenadov2(sorteado);
            //vetor.inserir(sorteado);
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
    // leva tempo >= 1ms
    private double calcTempo(){
        return (double) (this.fim-this.inicio)/1000000;
    }

    public void listarEstatisticas(int comparacoes, int indice){
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

    public void listar(){
        vetor.imprimir();
    }

// busca linear com numeros inteiros (não ordenado)
    public int buscaLinear(VetorInteiros vetor, int alvo){
        this.comparacoes = 0;
        this.inicio = System.nanoTime();
        for (int i = 0; i < vetor.obterTamanho(); i++) {
            ++this.comparacoes;
            if(vetor.get(i) == alvo){
                this.fim = System.nanoTime();
                listarEstatisticas(comparacoes, i);
                return i;
            }
        }
        this.fim = System.nanoTime();
        listarEstatisticas(comparacoes, -1);
        return -1;
    }

// busca linear para arranjos ordenados
    public int buscaLinearOrdenada(VetorInteiros vetor, int alvo){
        this.comparacoes = 0;
        inicio = System.nanoTime();
        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if(vetor.get(i) == (alvo)){
                fim = System.nanoTime();
                listarEstatisticas(comparacoes, -1);
                return i;
            } else if (vetor.get(i) > alvo) {
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
    public int buscaBinaria(VetorInteiros vetor, int alvo){
        this.comparacoes = 0;
        int inicio = 0;
        int fim = vetor.obterTamanho() - 1;
        this.inicio = System.nanoTime();

       while (inicio <= fim){
           ++comparacoes;
           int meio = (inicio + fim)/2;

           if(vetor.get(meio) == alvo){
               this.fim = System.nanoTime();
               listarEstatisticas(comparacoes, meio);
            return meio;
           } else if (vetor.get(meio) > alvo) {
               fim = meio - 1;
           }else {
               inicio = meio + 1;
           }
       }
        this.fim = System.nanoTime();
        listarEstatisticas(comparacoes, -1);
        return -1;
    }

    public int obterTamanho(){
        return vetor.obterTamanho();
    }

    public int get(int i){
        return vetor.get(i);
    }

}
