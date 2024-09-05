package com.example.jwt_authentication.Configuration;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.Authentication;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
// import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.JOSEException;
// import com.nimbusds.jose.jwk.JWKSelector;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
// import org.springframework.security.oauth2.jwt.JwtClaimsSet;

@Configuration
public class JwtConfig {

    @Bean
    public KeyPair keyPair() {
        try {
            var keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        return new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .algorithm(com.nimbusds.jose.JWSAlgorithm.RS256)
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
        return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }

    //  @Bean
    // public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
    //     return new NimbusJwtEncoder(jwkSource);
    // }

     

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<com.nimbusds.jose.proc.SecurityContext> jwkSource) {
        // Create and return your JwtEncoder bean
        return new NimbusJwtEncoder(jwkSource);
    }
}



