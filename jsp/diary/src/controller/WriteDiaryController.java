package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.DiaryDAO;

@WebServlet("/WriteDiary.do")
public class WriteDiaryController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeDiary(req, resp);
	}
	
	public void writeDiary(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DiaryDAO instance = DiaryDAO.getInstance();
		int diaryNo = Integer.parseInt(req.getParameter("diaryNo"));
		String content = req.getParameter("content");
		String sql = "";
		Connection conn = instance.getConnection();
		PreparedStatement pstmt = null;
		try {
			if(diaryNo > 0) {
				sql = "UPDATE DIARY_BOARD SET content = ? WHERE diaryNo = ?";
				pstmt.setString(1, content);
				pstmt.setInt(2,  diaryNo);
			} else {
				sql = "INSERT INTO DIARY_BOARD VALUES(diaryNo, content)";
				pstmt.setInt(1, diaryNo);
				pstmt.setString(2, content);
			}
			
			int cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance.close(null, pstmt, conn);
		}
	}
}
