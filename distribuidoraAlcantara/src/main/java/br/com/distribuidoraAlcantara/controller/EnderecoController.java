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
@RequestMapping("/enderecos")
public class EnderecoController {

	public String teste() {
		return "Controller de enderecos funcionando";
	}
	
}
