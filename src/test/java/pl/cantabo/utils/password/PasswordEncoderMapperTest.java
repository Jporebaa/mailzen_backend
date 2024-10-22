package pl.cantabo.utils.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordEncoderMapperTest {

    @Mock
    PasswordEncoder passwordEncoder;

    PasswordEncoderMapper passwordEncoderMapper;

    @BeforeEach
    void setUp() {
        passwordEncoderMapper = new PasswordEncoderMapper(passwordEncoder);
    }

    @Test
    void encode() {
        // given
        String rawPassword = "Password1@";
        String encodedPassword = "$2a$10$8Vh2DUCryppa.MzC6gENJOY7Rw.00FP5UkuVTcPqceXLO0/FTrFA6";
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);

        //when
        String result = passwordEncoderMapper.encode(rawPassword);

        //then
        assertEquals(encodedPassword, result);
    }
}
