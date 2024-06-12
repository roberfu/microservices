package cl.springmachine.ms.client.web;

import cl.springmachine.ms.commons.dto.ClientResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ClientController {

    @GetMapping()
    public ClientResponseDto get() {
        return ClientResponseDto.builder()
                .message("its all good man")
                .success(true)
                .build();
    }
}
