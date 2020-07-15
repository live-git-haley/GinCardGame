<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <style>
      div {
        width: 100px;
        height: 100px;
        /* background-color: red; */
        position: relative;
        animation-name: example;
        animation-duration: 45s;
      }
      @keyframes example {
        0% {
          /* background-color: red; */
          left: 0px;
          top: 0px;
        }
        25% {
          /* background-color: yellow; */
          left: 200px;
          top: 0px;
        }
        50% {
          /* background-color: blue; */
          left: 200px;
          top: 200px;
        }
        75% {
          /* background-color: green; */
          left: 0px;
          top: 200px;
        }
        100% {
          /* background-color: red; */
          left: 0px;
          top: 0px;
        }
      }
    </style>
	<!-- inline javascript -->
	<%for(int i =0; i< 5; i++) { %>
	<div style="width: 200px; height: 200px;">
		<img src="off.gif" id="light-bulb<%=i%>"
			onmouseover="document.getElementById('light-bulb<%=i%>').src='on.gif'"
			onclick="document.getElementById('light-bulb<%=i%>').src=''">
	</div>
	<%} %>

	<%--     <%for(int i =0; i< 133; i++) { %>
   <img src="off.gif" id="light-bulb<%=i%>"
   onmouseover="document.getElementById('light-bulb<%=i%>').src='on.gif'"
   onmouseout="document.getElementById('light-bulb<%=i%>').src='off.gif'"
   >
   <%} %> --%>
</body>
</html>