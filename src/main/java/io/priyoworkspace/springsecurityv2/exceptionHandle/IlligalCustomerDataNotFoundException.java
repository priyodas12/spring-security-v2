package io.priyoworkspace.springsecurityv2.exceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IlligalCustomerDataNotFoundException extends RuntimeException {
    public IlligalCustomerDataNotFoundException(String s) {
        super(s);
        System.out.println(s+" customer data not found!");
    }
}
