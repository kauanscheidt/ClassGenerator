// Atributo.java
package model;

import enums.TipoDado;

/**
 * Um atributo de classe: nome, tipo e visibilidade.
 * Também é usado pra representar parâmetros de métodos.
 */
public class Atributo {

    private String nome;
    private TipoDado tipo;
    private boolean isPrivate;

    public Atributo(String nome, TipoDado tipo, boolean isPrivate) {
        this.nome = nome;
        this.tipo = tipo;
        this.isPrivate = isPrivate;
    }

    public String getNome() {
        return nome;
    }

    public TipoDado getTipo() {
        return tipo;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}