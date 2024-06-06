package uz.pdp.back.security;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import uz.pdp.back.entity.Role;
import uz.pdp.back.entity.User;
import uz.pdp.back.exception.TokenExpiredException;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {
    public String generateToken(User user) {
        return "Bearer " + Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 10))
                .claim("roles", user.getRoles())
                .signWith(getPrivateKey())
                .compact();
    }

    public String generateRefreshToken(User user) {
        return "Bearer " + Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .claim("roles", user.getRoles())
                .signWith(getPrivateKey())
                .compact();
    }

    private Key getPrivateKey() {
        byte[] bytes = Decoders.BASE64.decode("a2345678a2345678a2345678a2345678a2345678a2345678a2345678a2345678");
        return Keys.hmacShaKeyFor(bytes);
    }

    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException("Token is expired");
        }
    }

    public String getEmail(String token) {
        Jws<Claims> claimsJws = getClaims(token);
        return claimsJws.getBody().getSubject();
    }

    public List<Role> getRoles(String token) {
        Jws<Claims> claimsJws = getClaims(token);
        String json = claimsJws.getBody().get("roles").toString();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        List<Role> roles = gson.fromJson(json, new TypeToken<List<Role>>() {
        }.getType());
        return roles;
    }

    private Jws<Claims> getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getPrivateKey())
                .build()
                .parseClaimsJws(token);
    }
}
