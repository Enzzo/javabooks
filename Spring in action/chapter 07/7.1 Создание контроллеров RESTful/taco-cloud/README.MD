<h2>7.1 Создание REST-контроллеров</h2>
<ul>
	<li>
		Создали REST-контроллер <b>TacoController</b> и repository <b>TacoRepository</b>
	</li>
	<li>
		<b>@RequestMapping(path="/api/tacos", produces="application/json")</b> говорит о том, что эти методы будут обрабатываться только в том случае, если запрос содержит заголовок <b>Accept</b> со значением <b>"application/json"</b>
	</li>
	<li>
		Так же можно добавить несколько значений: <b>@RequestMapping(path="/api/tacos", produces={"application/json", "text/html"})</b>
	</li>
	<li>
		Аннотация <b>@Crossorigin</b> позволяеть получать доступ из других клиентов (React, etc). Иначе браузер будет блокировать эти запросы.
	</li>
	<li>
		Загрузим данные в базу через <b>CommandLineRunner</b>
	</li>
	<li>
		Команды:
		<ul>
			<li>
				<b>curl localhost:8080/api/tacos?recent</b> - получить список всех taco
			</li>
		</ul>
	</li>
	<li>
		Аннотация <b>@PostMapping(consumes="application/json")</b> говорит о том, что данный метод будет обрабатывать только запросы с типом <b>json</b>
	</li>
	<li>
		Аннотация <b>@ResponseStatus(HttpStatus.CREATED)</b> всегда будет сообщать ответ с кодом 201 (created)
	</li>
	<li>
		Если мы отправляем объект методом <b>PUT</b>, то объект заменяется ПОЛНОСТЬЮ. То есть если какое-то поле не передали, то в базу прилетят пустые значения
	</li>
	
</ul>