package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.service.OrderAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final OrderAdminService adminService;

	@Autowired
	public AdminController(OrderAdminService adminService) {
		this.adminService = adminService;
	}
	
	@PreAuthorize("hasRole('ADMIN')") // Запрещаем доступ к методу всем неадминам
	@PostMapping("/deleteOrders")
	public String deleteAllOrders() {
		adminService.deleteAllOrders();
		return "redirect:/admin";
	}
}