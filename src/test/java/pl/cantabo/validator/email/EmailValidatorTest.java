package pl.cantabo.validator.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class EmailValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"example@example.com", "example@example.gov.co", "123@example.gov.co", "example@123.123.123.123", "Example Com <example@example.com>"})
    void validate_true(String email) {
        EmailValidator.validate(email);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"example@example.gov.", "example@.example.gov", ".@example.gov", "!@#@example.gov", "@example.gov", "example", "example@", "example@123.123.123.123.", ""})
    void validate_false(String email) {
        assertThrows(EmailValidatorException.class, () -> EmailValidator.validate(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"example@example.com", "example@example.gov.co", "123@example.gov.co", "example@123.123.123.123", "Example Com <example@example.com>"})
    void isValidAnnotation_true(String email) {
        EmailValidator validator = new EmailValidator(); //any(Email.class)
        assertTrue(validator.isValid(email, any(ConstraintValidatorContext.class)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"example@example.gov.", "example@.example.gov", ".@example.gov", "!@#@example.gov", "@example.gov", "example", "example@", "example@123.123.123.123.", ""})
    void isValidAnnotation_false(String email) {
        EmailValidator validator = new EmailValidator(); //any(Email.class)
        assertFalse(validator.isValid(email, any(ConstraintValidatorContext.class)));
    }

    @Test
    void testInitialize() {
        EmailValidator validator = new EmailValidator();
        validator.initialize(any(Email.class));
    }
}