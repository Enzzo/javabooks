package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tacos.model.User;
import tacos.repository.UserRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{
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
//	
//	@Bean
//	SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
//		http
//		.csrf(csrf -> csrf
//				.ignoringRequestMatchers("/h2-console/**")
//				.disable()
//		)
//		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/design", "/orders").hasRole("USER")
//				.requestMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
//				.requestMatchers("/", "/**", "/h2-console/**", "/login").permitAll()
//		)
//		.formLogin(form -> form
//				.loginPage("/login")
////				TODO: Эта хрень не работает. Не хватает эндпоинта
////				.loginProcessingUrl("/authenticate")
//				.usernameParameter("usr")
//				.passwordParameter("pwd")
//				.defaultSuccessUrl("/design", true)
//		)
//		.oauth2Login(login -> login
//				.loginPage("/login")
//				.defaultSuccessUrl("/design", true))
//		.headers(headers -> headers
//				.frameOptions(frameOptions -> frameOptions.sameOrigin())
//		)
//		.logout(logout -> logout
//				.logoutSuccessUrl("/")
//		);
//		return http.build();
//	}
}