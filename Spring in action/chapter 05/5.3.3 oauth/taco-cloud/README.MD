<h2>5.3.3</h2>
<ul>
	<li>
		Подключаем зависимость <b>spring-boot-starter-oauth2-client</b>
	</li>
	<li>
		Для возможности лониниться через <b>OAuth2</b> необходимо с сервиса (например с яндекса) получить:
		<ul>
			<li>
				ClientID;
			</li>
			<li>
				Client secret/
			</li>
		</ul>
	</li>
	<li>
		Так как yandex нестандартный для spring-boot, то придётся дописать дополнительные параметры кроме Client ID и Client Secret <br />				
	</li>
	<li>
		Для того, чтобы CSRF-защита пропускала на страницы, в формах обязательно должны быть th:action и th:object
	</li>
	<li>
		Выполнение метода под конкретной ролью можно настроить несколькими способами:<br />
		<ul>
			<li>
				В конфиге SecurityConfig
			</li>
			<li>
				Повесить на метод контроллера аннотацию <b>@PreAuthorize</b><br />
				Для этого на <b>SecurityConfig</b> придётся повесить аннотацию <b>@EnableGlobalMethodSecurity</b> и унаследовать этот класс от <b>WebSecurityConfigurerAdapter</b>
			</li>
		</ul>
	</li>
</ul>