// GeradorBase.java
package generator;

import enums.TipoDado;
import model.ClasseModelo;

/**
 * Base dos geradores. Define o fluxo fixo de geração (cabeçalho, atributos,
 * métodos e rodapé) e deixa cada linguagem implementar do seu jeito.
 */
public abstract class GeradorBase implements GeradorCodigo {

    @Override
    public final String gerar(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();

        sb.append(gerarCabecalho(modelo.getNome()));
        sb.append(gerarAtributos(modelo));
        sb.append(gerarMetodos(modelo));
        sb.append(gerarRodape(modelo.getNome()));

        return sb.toString();
    }

    protected abstract String gerarCabecalho(String nome);
    protected abstract String gerarAtributos(ClasseModelo modelo);
    protected abstract String gerarMetodos(ClasseModelo modelo);
    protected abstract String gerarRodape(String nome);

    /**
     * Traduz um tipo abstrato pro tipo equivalente na linguagem gerada.
     * Subclasses podem sobrescrever quando precisarem de mapeamento diferente.
     *
     * @param tipo tipo abstrato
     * @return tipo correspondente na linguagem de destino
     */
    protected String traduzirTipo(TipoDado tipo) {
        switch (tipo) {
            case INT:     return "int";
            case DOUBLE:  return "double";
            case FLOAT:   return "float";
            case STRING:  return "String";
            case BOOLEAN: return "boolean";
            case VOID:    return "void";
            case CHAR:    return "char";
            case LONG:    return "long";
            default:      return "Object";
        }
    }
}