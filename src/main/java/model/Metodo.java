// Metodo.java
package model;

import enums.TipoDado;
import java.util.ArrayList;
import java.util.List;

/**
 * Um método de classe: nome, retorno, visibilidade e parâmetros.
 */
public class Metodo {

    private String nome;
    private TipoDado retorno;
    private boolean isPrivate;
    private List<Atributo> parametros;

    public Metodo(String nome, TipoDado retorno, boolean isPrivate) {
        this.nome = nome;
        this.retorno = retorno;
        this.isPrivate = isPrivate;
        this.parametros = new ArrayList<>();
    }

    /**
     * Adiciona um parâmetro ao método.
     *
     * @param nome nome do parâmetro
     * @param tipo tipo do parâmetro
     * @return o próprio método, pra encadear chamadas
     */
    public Metodo addParametro(String nome, TipoDado tipo) {
        parametros.add(new Atributo(nome, tipo, false));
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDado getRetorno() {
        return retorno;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public List<Atributo> getParametros() {
        return parametros;
    }
}