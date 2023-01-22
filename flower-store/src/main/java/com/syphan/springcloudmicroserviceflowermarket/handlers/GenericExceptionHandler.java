package com.syphan.springcloudmicroserviceflowermarket.handlers;

import com.syphan.springcloudmicroserviceflowermarket.dto.BeanValidationExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GenericExceptionHandler {

    // Spring throws this exception when entity is not found
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundException> handle404Error() {
        return ResponseEntity.notFound().build();
    }


    // Spring throws this exception when the request body is not valid by bean validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<BeanValidationExceptionDto>> handle400Error(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(
                errors.stream().map(BeanValidationExceptionDto::new).toList()
        );
    }
}
