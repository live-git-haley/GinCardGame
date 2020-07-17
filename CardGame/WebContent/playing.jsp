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
	boolean p1 = (boolean)session.getAttribute("player1Bool");
	boolean p2 = (boolean)session.getAttribute("player2Bool");
	
	

	System.out.println();
	System.out.println("playing.jsp");
	
	
	boolean winner = false;

	Pathnames pathnames = new Pathnames();
	String[] list = pathnames.getfileList();

	Card h = new Card();
	Stack<Card> deck = (Stack<Card>)session.getAttribute("deck");

	List<Card> player1 = (List<Card>)session.getAttribute("player1cards");
	List<Card> player2 = (List<Card>)session.getAttribute("player2cards");
	
	
	Stack<Card> trash  = (Stack<Card> )session.getAttribute("trash" );
	
	
	
	Card top = trash.pop();	
	
	System.out.println("****  PLAYING SERVLET  ****");
	System.out.println("Player 1: boolean --> " + p1);
	System.out.println("Player 2: boolean --> " + p2);
	System.out.println();
	System.out.print("draw card" + top.toString());


	String topc = top.getFilename(top);
	session.setAttribute("trash", trash);
	session.setAttribute("cardDraw", top);

	
	
	Collections.sort(player1, new CardComparator());
	Collections.sort(player2, new CardComparator());

	if(p1){
	
	%>

	<h2>Player 1's Cards</h2>

	<div class="main">

		
	<% 
		int count = 0;
		for (Card c : player1) {
			String file = c.getFilename(c);
			

		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		
		</div>
		<%
		count++;
			};
		
		
		%>
		
		</form>
		
		
	</div>
<%} if(p2){ %>
	<br>
		<h2>Player 2's Cards</h2>
		<div class="main">
	
	<% 
		int count = 0;
		for (Card c : player2) {
			String file = c.getFilename(c);
			String card = Integer.toString(c.getSuite()) +" SPACE " + Integer.toString(c.getNum());
			
		
		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		</div>
		
		<%
		count++;
			}
		
		
		%>
		
		</form>
		
	
	</div>
	<br>
	<%
	
		
}

	%>
	<h2> This is the top of the pile</h2>
	<div class="top">
		<img alt="Image not found" src=<%out.print(topc);%> height="150px"
			width="110px">

	</div>


	<%
		//session.setAttribute("choice", "");
	if (session.getAttribute("choice") == null)
		session.setAttribute("choice", "");
	
	//System.out.print(session.getAttribute("choice"));
	%>

	<form action="/CardGame/ChoiceServlet">
		<input type="hidden" name="choice" value="keep" />

		<button type="submit" class="btn btn-success">Keep</button>

		<%
			if (session.getAttribute("choice").equals("keep")) {
				System.out.println("Keep was picked");
				

			}
				
		%>
	</form>
	<form action="/CardGame/ChoiceServlet">
		<input type="hidden" name="choice" value="draw" />
		<button type="submit" class="btn btn-Primary">Draw</button>
		<%
			if (session.getAttribute("choice").equals("draw")) {
			
		%>

		<%
			}
		
		%>
	</form>
	
	
	


</body>
</html>