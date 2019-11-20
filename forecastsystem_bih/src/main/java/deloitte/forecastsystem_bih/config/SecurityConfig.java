package deloitte.forecastsystem_bih.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager    authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//         authenticationProvider.setUserDetailsService(userDetailsService);
//         authenticationProvider.setPasswordEncoder(passwordEncoder());
//         return authenticationProvider;
//    }    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    }
      
    
}
