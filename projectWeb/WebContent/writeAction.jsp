<%@page import="member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.dao.BoardDao" %>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
 
<jsp:useBean id="bbs" class="board.model.vo.BoardVo" scope="page"></jsp:useBean>
<jsp:setProperty name="bbs" property="bbsTitle"/>
<jsp:setProperty name="bbs" property="bbsContent"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; c harset=UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
    <%
    	String userID = null;
    	if (session.getAttribute("lgnss") != null){
    		MemberVo member = (MemberVo)session.getAttribute("lgnss");
            userID = member.getUserID();
    	}
    	if (userID == null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('로그인하세요.')");
            script.println("location.href = 'login.jsp'"); 
            script.println("</script>");
    	}else{
    		if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null){
        		PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('모든 문항을 입력해주세요.')");
                script.println("history.back()");   
                script.println("</script>");
        	}else{
        		BoardDao boardDAO = new BoardDao();
                int result = boardDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
                if (result == -1){ // 글쓰기 실패시
                    PrintWriter script = response.getWriter();
                    script.println("<script>");
                    script.println("alert('글쓰기에 실패했습니다.')");
                    script.println("history.back()");    
                    script.println("</script>");
                }else{ // 글쓰기 성공시
                	PrintWriter script = response.getWriter();
                    script.println("<script>");
                    script.println("location.href = 'board.jsp'");    // 메인 페이지로 이동
                    script.println("</script>");    
                }
        	}	
    	}
    %>
 
</body>
</html>