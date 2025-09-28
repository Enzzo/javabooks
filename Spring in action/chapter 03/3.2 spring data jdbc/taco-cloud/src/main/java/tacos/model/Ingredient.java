package tacos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table
public class Ingredient implements Persistable<String>{ // Что такое Persistable - впервые вижу. И в книге ничего не говорилось об этом
	@Id
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