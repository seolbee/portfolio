package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.UserVO;
import diary.DiaryDAO;

@WebServlet("/login.do")

public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		login(req, resp);
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		DiaryDAO instance = DiaryDAO.getInstance();
		
		Connection conn = instance.getConnection();
		String sql = "SELECT * FROM DIARY_USER WHERE id = ? AND pass = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setNString(2, pass);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) instance.writeHtml(out, "아이디나 비밀번호가 맞지 않습니다. 다시 확인 해보세요.", "login.jsp");
			
			UserVO vo = new UserVO(rs.getInt("idx"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getDate("birth"));
			req.setAttribute("user", vo);
			
			instance.writeHtml(out, "로그인 성공! 메인 페이지로 이동합니다.", "main.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance.close(rs, pstmt, conn);
		}
	}
}
