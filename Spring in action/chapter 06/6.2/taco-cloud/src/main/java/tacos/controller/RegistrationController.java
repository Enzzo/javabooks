package tacos.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.model.User;
import tacos.repository.UserRepository;
import tacos.security.RegistrationForm;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
	private final UserRepository userRepo;
	private final PasswordEncoder encoder;
	
	public RegistrationController(UserRepository userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping
	public String registrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Register form: {}", form);
		User user = userRepo.save(form.toUser(encoder));
		log.debug("!!!!!!!!!!!!!!!!saved form: {}", user);
		return "redirect:/login";
	}
}