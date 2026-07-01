// GeradorCodigo.java
package generator;

import model.ClasseModelo;

/**
 * Contrato dos geradores: recebe um modelo de classe e devolve o código gerado.
 */
public interface GeradorCodigo {
    String gerar(ClasseModelo modelo);
}