package start;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import start.servlet.VerifyServlet;
/**
 * @author ql
 */
@SpringBootApplication
@EnableJpaRepositories("start.repository")//为了使repository包能够被扫描到
@EnableAuthorizationServer
public class AuthenticationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthenticationApplication.class)
                .run(args);
    }
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}

