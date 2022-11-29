package personal.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("madhav").password("test123").roles("STUDENT"))
			.withUser(users.username("aman").password("test123").roles("TEACHER"))
			.withUser(users.username("rakhi").password("test123").roles("ADMIN"))
			.withUser(users.username("nitu").password("test123").roles("ADMIN", "TEACHER"));
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/additional/css/**", "/additional/js/**", "/additional/images/**")
			.permitAll()
			.antMatchers("/notice/**", "/holiday/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
			.antMatchers("/performance/**").hasRole("TEACHER")
			.antMatchers("/pendingFees/**").hasRole("ADMIN")
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
