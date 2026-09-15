package pilha.teste;

import pilha.Stack;

public class DecToBIn {

    Stack<Integer> pilha;

    void main(){
        int num = 19;
        pilha = new Stack<>(100);

        while (num > 0){
            int resto = num % 2;
            num = num/2;
            pilha.push(resto);
        }

        // desempilhando para formar o binario

        StringBuilder binario = new StringBuilder();

        while (!pilha.isEmpty()){
            binario.append(pilha.pop());
        }

        IO.println(binario.toString());

    }

}
