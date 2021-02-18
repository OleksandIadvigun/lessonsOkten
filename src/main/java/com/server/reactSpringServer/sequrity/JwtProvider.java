package com.server.reactSpringServer.dao.services;


import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Component
@Log
public class JwtProvider {

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512,"keyXXX")
                .compact();

    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("keyXXX").parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.severe("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.severe("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.severe("Malformed jwt");
        } catch (SignatureException sEx) {
            log.severe("Invalid signature");
        } catch (Exception e) {
            log.severe("invalid token");
        }
        return false;

    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("keyXXX").parseClaimsJws(token).getBody();
        System.out.println("subject from getLginFromToken:  " + claims.getSubject());    // todo What as result?
        return claims.getSubject();
    }

}

