package dev.alfrendosilalahi.leafbank.ms__account.exception.handler;

import dev.alfrendosilalahi.leafbank.ms__account.dto.response.ErrorBaseResponseDto;
import dev.alfrendosilalahi.leafbank.ms__account.exception.CustomerAlreadyExistsException;
import dev.alfrendosilalahi.leafbank.ms__account.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String validationMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMessage);
        });

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorBaseResponseDto> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorBaseResponseDto.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .time(LocalDateTime.now())
                        .message(e.getMessage())
                        .apiPath(webRequest.getDescription(false))
                        .build()
                );
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorBaseResponseDto> handleCustomerAlreadyExistsException(
            CustomerAlreadyExistsException e,
            WebRequest webRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorBaseResponseDto.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .time(LocalDateTime.now())
                        .message(e.getMessage())
                        .apiPath(webRequest.getDescription(false))
                        .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBaseResponseDto> handleGeneralException(
            Exception e,
            WebRequest webRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorBaseResponseDto.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .time(LocalDateTime.now())
                        .message(e.getMessage())
                        .apiPath(webRequest.getDescription(false))
                        .build());
    }

}
