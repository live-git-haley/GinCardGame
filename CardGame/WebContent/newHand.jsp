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

<link rel="stylesheet"  type="text/css" href="styles.css"/>

<meta charset="UTF-8">
<title>Welcome to Gin</title>
</head>
<body>
	<h1>Welcome to Gin</h1>
	<%
	CaseChecker check = new CaseChecker();
	

	boolean false1 = false;
	boolean true1 = true;
	
	boolean p1 = (boolean)session.getAttribute("player1Bool");
	boolean p2 = (boolean)session.getAttribute("player2Bool");
	
	Card draw = (Card) session.getAttribute("drewCard");

	Card c = new Card();

	Pathnames pathnames = new Pathnames();
	String[] list = pathnames.getfileList();

	Card h = new Card();

	List<Card> player1 = (List<Card>)session.getAttribute("player1cards");
	List<Card> player2 = (List<Card>)session.getAttribute("player2cards");
	
	
	int replace = (Integer)session.getAttribute("oldcard");
	Card newCard  = (Card)session.getAttribute("newcard");
	
	Stack<Card> trash  = (Stack<Card> )session.getAttribute("trash" );
	System.out.println("NEW HAND JSP");


	
	if(p1){
	 %>

	<h2>Player 1's Cards</h2>


	<div class="main">

		<%

		trash.add(player1.get(replace));
		session.setAttribute("trash", trash);
		
		List<Card> player1new = h.replace(player1, newCard, replace);
		session.setAttribute("player1cards", player1new);
		Collections.sort(player1new, new CardComparator());
		boolean win1 = check.checkWinner(player1new);
	
		System.out.println("Win1 Boolean: " + win1);

		
		if(win1){
			%> <h3> PLAYER 1 WINSSSSS YAYYYY!!!! </h3>
			<%System.out.print("PLAYER 1 WINSSSSS YAYYYY!!!! ");} 
	
		
		session.setAttribute("player1Bool", false1);
		session.setAttribute("player2Bool", true1);
		
	


		//
		int count = 0;
		for (Card j : player1new) {
			String file = j.getFilename(j);			

		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		</div>
		
		<%
		count++;
			}
		;
		
		%>
		
		</form>
		
	</div>
	
	
	<br>
	
	<h1> This is Player1's new hand.</h1>
	
	<%}
	
	if(p2){
	
	%>

	
	<h2>Player 2's Cards</h2>


	<div class="main">

		<%

		trash.add(player2.get(replace));
		session.setAttribute("trash", trash);
		
		List<Card> player2new = h.replace(player2, newCard, replace);
		session.setAttribute("player2cards", player2new);
		Collections.sort(player2new, new CardComparator());
		
		boolean win2 = check.checkWinner(player2new);
		System.out.println("Win2 Boolean: " + win2);
		
		if(win2){
			%> <h3> PLAYER 2 WINSSSS YAYYYY!!!</h3>
			<% System.out.print("PLAYER 2 WINSSSSS YAYYYY!!!! ");} 



		
		session.setAttribute("player2Bool", false1);
		session.setAttribute("player1Bool", true1);


		//
		int count = 0;
		for (Card j : player2new) {
			String file = j.getFilename(j);			

		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		</div>
		
		<%
		count++;
			}
		;
		
		%>
		
		</form>
		
	</div>
	
	
	<br>
	
	<h1> This is Player2's new hand.</h1>
	<%} %>


	<form action="/CardGame/playing.jsp">

		<button type="submit" class="btn btn-success">Next Turn</button>


	</form>
	
	
	


</body>
</html>