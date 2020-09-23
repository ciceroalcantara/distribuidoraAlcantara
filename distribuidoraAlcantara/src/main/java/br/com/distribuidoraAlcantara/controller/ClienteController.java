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
@RequestMapping("/clientes")
public class ClienteController {

	public String teste() {
		return "Estou sendo chamando pelo método GET";
	}

}
