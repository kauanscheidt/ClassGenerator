// EscritorArquivo.java
package io;

import enums.Linguagem;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Salva o código gerado em disco, criando o diretório se precisar
 * e nomeando o arquivo com a extensão certa pra cada linguagem.
 */
public class EscritorArquivo {

    /**
     * Escreve o código em um arquivo dentro do diretório informado.
     *
     * @param codigo código a salvar
     * @param nomeClasse nome do arquivo
     * @param linguagem define a extensão do arquivo
     * @param diretorio pasta onde o arquivo vai ser criado
     * @return caminho do arquivo gerado
     * @throws IOException se falhar ao criar diretório ou arquivo
     */
    public static Path escrever(String codigo, String nomeClasse, Linguagem linguagem, String diretorio) throws IOException {
        Path dir = Path.of(diretorio);
        Files.createDirectories(dir);

        Path arquivo = dir.resolve(nomeClasse + "." + linguagem.getExtensao());
        Files.writeString(arquivo, codigo);

        return arquivo;
    }
}