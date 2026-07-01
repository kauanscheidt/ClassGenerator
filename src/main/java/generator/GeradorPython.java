package generator;

import model.Atributo;
import model.ClasseModelo;
import model.Metodo;

/**
 * Gerador de código para a linguagem Python.
 */
public class GeradorPython extends GeradorBase {

    @Override
    protected String gerarCabecalho(String nome) {
        return "class " + nome + ":\n\n";
    }

    @Override
    protected String gerarAtributos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        sb.append("    def __init__(self");
        for (Atributo a : modelo.getAtributos()) {
            sb.append(", ").append(a.getNome());
        }
        sb.append("):\n");
        for (Atributo a : modelo.getAtributos()) {
            sb.append("        self.").append(a.getNome())
                    .append(" = ").append(a.getNome()).append("\n");
        }
        return sb.append("\n").toString();
    }

    @Override
    protected String gerarMetodos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        for (Metodo m : modelo.getMetodos()) {
            sb.append("    def ").append(m.getNome()).append("(self");
            for (Atributo p : m.getParametros()) {
                sb.append(", ").append(p.getNome());
            }
            sb.append("):\n");
            sb.append("        pass\n\n");
        }
        return sb.toString();
    }

    @Override
    protected String gerarRodape(String nome) {
        return "";
    }
}