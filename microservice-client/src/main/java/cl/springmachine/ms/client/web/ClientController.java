package cl.springmachine.ms.client.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.ms.commons.dto.ClientResponseDto;

@RestController
@RequestMapping()
public class ClientController {

	@GetMapping()
	public ClientResponseDto get() {
		return new ClientResponseDto("its all good man", true);
	}
}
