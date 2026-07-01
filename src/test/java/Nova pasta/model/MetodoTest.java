package model;

import enums.TipoDado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetodoTest {

    @Test
    void deveCriarMetodoComDadosCorretos() {
        Metodo m = new Metodo("getNome", TipoDado.STRING, true);
        assertEquals("getNome", m.getNome());
        assertEquals(TipoDado.STRING, m.getRetorno());
        assertTrue(m.isPrivate());
    }

    @Test
    void deveAdicionarParametros() {
        Metodo m = new Metodo("somar", TipoDado.INT, false);
        m.addParametro("a", TipoDado.INT);
        m.addParametro("b", TipoDado.INT);

        assertEquals(2, m.getParametros().size());
        assertEquals("a", m.getParametros().get(0).getNome());
    }
}