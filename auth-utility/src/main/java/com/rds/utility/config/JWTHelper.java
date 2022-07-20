package com.rds.utility.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.rds.utility.common.SecurityProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JWTHelper {
    private final RSAPrivateKey rsaPrivateKey;
    private final RSAPublicKey rsaPublicKey;
    private final SecurityProperties securityProperties;

    public String createJwtForClaims(String subject, Map<String, String> claims) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date notBefore = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date issuedJwtTokenExpiry = Date.from(currentDateTime.plusHours(securityProperties.getTokenExpiryInMinutes()).atZone(ZoneId.systemDefault()).toInstant());
        JWTCreator.Builder jwtbuilder = JWT.create().withSubject(subject);
        claims.forEach(jwtbuilder::withClaim);
        return jwtbuilder.withNotBefore(notBefore)
                .withExpiresAt(issuedJwtTokenExpiry)
                .sign(Algorithm.RSA256(rsaPublicKey, rsaPrivateKey));

    }
}
