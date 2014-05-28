<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title> </title>
</head>
<body>
<h1>qualcosa e' andato storto..</h1>
<f:view>
<h:form>
    <div>e-mail: <h:inputText value="#{responsabileController.email}" 
                     required="true"
                     requiredMessage="email is mandatory"
                     id="email"/> <h:message for="email" />
	</div>
	
   <div>reinserisci la password: 
   <h:inputSecret value="#{responsabileController.password}" 
                     required="true"
                     requiredMessage="password is mandatory"
    				 validatorMessage="password: min 6 max 10 characters"                     
    				 id="password"> 
    				  <f:validateLength minimum="6" maximum="10"/>
 					 </h:inputSecret>
    				 <h:message for="password" />
                     </div>
	<div>
		<h:commandButton value="login"  action="#{responsabileController.login}"/>

	</div>
</h:form>
</f:view>
</body>
</html>