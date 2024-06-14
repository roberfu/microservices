package cl.springmachine.ms.commons.dto;

public class ClientResponseDto {

	private String message;
	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ClientResponseDto(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

}
