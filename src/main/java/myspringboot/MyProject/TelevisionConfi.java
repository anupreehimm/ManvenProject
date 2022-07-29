package myspringboot.MyProject;

import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TelevisionConfi { 
	
	@Autowired
	ResourceService src;
	
	AuthenticationManager manager;
	
	@Bean
	public WebSecurityCustomizer share() {
		return(web)->web.ignoring().antMatchers("/Signup");		
		
			}
	
	@Bean
	public InMemoryUserDetailsManager silviya() {
		
		UserDetails myUser1=User.withDefaultPasswordEncoder().username("anu").
				password("Anu@2").roles("USER").build();
		UserDetails myUser2=User.withDefaultPasswordEncoder().username("Ashu").
				password("Ashu@1").roles("USER").build();
		Collection<UserDetails> myUsers=Stream.of(myUser1,myUser2).toList();
		
		return new InMemoryUserDetailsManager(myUsers);
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain praba(HttpSecurity hp) throws Exception {
		
		hp.authorizeRequests().anyRequest().authenticated();
		hp.csrf().disable();
		hp.httpBasic();
		hp.formLogin();
		
		AuthenticationManagerBuilder builder=hp.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(src).passwordEncoder(encoder());
		manager=builder.build();
		hp.authenticationManager(manager);				
		
		return hp.build();
		
	}

}
