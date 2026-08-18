package vetor;

import java.util.Random;

public class VetorInteiros {
    Random r = new Random(67);
    private Vetor<Integer> vetorInteiros ;

    public VetorInteiros(int qtde){
        vetorInteiros = new Vetor<>(qtde);
    }


    public int gerarInteiros(int inteiros){
        return r.nextInt(inteiros);
    }

    public void popular(int qtdeelementos){
       int num;
        while(){

        }

        /* int num;
        for (int i = 0; i < qtdeelementos; i++) {
            num = gerarInteiros(vetorInteiros.obterTamanho());
            while (vetorInteiros.existeIgual(num)){
                num = gerarInteiros(vetorInteiros.obterTamanho());
            }
            for (int j = 0; j < qtdeelementos; j++) {
                if (num < vetorInteiros.get(j) || vetorInteiros.get(j) == null){
                    vetorInteiros.inserir(num, j);
                }
            }
        }*/
    }

    public void imprimir(){
        vetorInteiros.imprimir();
    }

    public int obterTamaho(){
        return vetorInteiros.obterTamanho();
    }
}