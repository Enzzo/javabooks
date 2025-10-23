package tacos.web.api;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.repository.OrderRepository;
import tacos.model.TacoOrder;

@RestController
@RequestMapping(path="/api/orders", produces="application/json")
@CrossOrigin(origins={"http://tacocloud:8080", "http://tacocloud.com"})
public class OrderController {
	OrderRepository orderRepo;

	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	// Если у сущности order какие-то поля не будут заданы, то в базу полетят пустые значения на этих местах
	@PutMapping(path="/{orderId}", consumes="application/json")
	public TacoOrder putOrder(@PathVariable Long orderId, @RequestBody TacoOrder order) {
		order.setId(orderId);
		return orderRepo.save(order);
	}
	
	@PatchMapping(path="/{orderId}", consumes="application/json")
	public TacoOrder patchOrder(@PathVariable Long orderId, @RequestBody TacoOrder patch) {
		TacoOrder order = orderRepo.findById(orderId).get();
		
		if(patch.getDeliveryName() != null) {
			order.setDeliveryName(patch.getDeliveryName());
		}
		
		if(patch.getDeliveryStreet() != null) {
			order.setDeliveryStreet(patch.getDeliveryStreet());
		}
		
		if(patch.getDeliveryCity() != null) {
			order.setDeliveryCity(patch.getDeliveryCity());
		}
		
		if(patch.getDeliveryState() != null) {
			order.setDeliveryState(patch.getDeliveryState());
		}
		
		if(patch.getDeliveryZip() != null) {
			order.setDeliveryZip(patch.getDeliveryZip());
		}
		
		if(patch.getCcNumber() != null) {
			order.setCcNumber(patch.getCcNumber());
		}
		
		if(patch.getCcExpiration() != null) {
			order.setCcExpiration(patch.getCcExpiration());
		}
		
		if(patch.getCcCVV() != null) {
			order.setCcCVV(patch.getCcCVV());
		}
		
		return orderRepo.save(order);
	}
	
	@DeleteMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void deleteOrder(@PathVariable Long orderId) {
		try {
			orderRepo.deleteById(orderId);
		}catch(EmptyResultDataAccessException e) {}
	}
}