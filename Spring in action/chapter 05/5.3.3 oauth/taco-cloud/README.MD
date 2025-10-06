<h2>5.1</h2>
<ul>
	<li>
		Подключаем зависимость <b>spring-boot-starter-security</b>
	</li>
	<li>
		<h3>Список методов шифрования:</h3>
		<ul>
			<li>
				<b>BCryptPasswordEncoder</b> - надёжное шифрование <b>bcrypt</b>;
			</li>
			<li>
				<b>NoOpPasswordEncoder</b> - не применяет шифрование; подходит для тестирования;
			</li>
			<li>
				<b>Pbkdf2PasswordEncoder</b> - шифрование <b>PBKDF2</b>;
			</li>
			<li>
				<b>SCryptPasswordEncoder</b> - шифрование <b>scrypt</b>;
			</li>
			<li>
				<b>StandardPasswordEncoder</b> - шифрование <b>SHA-256</b>; небезопасный и устаревший;
			</li>
		</ul>
	</li>
	<li>
		Настроим хранилище учётных записей <b>UserDetailsService</b>. Этот встроенный функциональный интерфейс имеет всего один метод <b>loadUserByUsername</b>. Так как это функциональный интерфейс, то его можно реализовать как лямбда-функцию.
		<h3>Некоторые уже готовые реализации <b>UserDetailsService</b>:<h3>
		<ul>
			<li>
				inMemory;
			</li>
			<li>
				JDBC;
			</li>
			<li>
				LDAP;
			</li>
			<li>
				Можно реализовать и свою.
			</li>
		</ul>
	</li>
	<li>
		Сначала применим <b>InMemoryUserDetailsManager</b> с использованием класса <b>User</b> из <b>springsecurity</b>;
	</li>
	<li>
		Далее вместо класса <b>User</b> из <b>springsecurity</b> создадим свой более сложный класс <b>User</b> и интерфейс репозитория для него;
	</li>
	<li>
		Добавили возможность регистрации
	</li>
	<li>
		Добавили <b>SecurityFilterChain</b>
	</li>
</ul>