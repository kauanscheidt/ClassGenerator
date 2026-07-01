// Linguagem.java
package enums;

/**
 * Linguagens suportadas pelo gerador, cada uma com sua extensão de arquivo.
 */
public enum Linguagem {
    JAVA("java"),
    PYTHON("py"),
    PHP("php"),
    CPP("h");

    private final String extensao;

    Linguagem(String extensao) {
        this.extensao = extensao;
    }

    public String getExtensao() {
        return extensao;
    }
}