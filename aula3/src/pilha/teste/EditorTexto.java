package pilha.teste;

import pilha.Stack;

public class EditorTexto {

    private Stack<String> undo;
    private Stack<String> redo;

    private String conteudo;

    public EditorTexto(){
        undo = new Stack<>(10);
        redo = new Stack<>(10);
        conteudo = "";
    }

    public void escrever(String texto){
        undo.push(texto);
        conteudo += texto;
        // limpando pilha de refazer
        redo = new Stack<>(10);
    }

    public void desfazer(){
        if (!undo.isEmpty()){
            redo.push(conteudo);
            undo.pop();
            while (!undo.isEmpty()){
                conteudo+=undo.pop();
            }

        }else IO.println("Nada pra fazer");
    }

    public void refazer(){
        if (!undo.isEmpty()){
            undo.push(conteudo);
            conteudo = redo.pop();
        }else IO.println("Nada pra refazer");
    }

    public String getConteudo() {
        return conteudo;
    }
}
