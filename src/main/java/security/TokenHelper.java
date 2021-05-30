package security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ftn.domzdravlja.model.Korisnik;

import time.TimeProvider;

@Component
public class TokenHelper {

    @Value("SpringProject")
    private String APP_NAME;

    @Value("somesecret")
    public String SECRET;

    @Value("300")
    private int EXPIRES_IN;

    @Value("600")
    private int MOBILE_EXPIRES_IN;

    @Value("Authorization")
    private String AUTH_HEADER;

    static final String AUDIENCE_UNKNOWN = "unknown";
    static final String AUDIENCE_WEB = "web";
    static final String AUDIENCE_MOBILE = "mobile";
    static final String AUDIENCE_TABLET = "tablet";

    @Autowired
    TimeProvider timeProvider;

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String getEmailFromToken(String token) {
        String email;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            email = claims.getSubject();
        } catch (Exception e) {
        	email = null;
        }
        return email;
    }

    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            audience = claims.getAudience();
        } catch (Exception e) {
            audience = null;
        }
        return audience;
    }

    public String refreshToken(String token, Device device) {
        String refreshedToken;
        Date a = timeProvider.now();
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            claims.setIssuedAt(a);
            refreshedToken = Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate(device))
                    .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public String generateToken(String username) {
        return Jwts.builder().setIssuer(APP_NAME).setSubject(username)
                .setIssuedAt(timeProvider.now())
                .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
    }

    private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate(Device device) {
        long expiresIn = device.isTablet() || device.isMobile() ? MOBILE_EXPIRES_IN : EXPIRES_IN;
        return new Date(timeProvider.now().getTime() + expiresIn * 1000);
    }

    public int getExpiredIn(Device device) {
        return device.isMobile() || device.isTablet() ? MOBILE_EXPIRES_IN : EXPIRES_IN;
    }


    public Boolean validateToken(String token, KorisnikDetails korisnikDetails) {
        Korisnik korisnik = (Korisnik) korisnikDetails;
        final String email = getEmailFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);
        return (email != null && email.equals(KorisnikDetails.getEmail()));
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }

}
