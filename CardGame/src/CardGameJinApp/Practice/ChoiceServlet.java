package CardGameJinApp.Practice;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String choice = req.getParameter("choice");
		// resp.getWriter().println("<b>" + choice + "</b>");
		HttpSession httpSession = req.getSession();
		boolean p11 = (boolean)httpSession.getAttribute("player1Bool");
		boolean p22 = (boolean)httpSession.getAttribute("player2Bool");

		
		httpSession.setAttribute("choice", choice);
		System.out.println("Player 1 boolean: " + p11);
		System.out.println("Player 2 Boolean : " + p22);

		
		if(choice.equals("keep")) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("replace.jsp");
		requestDispatcher.forward(req, resp);
		} 
		
		if(choice.equals("draw")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("draw.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		if(choice.equals("throw")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("playing.jsp");
			boolean p1 = (boolean)httpSession.getAttribute("player1Bool");
			boolean p2 = (boolean)httpSession.getAttribute("player2Bool");
			Stack<Card> trash  = (Stack<Card> )httpSession.getAttribute("trash" );
			Card cardDraw = (Card) httpSession.getAttribute("cardDraw");
			
			trash.add(cardDraw);
			
			httpSession.setAttribute("trash", trash);

			boolean false1 = false;
			boolean true1 = true;
			if(p1){
				httpSession.setAttribute("player1Bool", false1);
				httpSession.setAttribute("player2Bool", true1);

			}
			else{
				httpSession.setAttribute("player2Bool", false1);
				httpSession.setAttribute("player1Bool", true1);
				
			}
			
				
			requestDispatcher.forward(req, resp);
			} 
			
	}
}
