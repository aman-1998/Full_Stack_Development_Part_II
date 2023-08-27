package personal.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import personal.learning.web.utility.Constants;

@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/notice/**", "/holiday/**").authenticated()
			.antMatchers("/performance/**").hasRole(Constants.ROLE_TEACHER)
			.antMatchers("/pendingFees/**").hasRole(Constants.ROLE_ADMIN)
			.and()
			.formLogin()
			.loginPage("/myLogin")
			.loginProcessingUrl("/authenticateUser")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
}
