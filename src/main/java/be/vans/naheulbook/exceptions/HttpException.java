package be.vans.naheulbook.exceptions;

import be.vans.naheulbook.models.dtos.HttpExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class HttpException extends RuntimeException {
    private HttpExceptionDTO exception;

    public HttpException(HttpStatus status, String message) {
        super(message);
        exception = HttpExceptionDTO.builder()
                .status(status.value())
                .message(message)
                .build();
    }
}