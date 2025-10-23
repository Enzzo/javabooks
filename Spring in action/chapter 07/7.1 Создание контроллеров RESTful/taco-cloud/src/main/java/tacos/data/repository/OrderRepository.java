package tacos.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.model.TacoOrder;
import tacos.model.User;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}