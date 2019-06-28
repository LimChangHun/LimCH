<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chat</title>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
	div{
		border: 1px solid black;
		box-sizing: border-box;
	}
	.container{
		width:400px;
		height:400px;
		margin: 0 auto;
	}
	
	.contents{
		width:100%;
		height:85%;
		overflow-y:auto;
	}
	.control{
		width:100%;
		height:15%;
	}
	.msg{
		width:100%;
		height:100%;
	}
	.msg,#send{
		float:right;
	}
	.msg>input[type=text]{
		height:100%;
		width:100%;
		box-sizing: border-box;
	}
	
	.control>input[type=text]{
		height:100%;
		width:80%;
		box-sizing: border-box;
	}
	.control>input[type=button]{
		height:100%;
		width:20%;
		box-sizing: border-box;
	}
	.myMsg{
		text-align: right;
	}	
</style>
<body>
	<div class="container">
	
			<div class="contents">

		</div>
		<div class="control">
			<input type="text" id="input">
			<input type="button" id="send" value="send">
		</div>
	</div>
	
	<script>
		var socket = new WebSocket("ws://localhost/chat"); //여기서 내가 상황에 따라 조절 가능! ex).버튼눌렀을때로 실행! 할 수 있다.
		//배포할꺼면 localhost에 내 컴퓨터 id
		
		socket.onmessage = function(evt){
			$(".contents").append("${id}님:"+evt.data); //evt.data ->서버로 부터 받은 데이터
			$(".contents").scrollTop($(".contents")[0].scrollHeight);
		}//서버측에서 메세지 넘어왔을 때 무엇을 할것인가
		
		$("#input").on("keydown",function(key){
			if (key.keyCode == 13) {
			var msg = $("#input").val();
			$("#input").val("");
			$(".contents").append("<p class='myMsg'>${id}님: "+msg+"</p>");
			$(".contents").scrollTop($(".contents")[0].scrollHeight);
			socket.send(msg);
			}
		})//서버로 메세지를 보내는 경우
	</script>
	<!-- 클라이언트! -->

</body>
</html>