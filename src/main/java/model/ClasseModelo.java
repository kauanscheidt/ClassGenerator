// ClasseModelo.java
package model;

import enums.TipoDado;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de uma classe a ser gerada: nome, atributos e métodos.
 * É esse objeto que os geradores usam pra montar o código final.
 */
public class ClasseModelo {

    private String nome;
    private List<Atributo> atributos;
    private List<Metodo> metodos;

    public ClasseModelo(String nome) {
        this.nome = nome;
        this.atributos = new ArrayList<>();
        this.metodos = new ArrayList<>();
    }

    /**
     * Adiciona um atributo ao modelo.
     *
     * @param nome nome do atributo
     * @param tipo tipo do atributo
     * @param isPrivate se é privado
     * @return o próprio modelo, pra encadear chamadas
     */
    public ClasseModelo addAtributo(String nome, TipoDado tipo, boolean isPrivate) {
        atributos.add(new Atributo(nome, tipo, isPrivate));
        return this;
    }

    /**
     * Adiciona um método ao modelo.
     *
     * @param metodo método a adicionar
     * @return o próprio modelo, pra encadear chamadas
     */
    public ClasseModelo addMetodo(Metodo metodo) {
        metodos.add(metodo);
        return this;
    }

    public String getNome() {
        return nome;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public List<Metodo> getMetodos() {
        return metodos;
    }
}