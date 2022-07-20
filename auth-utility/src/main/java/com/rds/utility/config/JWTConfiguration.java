package com.rds.utility.config;

import com.rds.utility.common.SecurityProperties;
import com.rds.utility.exception.AuthenticationServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JWTConfiguration {
    private final SecurityProperties securityProperties;

    @Bean
    public KeyStore keyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(securityProperties.getKeyStoreLocation());
            keyStore.load(resourceAsStream, securityProperties.getKeyStorePassword().toCharArray());
            return keyStore;
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new AuthenticationServiceException("Unable to load Keystore");
        }
    }

    @Bean
    public RSAPrivateKey jwtSigningKey(KeyStore keyStore) {
        try {
            Key key = keyStore.getKey(securityProperties.getKeyAlias(), securityProperties.getPrivateKeyPassPhrase().toCharArray());
            if (key instanceof RSAPrivateKey)
                return (RSAPrivateKey) key;
            else
                throw new AuthenticationServiceException("Unable to load private key from Keystore");
        } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new AuthenticationServiceException("Unable to load private key from keystore");
        }
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAPublicKey rsaPublicKey) {
        return NimbusJwtDecoder.withPublicKey(rsaPublicKey).build();
    }
}
