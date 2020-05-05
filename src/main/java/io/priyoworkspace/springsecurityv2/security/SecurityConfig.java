package io.priyoworkspace.springsecurityv2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //custom authentication details
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails userDetails= User.builder().username("priyo").password("####123").roles("dev").build();

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
