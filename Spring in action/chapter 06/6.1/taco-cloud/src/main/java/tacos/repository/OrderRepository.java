package tacos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.model.TacoOrder;
import tacos.model.User;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	List<TacoOrder> findByUserOrderListOrderByPlacedAtDesc(User user);
}