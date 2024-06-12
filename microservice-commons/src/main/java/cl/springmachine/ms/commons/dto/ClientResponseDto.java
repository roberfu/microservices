package cl.springmachine.ms.commons.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDto {

    private String message;
    private boolean success;
}
