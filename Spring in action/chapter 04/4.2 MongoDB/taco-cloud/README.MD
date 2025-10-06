<h3>4.2 MongoDB</h3>
<ul>
	<li>
		Добавим зависимость <b>spring-boot-starter-mongodb</b>
	</li>
	<li>
		Для тестирования и разработки в книге используется <b>flapdoodle</b>. Но так как он устаревший, я буду использовать <b>Testcontainers</b><br />
		Добавим зависимости <b>spring-boot-testcontainers:org.springframefork.boot</b> и <b>mongodb:org.testcontainers</b>
	</li>
	<li>
		Так как объекты <b>Taco</b> всегда будут сохраняться только как составляющие агрегата <b>TacoOrder</b>, класс <b>Taco</b> не нужно снабжать аннотациями <b>@Document</b> и <b>@Id</b>
	</li>
</ul>