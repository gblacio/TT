package com.finalproject.traveltogether.configuration;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncoder {

    public String encode(String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);
        return hashedPassword;
    }

    public boolean verify(String rawPassword, String hashedPassword) {
        String encodedRawPassword = encode(rawPassword);
        return hashedPassword.equals(encodedRawPassword);
    }
}