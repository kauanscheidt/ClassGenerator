// GeradorFactory.java
package generator;

import enums.Linguagem;

/**
 * Cria o gerador certo de acordo com a linguagem escolhida.
 */
public class GeradorFactory {

    /**
     * Cria o gerador da linguagem informada.
     *
     * @param linguagem linguagem de destino
     * @return gerador dessa linguagem
     * @throws IllegalArgumentException se a linguagem não for suportada
     */
    public static GeradorCodigo criar(Linguagem linguagem) {
        switch (linguagem) {
            case JAVA:   return new GeradorJava();
            case PYTHON: return new GeradorPython();
            case PHP:    return new GeradorPhp();
            case CPP:    return new GeradorCpp();
            default:     throw new IllegalArgumentException("Linguagem não suportada: " + linguagem);
        }
    }
}