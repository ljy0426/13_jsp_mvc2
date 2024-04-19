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
import step01_board.dto.BoardDTO;


@WebServlet("/bUpdate")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //업데이트 화면 필요로 함(줘)받고
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//boardId 받기
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		//전에 썼던 게시글 가져오기
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardDetail(boardId);
		request.setAttribute("boardDTO", boardDTO);
		
		//한방
		//request.setAttribute("boardDTO", BoardDAO.getInstance().getBoardDetail(Long.parseLong(request.getParameter("boardId"))));
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bUpdate.jsp");
		dis.forward(request, response);
	}
	//업데이트 로직 처리/주고
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한국어 처리
		request.setCharacterEncoding("utf-8");
				
		// 전송받은 데이터를 DTO형식으로 생성
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardId(Long.parseLong(request.getParameter("boardId")));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));
		
		// DAO클래스의 updateBoard메서드에 DTO 전송
		BoardDAO.getInstance().updateBoard(boardDTO); //updateBoard boardDAO에 만들러감
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String jsScript = """
				<script>
					alert('게시글이 수정되었습니다.');
					location.href = 'bList';
				</script>
				"""; 
		
		out.print(jsScript);
		
	}

}
