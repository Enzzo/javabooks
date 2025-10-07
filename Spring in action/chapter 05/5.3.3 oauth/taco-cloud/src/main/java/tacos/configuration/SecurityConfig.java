package tacos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
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
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/design", "/orders").hasRole("USER")
				.requestMatchers("/", "/**").permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.usernameParameter("usr")
				.passwordParameter("pwd")
				.defaultSuccessUrl("/design", true))
			.headers(headers -> headers
					.frameOptions(FrameOptionsConfig::sameOrigin)
			)
			.build();
	}
	
	@Bean
	UserDetailsService userDetailsService(UserRepository userRepo) {
		// Тут мы имплементируем метод UserDetailsService::loadUserByUsername(String username)
		// Этот метод не может возвращать null. Он возвращает либо найденного пользователя, либо бросает исключение
		return username -> {
			User user = userRepo.findByUsername(username);
			if(user != null) return user;
			throw new UsernameNotFoundException("User '" + username + "' not found");
		};
	}
}