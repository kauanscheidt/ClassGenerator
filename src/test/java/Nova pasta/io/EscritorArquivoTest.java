package io;

import enums.Linguagem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class EscritorArquivoTest {

    @Test
    void deveEscreverArquivoComExtensaoCorreta(@TempDir Path tempDir) throws Exception {
        Path arquivo = EscritorArquivo.escrever("public class X {}", "X", Linguagem.JAVA, tempDir.toString());

        assertTrue(Files.exists(arquivo));
        assertEquals("X.java", arquivo.getFileName().toString());
        assertEquals("public class X {}", Files.readString(arquivo));
    }

    @Test
    void deveUsarExtensaoCorretaPorLinguagem(@TempDir Path tempDir) throws Exception {
        Path arquivo = EscritorArquivo.escrever("class X: pass", "X", Linguagem.PYTHON, tempDir.toString());
        assertEquals("X.py", arquivo.getFileName().toString());
    }
}