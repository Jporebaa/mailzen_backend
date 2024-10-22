package pl.cantabo.validator.email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED, reason = "E-mail validation failed")
public class EmailValidatorException extends RuntimeException {

    EmailValidatorException(String message) {
        super(message);
    }
}
