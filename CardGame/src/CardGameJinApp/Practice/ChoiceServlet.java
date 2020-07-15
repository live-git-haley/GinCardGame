package CardGameJinApp.Practice;

import java.io.IOException;
import java.util.Enumeration;

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
		
		httpSession.setAttribute("choice", choice);
		
//		Enumeration<String> names = httpSession.getAttributeNames();
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            Object value = httpSession.getAttribute(name);
//            System.out.print(value.toString());
//        }
//		
//		
		
		
		System.out.println("This is the CHOICE SERVLET>>>>>> ");
		System.out.println( "This is the button picked "+ httpSession.getAttribute("choice"));
		System.out.println( "This is player1 Bool "+ httpSession.getAttribute("player1Bool"));
		System.out.println( "This is player2 Bool "+ httpSession.getAttribute("player2Bool"));
		System.out.println( "This is the card Drawn "+ httpSession.getAttribute("cardDraw"));
		System.out.println( "This is player1's cards "+ httpSession.getAttribute("player1cards"));
		
		if(choice.equals("keep")) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("replace.jsp");
		requestDispatcher.forward(req, resp);
		} 
		
		if(choice.equals("draw")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("PlayGame.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
