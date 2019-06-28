<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 Form</title>
</head>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<body>
<h1>회원가입</h1>
	<form action="join" method="post" enctype="multipart/form-data">
	 	아이디<input type="text" name="id" id="id"><span id="idC"></span><br>
		비밀번호<input type="password" name="pw" id="pw"><br>
		프로필<input type="file" name="img"><br>
		<input type="submit" value="가입하기">
	</form>
	
	<script>
		$("#id").on("input",function(){
			$.ajax({
				url:"loginCheck",
				data:{
					id:$("#id").val()
				}
			}).done(function(resp){
				if(resp=="false"){
				$("#idC").text("실패")
				}else{
				$("#idC").text("성공")	
				}
			})
		})
	
	
		$("#pwC").on("input",function(){
			$.ajax({
				url:"pwConfirmAjax",
				data: {
					"pw":$("#pw").val()
					}
			}).done(function(resp){
				
			})
		})
	</script>
</body>
</html>