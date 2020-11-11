/**
 * 
 */
package br.com.distribuidoraAlcantara.exception;

/**
 * @author cicer
 *
 */
public class EntidadeComDependencias extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeComDependencias(String mensagem) {
		super(mensagem);
	}
}
