<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
 <h:form id="login-form">
           <h:outputText value="pin:"/>
           <h:inputText value="#{AmministratoreController.pin}" id="pin"/>
           <br/>
           <h:outputText value="password:"/>
           <h:inputSecret value="#{AmministratoreController.password}" id="password"/>
           <br/>
           <h:commandButton id="button" value="Login" action="#{AmministratoreController.doLogin}"/>
           <br/>
           <h:messages />
           <br/>
        </h:form>

</f:view>
</body>
</html>