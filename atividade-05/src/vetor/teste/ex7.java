package vetor.teste;

import vetor.Caixa;

public class ex7 {

    static void main() {
        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.guardar("TReste");
        IO.println(caixaTexto.abrir());

        Caixa<Integer> caixaNumero = new Caixa<>();
        caixaNumero.guardar(10);
        IO.println(caixaNumero.abrir());
    }

}
