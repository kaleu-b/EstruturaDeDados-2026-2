package vetor.teste;

import vetor.VetorObjeto;

public class ex6 {

    static void main() {
        VetorObjeto vettor = new VetorObjeto(10);
        vettor.inserir(10);
        vettor.inserir("teste");
        vettor.inserir(10.90);
        String palavra = (String) vettor.ler(1);
        int num = (Integer) vettor.ler(0);
        double num2 = (Double) vettor.ler(2);
    }
}