package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tacos.model.User;
import tacos.repository.UserRepository;

@Configuration
public class SecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		List<UserDetails> userList = new ArrayList<>();
//		userList.add(new User("buzz", encoder.encode("123"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//		userList.add(new User("woody", encoder.encode("321"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//		return new InMemoryUserDetailsManager(userList);
//	}
	
	@Bean
	UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if(user != null) {
				return user;
			}
			throw new UsernameNotFoundException("User '" + username + "' not found");
		};
	}
	
	@Bean
	SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
		http
		.csrf(csrf ->
			csrf.ignoringRequestMatchers("/h2-console/**")
		)
		.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/design", "/orders").hasRole("USER")
			.requestMatchers("/", "/**", "/h2-console/**").permitAll();
		})
		.formLogin(form -> 
			form.loginPage("/login").permitAll().defaultSuccessUrl("/design", true)
		)
		.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())
		);
		return http.build();
	}
}