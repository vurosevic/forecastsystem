package deloitte.forecastsystem_bih.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import deloitte.forecastsystem_bih.config.filter.CORSFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("resource");
    }	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//-- define URL patterns to enable OAuth2 security
        http.authorizeRequests()
        .antMatchers("/resource").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
        
        //.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("/oauth/token").permitAll().
//        anyRequest().authenticated();
	}
	
}
