package tacos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	List<TacoOrder> findByDeliveryZip(String deliveryZip);
	List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
	List<TacoOrder> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
	List<TacoOrder> findByDeliveryCityOrderByDeliveryTo(String city);
	
//	@Query("SELECT o FROM TacoOrder where o.deliveryCity = 'Seattle'")
	List<TacoOrder> readOrdersDeliveredInSeattle();
}