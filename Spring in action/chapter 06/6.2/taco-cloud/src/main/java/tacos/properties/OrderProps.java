package tacos.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="taco.orders")
@Validated	// для ограничения min/max (не обязательно)
public class OrderProps {
	@Min(value=5, message="must be between 5 and 25")
	@Max(value=5, message="must be between 5 and 25")
	private int pageSize = 20;
}