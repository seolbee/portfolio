package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.DiaryDAO;

@WebServlet("/registe.do")

public class RegisterController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		register(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		register(req, resp);
	}
	
	public void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		
		DiaryDAO instance = DiaryDAO.getInstance();
		String sql = "SELECT * FROM DIARY_USER WHERE id = ?";
		Connection conn = instance.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) instance.writeHtml(out, "이미 있는 아이디 입니다.", "register.jsp");
			
			Date birth = Date.valueOf(req.getParameter("birth"));
			sql = "INSERT INTO DIARY_USER VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, instance.getMaxNo("DIARY_USER")+1);
			pstmt.setString(2, id);
			pstmt.setString(3, pass);
			pstmt.setString(4, name);
			pstmt.setDate(5, birth);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) instance.writeHtml(out, "회원가입 성공", "login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance.close(rs, pstmt, conn);
		}
	}
}
