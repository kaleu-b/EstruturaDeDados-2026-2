public class Main {
    // vetor com mil posicoes
    VetorInteiros vetorMil = new VetorInteiros(1000);
    // vetor com dez mil posicoes
    VetorInteiros vetorDezMil = new VetorInteiros(10000);
    // vetor com cem mil posicoes
    VetorInteiros vetorCemMil = new VetorInteiros(100000);

    void main(){
        // populando com numeros de forma ordenada
        // como regra geral, o range vai ser
        // igual ao valor da quantidade * 2
        vetorMil.popular(1000, 2000);
        vetorMil.buscaLinear(vetorMil, 0);

        //vetorDezMil.popular(10000, 2000);
        //vetorCemMil.popular(100000, 200000);
        //vetorCemMil.buscaLinear(vetorCemMil, (100000-1));
        //vetorMil.listar();
    }

}
