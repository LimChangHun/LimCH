<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>로그인 HOME</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style>
	img{
		height:100px;
		width:100px;
	}
</style>
<body>
<h1>
	로그인
</h1>

<c:choose>
<c:when test="${result==1}">
<h1>${id}님 반갑습니다.</h1><br>
<img src="/image/${id}/${profile}"><br>
	<input type="button" value="마이페이지" id="mypage">
	<input type="button" value="게시판" id="board">
	<input type="button" id="toChat" value="채팅">
	<input type="button" value="로그아웃" id="logout">
</c:when>
<c:otherwise>
	<form action="loginProc" method="post">
	<input type="text" placeholder="ID" name="id"><br>
	<input type="password" placeHolder="PW" name="pw"><br>
	<input type="submit" value="로그인">
	</form>	
	<input type="button" id="memberJoin" value="회원가입">
</c:otherwise>
</c:choose>
	
	<script>
		$("#memberJoin").on("click",function(){
			$(location).attr("href","memberJoinForm");
		
		})
		
		$("#logout").on("click",function(){
			$(location).attr("href","/");
		})
		
		$("#mypage").on("click",function(){
			$(location).attr("href","mypageProc");
		})
		$("#board").on("click",function(){
			$(location).attr("href","board?currentPage=1");
		})
		
		$("#toChat").on("click",function(){
			$(location).attr("href","webchat");		
		})
	</script>
	
</body>
</html>
