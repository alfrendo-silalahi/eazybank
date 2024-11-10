package dev.alfrendosilalahi.eazybank.account.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(
            String resourceName,
            String fieldName,
            String fieldValue
    ) {
        super(String.format("%s with %s %s not found", resourceName, fieldName, fieldValue));
    }

}