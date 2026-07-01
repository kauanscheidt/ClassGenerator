package generator;

import enums.TipoDado;
import model.Atributo;
import model.ClasseModelo;
import model.Metodo;
import java.util.List;

/**
 * Gerador de código para a linguagem Java.
 */
public class GeradorJava extends GeradorBase {

    @Override
    protected String gerarCabecalho(String nome) {
        return "public class " + nome + " {\n\n";
    }

    @Override
    protected String gerarAtributos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        for (Atributo a : modelo.getAtributos()) {
            sb.append("    ")
                    .append(a.isPrivate() ? "private " : "public ")
                    .append(traduzirTipo(a.getTipo()))
                    .append(" ")
                    .append(a.getNome())
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
                    .append(traduzirTipo(m.getRetorno()))
                    .append(" ")
                    .append(m.getNome())
                    .append("(");

            List<Atributo> params = m.getParametros();
            for (int i = 0; i < params.size(); i++) {
                Atributo p = params.get(i);
                sb.append(traduzirTipo(p.getTipo())).append(" ").append(p.getNome());
                if (i < params.size() - 1) sb.append(", ");
            }
            sb.append(") {\n    }\n\n");
        }
        return sb.toString();
    }

    @Override
    protected String gerarRodape(String nome) {
        return "}";
    }

}