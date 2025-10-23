package tacos.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.model.TacoOrder;
import tacos.model.User;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	Iterable<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}