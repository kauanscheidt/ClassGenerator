package generator;

import enums.TipoDado;
import model.Atributo;
import model.ClasseModelo;
import model.Metodo;
import java.util.List;

/**
 * Gerador de código para a linguagem Python.
 */

public class GeradorCpp extends GeradorBase {

    @Override
    protected String gerarCabecalho(String nome) {
        return "#ifndef " + nome.toUpperCase() + "_H\n" +
                "#define " + nome.toUpperCase() + "_H\n\n" +
                "class " + nome + " {\n\n";
    }

    @Override
    protected String gerarAtributos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        sb.append("private:\n");
        for (Atributo a : modelo.getAtributos()) {
            if (a.isPrivate()) {
                sb.append("    ")
                        .append(traduzirTipo(a.getTipo()))
                        .append(" ").append(a.getNome()).append(";\n");
            }
        }
        sb.append("\npublic:\n");
        for (Atributo a : modelo.getAtributos()) {
            if (!a.isPrivate()) {
                sb.append("    ")
                        .append(traduzirTipo(a.getTipo()))
                        .append(" ").append(a.getNome()).append(";\n");
            }
        }
        return sb.append("\n").toString();
    }

    @Override
    protected String gerarMetodos(ClasseModelo modelo) {
        StringBuilder sb = new StringBuilder();
        for (Metodo m : modelo.getMetodos()) {
            sb.append("    ")
                    .append(traduzirTipo(m.getRetorno()))
                    .append(" ").append(m.getNome()).append("(");

            List<Atributo> params = m.getParametros();
            for (int i = 0; i < params.size(); i++) {
                Atributo p = params.get(i);
                sb.append(traduzirTipo(p.getTipo())).append(" ").append(p.getNome());
                if (i < params.size() - 1) sb.append(", ");
            }
            sb.append(");\n");
        }
        return sb.append("\n").toString();
    }

    @Override
    protected String gerarRodape(String nome) {
        return "};\n\n#endif";
    }

    @Override
    protected String traduzirTipo(TipoDado tipo) {
        switch (tipo) {
            case INT:     return "int";
            case DOUBLE:  return "double";
            case FLOAT:   return "float";
            case STRING:  return "std::string";
            case BOOLEAN: return "bool";
            case VOID:    return "void";
            case CHAR:    return "char";
            case LONG:    return "long";
            default:      return "auto";
        }
    }
}