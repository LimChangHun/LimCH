<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	img{
		height:100px;
		width:100px;
	}
</style>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>마이페이지</title>
</head>
<body>
<h1>${id}의 마이페이지</h1><br>
<img src="/image/${id}/${profile}"><br>
<input type="button" value="게시판" id="board">
<input type="button" value="로그아웃" id="logout">

<script>
	$("#board").on("click",function(){
		$(location).attr("href","board?currentPage=1");
	})
	$("#logout").on("click",function(){
		$(location).attr("href","/");
	})
</script>
</body>
</html>