package pilha.teste;

public class MainEditor {

    EditorTexto editor = new EditorTexto();

    void main(){
        editor.escrever("Olá ");
        editor.escrever("esmundo");

        IO.println("Conteudo atual: " + editor.getConteudo());

        editor.desfazer();

        IO.println("Conteudo apos desfazer: "+ editor.getConteudo());

        editor.refazer();

        IO.println("Conteudo apos refazer: " + editor.getConteudo());

        editor.escrever("");

    }

}
