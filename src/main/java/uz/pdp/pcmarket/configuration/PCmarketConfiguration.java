package uz.pdp.pcmarket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PCmarketConfiguration extends WebSecurityConfiguration {

    //WebSecurityConfigurationAdapter ni extends qila olmadim dependencies ham qo'shib ko'rdim ishlamadi shunga shundan foydalandim

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("SUPER_ADMIN").password(passwordEncoder().encode("SUPER_ADMIN")).roles("SUPER_ADMIN")
                .and().withUser("MODERATOR").password(passwordEncoder().encode("MODERATOR")).roles("MODERATOR")
                .and().withUser("OPERATOR").password(passwordEncoder().encode("OPERATOR")).roles("OPERATOR");
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
