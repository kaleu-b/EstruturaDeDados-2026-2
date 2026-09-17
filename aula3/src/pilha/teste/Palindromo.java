package pilha.teste;

import pilha.Stack;

public class Palindromo {

    void main(){
        Stack pilha = new Stack<Character>(1);

        String mensagem = "anotaram a data da maratona";
        StringBuilder palindromo = new StringBuilder();

        for (int i = 0; i < mensagem.length() ; i++) {
            pilha.push(mensagem.charAt(i));
        }

        for (int i = 0; i <= mensagem.length()-1; i++) {
            palindromo.append(pilha.pop());
        }
        // usando replace all para remover os espaços e comparar as strings
        IO.println("mensagem original: " + mensagem + "palindromo: " + palindromo.toString() + "É palindromo " + (palindromo.toString().replaceAll("\\s+", "").equalsIgnoreCase(mensagem.replaceAll("\\s+", "")) ? "Sim":"Não") );

    }


}
