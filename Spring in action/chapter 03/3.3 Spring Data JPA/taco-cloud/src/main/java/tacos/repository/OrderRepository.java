package tacos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.model.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	TacoOrder save(TacoOrder order);
	List<TacoOrder> findByDeliveryZip(String deliveryZip);
	List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
	List<TacoOrder> findByDeliveryStreetAndDeliveryCityAllIgnoreCase(String deliveryStreet, String deliveryCity);
	List<TacoOrder> findByDeliveryCityOrderByDeliveryStreet(String city);
	
	@Query("Select o from TacoOrder o where o.deliveryCity='Seattle'")
	List<TacoOrder> readOrdersDeliveredInSeattle();
}