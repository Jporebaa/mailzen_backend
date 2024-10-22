package pl.cantabo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenUtilityTest {

    @Test
    void testGenerate() {
        // given
        // when
        String token = TokenUtility.generate();

        // then
        assertNotNull(token);
        assertEquals(36, token.length());
        assertTrue(token.matches("[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}"));
    }
}