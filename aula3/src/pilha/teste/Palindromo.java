package pilha.teste;

import pilha.Stack;

public class Palindromo {

    void main(){
        Stack pilha = new Stack<Character>(1);

        String mensagem = "arara";
        StringBuilder palindromo = new StringBuilder();

        for (int i = mensagem.length()-1; i >= 0 ; i--) {
            pilha.push(mensagem.charAt(i));
        }

        for (int i = 0; i < mensagem.length(); i++) {
            palindromo.append(pilha.pop());
        }

        IO.println("mensagem original: " + mensagem + "palindromo: " + palindromo.toString() + "É palindromo " + (palindromo.toString().equalsIgnoreCase(mensagem) ? "Sim":"Não") );

    }


}
