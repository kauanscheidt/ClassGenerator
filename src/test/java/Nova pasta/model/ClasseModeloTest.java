package test.model;

import enums.TipoDado;
import model.ClasseModelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClasseModeloTest {

    @Test
    void deveCriarComNomeCorreto() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        assertEquals("Pessoa", modelo.getNome());
    }

    @Test
    void deveAdicionarAtributo() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        modelo.addAtributo("nome", TipoDado.STRING, true);
        assertEquals(1, modelo.getAtributos().size());
    }
}