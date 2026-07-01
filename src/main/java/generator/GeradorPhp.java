package generator;

import model.Atributo;
import model.ClasseModelo;
import model.Metodo;
import java.util.List;

/**
 * Gerador de código para a linguagem PHP.
 */
public class GeradorPhp extends GeradorBase {

    @Override
    protected String gerarCabecalho(String nome) {
        return "<?php\n\nclass " + nome + " {\n\n";
    }

    @Override
    protected String gerarAtributos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        for (Atributo a : modelo.getAtributos()) {
            sb.append("    ")
                    .append(a.isPrivate() ? "private " : "public ")
                    .append("$").append(a.getNome())
                    .append(";\n");
        }
        return sb.append("\n").toString();
    }

    @Override
    protected String gerarMetodos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        for (Metodo m : modelo.getMetodos()) {
            sb.append("    ")
                    .append(m.isPrivate() ? "private " : "public ")
                    .append("function ")
                    .append(m.getNome())
                    .append("(");

            List<Atributo> params = m.getParametros();
            for (int i = 0; i < params.size(); i++) {
                sb.append("$").append(params.get(i).getNome());
                if (i < params.size() - 1) sb.append(", ");
            }
            sb.append(") {\n    }\n\n");
        }
        return sb.toString();
    }

    @Override
    protected String gerarRodape(String nome) {
        return "}\n";
    }
}