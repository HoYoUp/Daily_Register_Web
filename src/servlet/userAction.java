package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usersManager.user;
import usersManager.utils;

@WebServlet("/userAction")
public class userAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		char s = request.getParameter("type").charAt(0);
		switch (s) {
		case '0':
			user u = (user)request.getSession().getAttribute("info");
            if(utils.roll(u.getMonth(), u.getId())) {
            	System.out.print("rolled");
            	try {
            		request.getSession().removeAttribute("info");
            		request.getSession().setAttribute("info", u);
            		response.getWriter().print("sucsess");
            	} catch (IOException e) {
            		// TODO Auto-generated catch block
            		e.printStackTrace();
            	}            	
            } else
				try {
					response.getWriter().print("It is not now or error.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case '1':

			break;
		case '2':

			break;
		case '3':

			break;
		case '4':

			break;
		case '5':

			break;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

	}
}
