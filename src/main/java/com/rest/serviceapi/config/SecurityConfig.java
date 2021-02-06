package com.rest.serviceapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {

     // Hard-coded / in memory authentication
         auth.inMemoryAuthentication()
               .withUser("admin")
               .password("{noop}admin#123")
               .roles("ADMIN")
               .and()
               .withUser("shd")
               .password("{noop}shdhsn")
               .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors();
        http.authorizeRequests()
                .antMatchers("/contacts/**").hasRole("USER")
                .antMatchers("/auth/**").hasAnyRole("ADMIN")

               /*.antMatchers("/auth/**").permitAll() --> to permit all users
                .antMatchers("/edit-contact/**").hasRole("ADMIN")
                .antMatchers("/edit-employee/{id}").hasRole("ADMIN")
*/
                .anyRequest().fullyAuthenticated()

                .and().csrf().disable()

                .httpBasic();
    }

  /*  @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
*/
}
