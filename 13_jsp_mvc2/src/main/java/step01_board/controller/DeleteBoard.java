package step01_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO;


@WebServlet("/bDelete")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //삭제화면 달라
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//bDelete.jsp로 패스(포워딩)
		request.setAttribute("boardId", request.getParameter("boardId"));
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bDelete.jsp");
		dis.forward(request, response);
	}

	//게시글 삭제 처리 로직
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글 코딩 필요없음 (id만 넘어왔기 때문)
		
		//boardId 받기
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		//DAO클래스의 deleteBoard메서드에 boardId 전달
		BoardDAO.getInstance().deleteBoard(boardId); //boardDAO가서 deleteBoard생성
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String jsScript = """
				<script>
					alert('게시글이 삭제되었습니다.');
					location.href = 'bList';
				</script>
				"""; 
		
		out.print(jsScript);
		
	}

}
