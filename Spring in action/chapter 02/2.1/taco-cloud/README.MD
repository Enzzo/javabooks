# Заметки к этой главе:
<hr>
1. <strong>@SessionAttributes("tacoOrder"):</strong><br>
	В контроллере создаётся метод с аннотацией <strong>@ModelAttribute(name = "tacoOrder")</strong>. При первом запросе к контроллеру этот объект будет храниться в модели на протяжении всей сессии. <br>
	Так же можно добавлять объекты через метод <strong>@ModelAttribute</strong> без аннотации, а явно добавлять через <strong>model.addAttribute("tacoOrder", new TacoOrder())</strong>.<br />
	Метод <strong>SetComplete</strong> класса <strong>SessionStatus</strong> очищает сеанс от этого объекта.
	<hr>
2. Добавили элемент <strong>конвертер</strong> для имитации базы данных. Spring автоматом подхватывает объект (в нашем случае String) и конвертирует в <strong>Ingredient</strong>. Пригодится, пока нет базы данных. <strong>Converter</strong> - теперь будет бином, так как имеет аннотацию <strong>@Component</strong>.