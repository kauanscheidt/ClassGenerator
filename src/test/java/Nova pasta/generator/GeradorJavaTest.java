package test.generator;

import enums.TipoDado;
import generator.GeradorJava;
import model.ClasseModelo;
import model.Metodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorJavaTest {

    @Test
    void deveGerarClasseComAtributoEMetodo() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        modelo.addAtributo("nome", TipoDado.STRING, true);
        modelo.addMetodo(new Metodo("getNome", TipoDado.STRING, true));

        String codigo = new GeradorJava().gerar(modelo);

        assertTrue(codigo.contains("public class Pessoa {"));
        assertTrue(codigo.contains("private String nome;"));
        assertTrue(codigo.contains("private String getNome("));
        assertTrue(codigo.endsWith("}"));
    }

    @Test
    void deveGerarParametrosDeMetodoCorretamente() {
        ClasseModelo modelo = new ClasseModelo("Calc");
        Metodo m = new Metodo("somar", TipoDado.INT, false);
        m.addParametro("a", TipoDado.INT);
        m.addParametro("b", TipoDado.INT);
        modelo.addMetodo(m);

        String codigo = new GeradorJava().gerar(modelo);

        assertTrue(codigo.contains("public int somar(int a, int b) {"));
    }
}