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

	<h2>Player 1's Cards</h2>


	<div class="main">

		<%
		session.setAttribute("choice", "SETTING CHOICE TO NOTHING");
		session.setAttribute("replacedcard1", "SETTING card to nothing");


		System.out.println();
		System.out.println("TOP OF FILE");
		boolean winner = false;

		Pathnames pathnames = new Pathnames();
		String[] list = pathnames.getfileList();

		Card h = new Card();
		Stack<Card> deck = h.createDeck();
		Stack<Card> trash = new Stack<>();
		boolean p1 = true;
		boolean p2 = false;

		//
		List<Card> player1 = new ArrayList<Card>();
		List<Card> player2 = new ArrayList<Card>();

		//
		//// Shuffling my cards
		Collections.shuffle(deck);
		//PLAYER 1 CARDS
		for (int i = 0; i <= 9; i++) {
			player1.add(deck.get(i));
			deck.remove(i);

		}
		//PLAYER 2 CARDS
		for (int i = 0; i <= 9; i++) {
			player2.add(deck.get(i));
			deck.remove(i);

		}

		Collections.sort(player1, new CardComparator());
		Collections.sort(player2, new CardComparator());

		//
		for (Card c : player1) {
			String file = c.getFilename(c);
			String card = Integer.toString(c.getSuite()) +" SPACE " + Integer.toString(c.getNum());
			

		%>
		<form action="/CardGame/ReplaceServlet">
		
		<div class = "cards">
		
		<img alt="Image not found" src=<%out.print(file);%> height="150px"
			width="110px">
		
		</div>
		
		
		
		<%
		};
		%>
		</form>
		
	</div>


	<br>
	

	<%
	
	p1 = true;
	p2 = false;

	Card cardDraw = deck.pop();
	String firstN = cardDraw.getFilename(cardDraw);
	session.setAttribute("player1cards", player1);
	session.setAttribute("player2cards", player2);
	session.setAttribute("player1Bool", p1);
	session.setAttribute("player2Bool", p2);
	session.setAttribute("deck", deck);
	session.setAttribute("trash" , trash);
	session.setAttribute("cardDraw", cardDraw);
	%>
	<div class="top">
		<img alt="Image not found" src=<%out.print(firstN);%> height="150px"
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