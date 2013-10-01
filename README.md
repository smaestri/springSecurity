springSecurity
==============

Le but est d'effectuer une redirection sur la page ou etait l'utilisateur dans le cas d'une expiration de session avec Spring Security.

Appli minimaliste contenant un SPRING MVC.

Ainsi pour tester :

- Appel page d'accueil : http://localhost:8080/SpringMVC/welcome

- User non authentifié : redirection vers formulaire de login : login.jsp

- Authentification user login : mkyong password : 123456

- Arrivée sur page d'accueil : hello.jsp

- Cliquer sur TESTSMA pour aller sur page login2.jsp

- Attendre l'expiration de session (paramétrable dans le web.xml, par défaut 8 secondes) puis cliquer sur le lien pour atteindre une autre page (login3.jsp)

- Redirection page de login suite expiration de session

- Authentification avec succès : redirection directement vers la page désirée : login3.jsp

Or actuellement on est redirigé vers la page d'accueil hello.jsp.


Solution :

<beans:beans xmlns="http://www.springframework.org/schema/security"
	xmlns:beans="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/security
	http://www.springframework.org/schema/security/spring-security-3.0.3.xsd">

	<http>
		 <intercept-url pattern="/login" filters="none"   />
		 <intercept-url pattern="/**" access="ROLE_USER" />
		<form-login
		 	login-page="/login"
		 	authentication-success-handler-ref="handlerTest"
		 	authentication-failure-url="/loginfailed" />
		 	<!-- always-use-default-target="false" -->
			<!-- <session-management session-authentication-strategy-ref="sas" invalid-session-url="/login?erreur=sessionExpire" /> -->
	</http>
	
	<beans:bean id="handlerTest" class="org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler">
		<beans:property name="defaultTargetUrl" value ="/welcome"></beans:property>
	</beans:bean>
		
	<authentication-manager>
		<authentication-provider>
			<user-service>
				<user name="mkyong" password="123456" authorities="ROLE_USER" />
			</user-service>
		</authentication-provider>
	</authentication-manager>

</beans:beans>
