package CardGameJinApp.Practice;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReplaceServlet")
public class ReplaceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String button = req.getParameter("buttonclick");
		
		System.out.println("This is the value of the button" + button);

		int pos = Integer.parseInt(button);
		
		System.out.println("This is in the replace servlet " + pos);
		// resp.getWriter().println("<b>" + choice + "</b>");
		HttpSession httpSession = req.getSession();
		Card newC = (Card) httpSession.getAttribute("cardDraw");
		httpSession.setAttribute("newcard", newC);
		httpSession.setAttribute("oldcard", pos);
//		System.out.println(httpSession.getAttribute("cardchoose"));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("newHand.jsp");
		requestDispatcher.forward(req, resp);
	}

	
}
