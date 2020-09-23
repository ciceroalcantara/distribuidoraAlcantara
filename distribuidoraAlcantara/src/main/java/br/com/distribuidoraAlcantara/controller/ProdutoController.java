/**
 * 
 */
package br.com.distribuidoraAlcantara.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	public String teste() {
		return "Controller de produtos funcionando";
	}
	
}
