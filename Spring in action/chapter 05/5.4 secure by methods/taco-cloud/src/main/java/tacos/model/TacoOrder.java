package tacos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class TacoOrder implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date placedAt;
	
	@NotBlank(message = "Delivery name is required")
	private String deliveryName;
	
	@NotBlank(message = "Street is required")
	private String deliveryStreet;
	
	@NotBlank(message = "City is required")
	private String deliveryCity;
	
	@NotBlank(message = "State is required")
	private String deliveryState;
	
	@NotBlank(message = "Zip code is required")
	private String deliveryZip;
	
	@CreditCardNumber(message = "Not a valid credit card number")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
			message="Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CCV")
	private String ccCVV;
	
	@ManyToMany(targetEntity = Taco.class)
	@NotNull
	private List<Taco> tacos = new ArrayList<>();
	
	@ManyToOne
	private User user;
	
	public TacoOrder() {
	}
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
	
	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}