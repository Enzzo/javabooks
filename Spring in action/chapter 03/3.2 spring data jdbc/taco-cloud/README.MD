# Заметки к этой главе:
## Пример использования Spring Data JDBC
- удалим зависимость `spring-boot-starter-jdbc` и добавим `spring-boot-starter-data-jdbc` <br>
- Расширим интерфейсы `ingredientRepository extends Repository<Ingredient, String>` и `OrderRepository extends CrudRepository<TacoOrder, Long>` <br>
- Аннотируем наши <strong>Entity</strong>, чтобы библиотека Spring Data JDBC знала, как их сохранять (`@Id`, `@Table`):<br>
- `CommandLineRunner` и `ApplicationRunner` - это два функциональных интерфейса. Используем их для загрузки данных в базу<br>
Эти интерфейсы отличаются методом `run()`. В `CommandLine` этот метод принимает строку со всеми параметрами командной строки, а `ApplicationRunner` - параметр типа `ApplicationArguments`, предлагающий методы доступа к отдельным аргументам, извлечённым из командной строки.