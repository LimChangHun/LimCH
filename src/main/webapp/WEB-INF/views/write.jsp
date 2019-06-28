<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
        .container{
            width: 100%;
        }
        #header{
            width: 100%;
            text-align: center;
        }
        h1{
            background-color: #00000010;
            color: #00000080;
        }
        #title{
             border: 1px solid color: #00000080;;
            width: 100%;
            margin: auto;
        }
        #writeTitle{
             border: 1px solid color: #00000080;;
            width: 100%;

        }
        #write{
             border: 1px solid color: #00000080;
            width: 100%;
            height: 300px;
        }
        #writeContents{
            width: 100%;
            height: 100%;
        }
        #writting{
        	width: 100%;
        	height: 293px;
        	border: 1px solid #00000080;
        	overflow:scroll;
        }
        #footer{
            width: 100%;
            float: right;
        }
        #image{
        	text-align: center;
        }
        #ok,#board{
            float: right;
            background-color: #00000050;
            color: white;
        }
        p{
        	height:230px;
        }
    
    </style>
</head>
<body>
	<div class="container">
	<form action="writeComplete?currentPage=1" id="a" method="post" enctype="multipart/form-data">
    <br>
    <br>
		 <div class="row">
		     <div id="header"><h1>글쓰기</h1></div>
		 </div>
		 <div class="row">
         <div id="title">
		     <input type="text" placeholder="글제목" id="writeTitle" name="title">
		  </div>
		 </div>
		 
		 <div class="row">
             <div id="write">
             	<input type="file" name="path" id="image">
		        <div id="writting" contenteditable="true">

		        </div>
		        <input type="hidden" name="contents" id="contents">
             </div>    
		 </div>
        <br>
        <div class="row">
		 <div id="footer">
		     <input type="button" value="작성하기" id="ok">
		     <input type="button" value="게시판" id="board">
		 </div>
		 </div>
		 </form>
	</div>
	
	
	<script>
		$("#image").on("input",function(){
			var formData = new FormData();
			formData.append("formData",$(this)[0].files[0]);
			$.ajax({
				url:"imageUpdate",
				type:"post",
				processData:false,
				contentType:false,
				data:formData
			}).done(function(resp){
				//var time = new Date().getTime();
				console.log(resp);
				$("#writting").append("<img src='/image/img/"+resp+"'>");
			})
		})
		
		$("#ok").on("click",function(){
			$("#contents").val($("#writting").html());
			$("#a").submit();
		})
	
		document.getElementById("board").onclick=function(){
			$(location).attr("href","board?currentPage=1");
		}
	</script>
	
</body>
</html>