package step01_board_dto;

import java.util.Date;

/*

# DTO(Data Transfer Object)

- 데이터 전송을 위한 객체

- DTO는 데이터를 효과적으로 전송하고 관리하기 위해 사용되며 
  주로 소프트웨어 시스템의 다른 부분 간에 데이터를 전달하거나 데이터베이스와 어플리케이션 간의 상호 작용에 사용

*/

public class BoardDTO {
	
	private long boardId;
	private String writer;
	private String subject;
	private String email;
	private String password;
	private String content;
	private long read_Cnt;
	private Date enrollDT; 	//java.util.Date;
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getRead_Cnt() {
		return read_Cnt;
	}
	public void setRead_Cnt(long read_Cnt) {
		this.read_Cnt = read_Cnt;
	}
	public Date getEnrollDT() {
		return enrollDT;
	}
	public void setEnrollDT(Date enrollDT) {
		this.enrollDT = enrollDT;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardId=" + boardId + ", writer=" + writer + ", subject=" + subject + ", email=" + email
				+ ", password=" + password + ", content=" + content + ", read_Cnt=" + read_Cnt + ", enrollDT="
				+ enrollDT + "]";
	}
	
	
	
}
