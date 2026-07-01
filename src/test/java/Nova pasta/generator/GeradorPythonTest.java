package generator;

import enums.TipoDado;
import model.ClasseModelo;
import model.Metodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorPythonTest {

    @Test
    void deveGerarClasseComConstrutor() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        modelo.addAtributo("nome", TipoDado.STRING, true);

        String codigo = new GeradorPython().gerar(modelo);

        assertTrue(codigo.contains("class Pessoa:"));
        assertTrue(codigo.contains("def __init__(self, nome):"));
        assertTrue(codigo.contains("self.nome = nome"));
    }

    @Test
    void deveGerarMetodoComPass() {
        ClasseModelo modelo = new ClasseModelo("Calc");
        Metodo m = new Metodo("somar", TipoDado.INT, false);
        m.addParametro("a", TipoDado.INT);
        modelo.addMetodo(m);

        String codigo = new GeradorPython().gerar(modelo);

        assertTrue(codigo.contains("def somar(self, a):"));
        assertTrue(codigo.contains("pass"));
    }
}