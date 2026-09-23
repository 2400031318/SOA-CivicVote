package com.civicvote.voting.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            "CivicVoteSecretKeyForJwtAuthentication123456789".getBytes()
    );

    public SecretKey getSecretKey() {
        return secretKey;
    }
}