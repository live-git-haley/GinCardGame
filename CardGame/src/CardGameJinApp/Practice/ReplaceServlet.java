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
		String choice = req.getParameter("pickcard");
		int pos = Integer.parseInt(choice);
		
		System.out.println("This is in the replace servlet " + choice);
		// resp.getWriter().println("<b>" + choice + "</b>");
		HttpSession httpSession = req.getSession();
		Card newC = (Card) httpSession.getAttribute("drewCard");
		httpSession.setAttribute("newcard", newC);
		httpSession.setAttribute("oldcard", pos);
//		System.out.println(httpSession.getAttribute("cardchoose"));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("newHand.jsp");
		requestDispatcher.forward(req, resp);
	}

	
}
