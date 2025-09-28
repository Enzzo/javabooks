# Заметки к этой главе:
## Пример использования чистого JDBC
1. Добавим зависимости `spring-boot-starter-jdbc` и `h2`;
2. Изменим класс `TacoOrder`, чтобы его моно было сериализовать:<br>
```java
public class TacoOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	// ...
	}
```

3. Добавляем класс IngredientRepository (ничего не имплементирует)