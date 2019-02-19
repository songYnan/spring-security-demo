package sso_auth.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Sso
@SpringBootApplication
public class SsoApplication {
    private static final Logger log = LoggerFactory.getLogger(SsoApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoApplication.class)
                .run(args);
    }
}

