package pl.cantabo.utils;

import java.util.UUID;

public class TokenUtility {

    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
