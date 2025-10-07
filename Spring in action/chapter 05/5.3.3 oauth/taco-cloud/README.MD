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
		spring.security.oauth2.client.registration.yandex.client-id=${OAUTH2_YANDEX_CLIENTID}<br />
		spring.security.oauth2.client.registration.yandex.client-secret=${OAUTH2_YANDEX_CLIENTSECRET}<br />
		spring.security.oauth2.client.registration.yandex.scope=email<br />
		spring.security.oauth2.client.registration.yandex.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}<br />
		spring.security.oauth2.client.registration.yandex.authorization-grant-type=authorization_code<br />
		spring.security.oauth2.client.registration.yandex.client-name=Yandex<br />
		spring.security.oauth2.client.registration.yandex.provider=yandex<br />		
		spring.security.oauth2.client.provider.yandex.authorization-uri=https://oauth.yandex.ru/authorize<br />
		spring.security.oauth2.client.provider.yandex.token-uri=https://oauth.yandex.ru/token<br />
		spring.security.oauth2.client.provider.yandex.user-info-uri=https://login.yandex.ru/info<br />
		spring.security.oauth2.client.provider.yandex.user-name-attribute=id<br />
	</li>
</ul>