package tacos.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.model.TacoOrder;
import tacos.model.User;
import tacos.properties.OrderProps;
import tacos.repository.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
	
	private OrderRepository orderRepo;
	private OrderProps props;
	
	public OrderController(OrderRepository orderRepo, OrderProps props) {
		this.orderRepo = orderRepo;
		this.props = props;
	}
	
	@GetMapping
	public String ordersForUser(
			@AuthenticationPrincipal User user,
			Model model
			) {
		Pageable pageable = PageRequest.of(0, props.getPageSize());
		
		List<TacoOrder> orders = StreamSupport.stream(orderRepo.findByUserOrderByPlacedAtDesc(user, pageable).spliterator(), false).toList();
		
		model.addAttribute("orders", orders);
		return "orderList";
	}

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
		log.debug("POST /orders");
		log.debug("Order: {}", order);
		if(errors.hasErrors()) {
			return "orderForm";
		}
		
		orderRepo.save(order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}