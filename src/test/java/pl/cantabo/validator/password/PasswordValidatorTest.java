package pl.cantabo.validator.password;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"P@ssword1", "PASword!1", "6^PasWord", "Pas$wo6d", ")pas45^WOr5d"})
    void validate_true(String password) {
        PasswordValidator.validate(password);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"qwerty", "PASSWORD1@", "password1@", "Password@", "Password1"})
    void validate_false(String password) {
        assertThrows(PasswordValidatorException.class, () -> PasswordValidator.validate(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"P@ssword1", "PASword!1", "6^PasWord", "Pas$wo6d", ")pas45^WOr5d"})
    void isValidAnnotation_true(String password) {
        PasswordValidator validator = new PasswordValidator(); //any(Password.class)
        assertTrue(validator.isValid(password, any(ConstraintValidatorContext.class)));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"qwerty", "PASSWORD1@", "password1@", "Password@", "Password1"})
    void isValidAnnotation_false(String password) {
        PasswordValidator validator = new PasswordValidator(); //any(Password.class)
        assertFalse(validator.isValid(password, any(ConstraintValidatorContext.class)));
    }

    @Test
    void testInitialize() {
        PasswordValidator validator = new PasswordValidator();
        validator.initialize(any(Password.class));
    }
}
