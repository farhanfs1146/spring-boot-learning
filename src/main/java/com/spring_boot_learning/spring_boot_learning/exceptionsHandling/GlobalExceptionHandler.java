package com.spring_boot_learning.spring_boot_learning.exceptionsHandling;

import com.spring_boot_learning.spring_boot_learning.APIResponse.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tools.jackson.databind.exc.InvalidFormatException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice // A shortcut annotation that combines @ControllerAdvice with @ResponseBody,
// in effect simply an @ControllerAdvice whose exception handler methods render to the response body.
//By default, @RestControllerAdvice applies to any controller, including @Controller and @RestController.
// Use attributes of the annotation to apply more specific filtering criteria.

public class GlobalExceptionHandler {

    // ✅ Validation Errors (DTO validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.warn("Validation error: {}", errors);

        return ResponseEntity.badRequest()
                .body(APIResponse.error("Validation failed", errors));
    }

    // ✅ Runtime Exceptions (business logic)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponse<Void>> handleRuntimeException(RuntimeException ex) {
        log.error("Runtime error: {}", ex.getMessage(), ex);

        return ResponseEntity.badRequest()
                .body(APIResponse.error(ex.getMessage()));
    }

    // ✅ Fallback for all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<Void>> handleGenericException(Exception ex) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(APIResponse.error("An unexpected error occurred"));
    }

    // handling enum values here as well.
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse<String>> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex) {

        if (ex.getCause() instanceof InvalidFormatException invalidFormatException) {

            Class<?> targetType = invalidFormatException.getTargetType();

            // ✅ Handle ANY enum type
            if (targetType.isEnum()) {

                String fieldName = invalidFormatException.getPath()
                        .stream()
                        .map(ref -> ref.getPropertyName())
                        .filter(name -> name != null)
                        .findFirst()
                        .orElse("unknownField");

                Object[] enumValues = targetType.getEnumConstants();

                return ResponseEntity.badRequest().body(
                        APIResponse.error(
                                "Invalid value for '" + fieldName + "'. Allowed values: "
                                        + Arrays.toString(enumValues)
                        )
                );
            }
        }
        return ResponseEntity.badRequest()
                .body(APIResponse.error("Invalid request body or data format"));
    }
}
