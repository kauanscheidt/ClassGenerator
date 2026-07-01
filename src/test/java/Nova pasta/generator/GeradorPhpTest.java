package test.generator;

import enums.TipoDado;
import generator.GeradorPhp;
import model.ClasseModelo;
import model.Metodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorPhpTest {

    @Test
    void deveGerarClasseComAtributoEMetodo() {
        ClasseModelo modelo = new ClasseModelo("Pessoa");
        modelo.addAtributo("nome", TipoDado.STRING, true);
        modelo.addMetodo(new Metodo("getNome", TipoDado.STRING, true));

        String codigo = new GeradorPhp().gerar(modelo);

        assertTrue(codigo.contains("<?php"));
        assertTrue(codigo.contains("class Pessoa {"));
        assertTrue(codigo.contains("private $nome;"));
        assertTrue(codigo.contains("private function getNome("));
    }

    @Test
    void deveGerarParametrosComCifrao() {
        ClasseModelo modelo = new ClasseModelo("Calc");
        Metodo m = new Metodo("somar", TipoDado.INT, false);
        m.addParametro("a", TipoDado.INT);
        modelo.addMetodo(m);

        String codigo = new GeradorPhp().gerar(modelo);

        assertTrue(codigo.contains("public function somar($a) {"));
    }
}