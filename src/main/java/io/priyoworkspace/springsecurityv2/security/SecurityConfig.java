package io.priyoworkspace.springsecurityv2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //fields
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //custom authentication details
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails userDetails= User
                .builder()
                .username("priyo") //authentication details
                .password(passwordEncoder.encode("xxxx65x"))
                .roles("dev") //authorization details
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //any request coming through any controller end point to be authenticated.
        //Basic auth:browser based authentication;no way to logout
        http.
                authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")//whitelisting url
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();




    }
}
