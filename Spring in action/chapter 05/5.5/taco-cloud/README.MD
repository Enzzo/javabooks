<h2>5.5 Получение информации о залогиненном пользователе (о себе).</h2>
<ul>
	<li>
		Добавим в <b>TacoOrder</b> поле <b>@ManyToOne private User user</b>
	</li>
	<li>
		Для получения информации есть несколько способов:
		<ul>
			<li>
				I. В <b>OrderController</b> в метод <b>proccessOrder</b> добавим аргумент <b>Principal principal</b>;
			</li>
			<li>
				II. В <b>OrderController</b> в метод <b>proccessOrder</b> добавим аргумент <b>Authentication authentication</b>;
			</li>
			<li>
				III. В <b>OrderController</b> в метод <b>proccessOrder</b> добавим аргумент <b>@AuthenticationPrincipal User user</b>. (предпочтительно)
			</li>
		</ul>
	</li>
</ul>