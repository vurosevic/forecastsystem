package deloitte.forecastsystem_bih.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")	
	private UserDetailsService userDetailsService;
	
	@Qualifier("authenticationManagerBean")
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${deloitte.oauth.tokenTimeout:360000}")
	private int expiration;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager);
		configurer.userDetailsService(userDetailsService); 
	}
	
	public void configure(ClientDetailsServiceConfigurer clients) throws  Exception {
		clients.inMemory().withClient("deloitte").secret("$2a$12$fXD1iU65H7J12IucpNIZT.esQ6k6pH08I0BCaf6jSGvk6bDk5xazm").accessTokenValiditySeconds(expiration).scopes("read","write").authorizedGrantTypes("password", "refresh_token").resourceIds("resource");
	}
	
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        //... other config

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();

        // Maybe there's a way to use config from AuthorizationServerEndpointsConfigurer endpoints?
        source.registerCorsConfiguration("/oauth/token", config);
        CorsFilter filter = new CorsFilter(source);
        security.addTokenEndpointAuthenticationFilter(filter);
    }	
}
