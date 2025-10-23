package tacos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.repository.OrderRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final OrderRepository orderRepo;

	public AdminController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteAllOrders() {
		orderRepo.deleteAll();
		return "/design";
	}
}