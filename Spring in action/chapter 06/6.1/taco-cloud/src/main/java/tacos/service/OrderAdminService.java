package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.repository.OrderRepository;

@Service
public class OrderAdminService {
	private final OrderRepository orderRepository;

	@Autowired
	public OrderAdminService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public void deleteAllOrders() {
		orderRepository.deleteAll();
	}
}