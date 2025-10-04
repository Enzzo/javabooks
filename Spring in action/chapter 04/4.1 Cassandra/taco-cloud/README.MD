<h1> Заметки к этой главе:<h1>
<h3>Пример использования Spring Data Cassandra</h3>
<ol>
	<li>Удаляем зависимости <b>jpa, jdbc, h2</b> и добавляем <b>spring-boot-starter-data-cassandra</b></li>
	<li>Выполним установку и запуск <b>Cassandra</b> в <b>Docker</b>:<br />
		<code>docker run --name my-cassandra -p 9042:9042 --hostname cassandra --network cassandra-net cassandra:latest</code>
		<br>
	</li>
	<li>
		Войдём в Cassandra:<br>
		<code> docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra</code>
	</li>
	<li>Далее определим пространство ключей для того, чтобы обеспечить группировку таблиц:<br />
		<code>create keyspace tacocloud with replication={'class':'SimpleStrategy', 'replication_factor':1} and durable_writes=true;</code>
	</li>
	<li>
		Все сущности придётся переписать, так как они должны быть денормализованы
	</li>
	<li>
		Всё, что было полем из пользовательского типа, следует переименовать в <code>UserDefinedType (UDT)</code>. Это будут полями типов.<br />
		А обычные сущности помечаются аннотацией <code>@Table</code>
	</li>
	<li>
		Так же следует добавить новый конвертер, чтобы с шаблонизатора летящая строка выдавала <b>IngredientUDT</b>, а не <b>Ingredient</b>
	</li>
</ol>