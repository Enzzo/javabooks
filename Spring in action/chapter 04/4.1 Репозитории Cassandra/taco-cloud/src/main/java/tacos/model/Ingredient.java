package tacos.model;

import org.springframework.data.domain.Persistable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient implements Persistable<String>{
//	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}