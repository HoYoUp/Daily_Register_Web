package usersManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	doPost(request,response);
    }
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name"),pwd=request.getParameter("pwd");
    	if(name==""||name==null||pwd==""||pwd==null)
    		response.sendRedirect("index.html"); 
    	else {
    		user u = utils.getUser(name,pwd);
    		if(u!=null) {
    			request.getSession().setAttribute("info", u);
    			try {
    				response.setCharacterEncoding("utf-8"); 
    				if(u.getId()!=1)
    				  request.getRequestDispatcher("/user.jsp").forward(request, response);
    				else 
    				  request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);    					
    			} catch (ServletException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		else
    			response.sendRedirect("index.html");    		
    	}
    	
    }
	
}

