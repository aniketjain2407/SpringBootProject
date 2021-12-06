package RawMaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import RawMaterial.Service.UserService;
import RawMaterial.Service.UserServiceImp;

@Configuration
@EnableWebSecurity
@ComponentScan
public class Securityconfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService myUserDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService((UserDetailsService) myUserDetailsService);
		
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/user/**").hasAuthority("Admin")
			.antMatchers("/accountant/**").hasAnyAuthority("Admin","Accountant")
			.antMatchers("/student/**").permitAll()
			.and()
			.authorizeRequests().anyRequest().authenticated().and()
			.formLogin().and().logout().permitAll()
			.and().csrf().disable();

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers( "/h2-console/**");
	}
	
	
	
	
	
}
