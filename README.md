springSecurity
==============

Le but est d'effectuer une redirection sur la page ou etait l'utilisateur dans le cas d'une expiration de session avec Spring Security.

Appli minimaliste contenant un SPRING MVC.

Ainsi pour tester :

- Appel page d'accueil : http://localhost:8080/SpringMVC/welcome

- User non authentifié : redirection vers formulaire de login : login.jsp

- Authentification user login : mkyong password : 123456

- Arrivée sur page d'accueil : hello.jsp

- Cliquer sur TESTSMA pour aller sur troisieme page login2.jsp

- Attendre l'expiration de session (paramétrable dans le web.xml, par défaut 10 secondes) puis cliquer sur le lien pour atteindre une troisième page (login3.jsp)

-  Redirection page de login

- Authentification avec succèes : redirection directement vers la page désirée : login3.jsp

Or actuellement on est redirigé vers la page d'accueil hello.jsp.