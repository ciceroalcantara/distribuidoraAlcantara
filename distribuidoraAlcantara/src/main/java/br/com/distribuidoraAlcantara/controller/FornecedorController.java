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
@RequestMapping("/fornecedores")
public class FornecedorController {

	public String teste() {
		return "Controller de fornecedores funcionando";
	}

}
