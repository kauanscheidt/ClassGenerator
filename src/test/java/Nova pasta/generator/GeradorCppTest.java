package generator;

import enums.TipoDado;
import model.ClasseModelo;
import model.Metodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorCppTest {

    @Test
    void deveGerarHeaderGuard() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");

        String codigo = new GeradorCpp().gerar(modelo);

        assertTrue(codigo.contains("#ifndef PESSOA_H"));
        assertTrue(codigo.contains("#define PESSOA_H"));
        assertTrue(codigo.contains("#endif"));
    }

    @Test
    void deveSepararAtributosPublicosEPrivados() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        modelo.addAtributo("nome", TipoDado.STRING, true);
        modelo.addAtributo("idade", TipoDado.INT, false);

        String codigo = new GeradorCpp().gerar(modelo);

        assertTrue(codigo.contains("private:"));
        assertTrue(codigo.contains("std::string nome;"));
        assertTrue(codigo.contains("public:"));
        assertTrue(codigo.contains("int idade;"));
    }

    @Test
    void deveTraduzirTipoBooleanParaBool() {
        ClasseModelo modelo = new ClasseModelo("Flag");
        Metodo m = new Metodo("ativo", TipoDado.BOOLEAN, false);
        modelo.addMetodo(m);

        String codigo = new GeradorCpp().gerar(modelo);

        assertTrue(codigo.contains("bool ativo("));
    }
}