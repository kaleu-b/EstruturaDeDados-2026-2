package pilha.teste;

import pilha.Stack;

public class Expressao {



    void main(){
        String correto = "( ( ) ) – ( ( )( ) ) – ( ) ( )";
        String incorreto = ")( – ( ( ) ( – ) ) ( (";
        String incorreto2 = "( – ( ( ) ( – ) ) ( (";
        String incorreto3 = "( – ( ( ) ( – ) )";
        verificar(correto);
        verificar(incorreto);
        verificar(incorreto2);
        verificar(incorreto3);
    }

    private void verificar(String mensagem){
        Stack<Character> pilhaAbreParenteses = new Stack<>(1);
        Stack<Character> pilhaFechaParenteses = new Stack<>(1);

        mensagem = mensagem.trim();

        if (mensagem.charAt(0) == ')'){
            IO.println("invalido: fecha parenteses no começo");
            return;
        } else if (mensagem.charAt(mensagem.length()-1) == '(') {
            IO.println("invalido: abre parenteses no fim");
            return;
        }

        for (int i = 0; i < mensagem.length(); i++) {
            if (mensagem.charAt(i) == '('){
                pilhaAbreParenteses.push(mensagem.charAt(i));
            } else if (mensagem.charAt(i) == ')') {
                pilhaFechaParenteses.push(mensagem.charAt(i));
            }
        }

        if (pilhaAbreParenteses.tamanho() == pilhaFechaParenteses.tamanho()){
            IO.println("Expressão válida");
        } else IO.println("expressão invalida");
    }

}