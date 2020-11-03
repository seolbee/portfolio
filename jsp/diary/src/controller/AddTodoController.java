package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("AddoTodo.do")

public class AddTodoController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddTodo(req, resp);
	}
	
	public void AddTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int todoNo = Integer.parseInt(req.getParameter("todoNo"));
		String sql = "";
		try {
			if(todoNo > 0) {
				sql = "UPDATE DIARY_TODO SET content = ? ";
			} else {
				
			}
		} catch (Exception e) {
			
		}
	}
}
