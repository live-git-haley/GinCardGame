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
	
	display:table-cell; vertical-align:middle; text-align:center
}

div.top {
	padding-top: 50px;
 	 padding-right: 30px;
 	 padding-bottom: 50px;
  	padding-left: 30px;
	
	background-color: dark-green;
	
	display:table-cell; vertical-align:middle; text-align:center
}
h2{
	text-align: center;

}
</style>
<meta charset="UTF-8">
<title>Welcome to Jin</title>
</head>
<body>
	<h1> Welcome to Jin</h1>
	
	<h2>
	Player 1's Cards
	</h2>
	
  
<div class = "main">	
	
	<%
	boolean winner = false;
	
	Pathnames pathnames = new Pathnames();
	String[] list = pathnames.getfileList();


	Card h = new Card();
	Stack<Card> deck = h.createDeck();
	Stack<Card> trash = new Stack<>();
	boolean p1;
	boolean p2;
	//System.out.println(cards.toString());
	//System.out.println(cards);
	//Queue<Player> usedCards = new LinkedList<>();
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
	System.out.println();
	System.out.println("Player 1's Cards");
	
 	System.out.println(player1.toString());
	System.out.println();

 	
	
	for(Card c: player1){
	String file = c.getFilename(c);
	System.out.println(file);
	
	%>


	<img alt = "Image not found" src=<%out.print(file);%> height="150px" width="110px">


	<%}; %>
	</div>
	<br> 
	
	
	<%
	
	
	
	p1= true;

	Card first = deck.pop();
	String firstN = first.getFilename(first);
	System.out.println();
	System.out.println("This is the first card: " +  first.toString());
	%>
	<div class = "top">
			<img alt = "Image not found" src=<%out.print(firstN);%> height="150px" width="110px">
	
	</div>
<button type="button" class="btn btn-success">Keep</button>
<button type="button" class="btn btn-Primary">Draw</button>


	


	
	
	


</body>
</html>