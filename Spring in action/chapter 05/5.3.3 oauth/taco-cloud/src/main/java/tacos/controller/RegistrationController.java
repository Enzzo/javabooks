package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.repository.UserRepository;
import tacos.security.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	
	@Autowired
	public RegistrationController(UserRepository userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping
	public String registerForm() {
		return "registration";
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		userRepo.save(form.toUser(encoder));
		return "redirect:/login";
	}
}