package projet.factory.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import projet.factory.service.CustomUserDetailsService;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	// definition des urls accessibles en direct ou en authentifier
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous();
		http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic().and().csrf().disable();
		http.authorizeRequests().antMatchers("/**").hasRole("ADMIN").and().formLogin().loginPage("/login")
				.failureUrl("/login?error=true").permitAll().and().logout().logoutSuccessUrl("/home");
		*/
		http.authorizeRequests().antMatchers("/**").permitAll();
	}

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncorder());
	}

	@Bean
	public PasswordEncoder getPasswordEncorder() {
		return new BCryptPasswordEncoder();
	}

}
