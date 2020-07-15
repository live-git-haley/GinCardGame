<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="CardGameJinApp.Practice.Card"%>
<%@ page import="CardGameJinApp.Practice.CardComparator"%>
<%@ page import="CardGameJinApp.Practice.Pathnames"%>
<%@ page import="CardGameJinApp.Practice.CaseChecker"%>



<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<style>
body {
	background-color: green;
	color: white;
}

title {
	color: white;
}

.radio-input{
	float: bottom;
}

#over img {
	margin-left: auto;
	margin-right: auto;
	display: block;
}

div.main {
	padding-top: 25px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 30px;
	background-color: red;
	display: table-cell;
	vertical-align: middle;
	text-align: center
}

div.top {
	padding-top: 50px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 30px;
	background-color: dark-green;
	display: table-cell;
	vertical-align: middle;
	text-align: center
}

h2 {
	text-align: center;
}

.cards{
background-color: purple;

  float: left;
}
</style>
<meta charset="UTF-8">
<title>Welcome to Gin</title>
</head>
<body>
	<h1>Welcome to Gin</h1>

	<h2>Player 1's Cards</h2>


	<div class="main">

		<%

		System.out.println();
		System.out.println("Replace.jsp");
		boolean winner = false;

		Pathnames pathnames = new Pathnames();
		String[] list = pathnames.getfileList();

		Card h = new Card();
		Stack<Card> deck = (Stack<Card>)session.getAttribute("deck");

		List<Card> player1 = (List<Card>)session.getAttribute("player1cards");
		List<Card> player2 = (List<Card>)session.getAttribute("player2cards");
		
		boolean p1 = (boolean)session.getAttribute("player1Bool");
		boolean p2 = (boolean)session.getAttribute("player2Bool");
		
		Stack<Card> trash  = (Stack<Card> )session.getAttribute("trash" );
		
		Card draw = (Card) session.getAttribute("cardDraw");
		session.setAttribute("drewCard", draw);

		
		
		Collections.sort(player1, new CardComparator());
		Collections.sort(player2, new CardComparator());
		if(p1){
		//
		int count = 0;
		for (Card c : player1) {
			String file = c.getFilename(c);
			String card = Integer.toString(c.getSuite()) +" SPACE " + Integer.toString(c.getNum());
			

		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		<input type="hidden" name="pickcard" value="<%out.print(count);%>" />
		<button type="submit" class="btn btn-success"><%out.print(card);%></button>
		</div>
		
		<%
		count++;
			}
		;
		}
		%>
		
		</form>
		
	</div>


	<br>
	
	<h1> Please choose a card to replace with the card you drew below</h1>
	<%
	
	String firstN = draw.getFilename(draw);
	%>
	<div class="top">
		<img alt="Image not found" src=<%out.print(firstN);%> height="150px"
			width="110px">

	</div>



	


</body>
</html>