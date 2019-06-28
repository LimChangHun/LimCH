<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
        #tittle{
        
            border: 1px solid #00000010;
            width: 100%;
            margin: auto;
            float:left;
        }
        #tittle1{
        	float:left;
        }
        #writeTittle{
            border: 1px solid #00000010;;
            width: 100%;

        }
        #write{
            border: 1px solid #00000010;;
            width: 100%;
            float:left;
        }
        #write1{
        	float:left;
        }
        #write2{
        	float:left;
        }
        #search{
        	float:right;
        	width:3%;
        	text-align:center;
        }
        #search1{
        	float:right;
        }
        #writeContents{
        	border: 1px solid #00000010;;
            width: 100%;
            height: 300px;
        }
        #button{
            width: 100%;
            float: right;
        }
        #cancle{
            float: right;
            background-color: #00000050;
            color: white;
        }
        #delete,#modify{
        	background-color: #00000050;
            color: white;
        }
        #writeContents{
        	float:left;
        }
        .gray{
        	background-color:#00000010;
        	width:8%;
        	text-align:center;
        }
        #comment{
        	height:65px;
			width: 100%;
		}
		#commentButton{
			border-radius: 10px 10px 10px 10px;
			color:white;
			background-color:#4ff00a;
			float: right;
		}
		
   
    </style>
</head>
<body>
	<div class="container">
    <br>
    <br>
		 <div class="row">
		     <div id="header"><h1>글 내용 보기</h1></div>
		 </div>
		 <div class="row">
         <div id="tittle" name="title1"> 
		     ${li.title}
		    <div id="tittle1" class="gray">제목 </div>
		  </div>
		 </div>
		 
		 <div class="row">
             <div id="write" name="name1"> 
		      <div id="write1" class="gray">글쓴이 </div>
		      <div id="write2">${li.writer}</div>　
		      <div id="search" name="search1">${li.viewcount}</div>
		      <div id="search1" class="gray">조회 </div>
             </div>  
		 </div>
		 <div class="row">
		 	<div id="writeContents" name="contents1">${li.contents}</div>	 
		 </div>
		
        <br>
         
        <div class="row">
		 <div id="button">
		 	<input type="button" value="목록가기" id="cancle">
		 
		 	<input value="수정" type="button" id="modify">
		 	<input value="삭제" type="button" id="delete">
		 </div>
		 </div>

        <div class="row"> <!-- 댓글 -->
        	<div id="comments">
        	<div><h3>Comments</h3></div><hr>
        	<textarea placeholder="댓글을 입력하세요" id="comment"></textarea>
        	<input type="button" value="등록" id="commentButton">	
        	</div>
        	<br>
        	<div id="commentInput"></div>
        </div>

		 
	</div>
	
	<script>
		$("#cancle").on("click",function(){
			$(location).attr("href","board?currentPage=1");
		})
		
		$("#modify").on("click",function(){
			$(location).attr("href","writeModify?seq_board=${li.board_seq1}");
		})
		
		$("#delete").on("click",function(){
			$(location).attr("href","writeDelete?seq_board=${li.board_seq1}");
		})
		
		$("#commentButton").on("click",function(){
			$.ajax({
				url:"comment",
				data:{
					"comment":$("#comment").val(),
					"writer":$("#write2").text()
					
				}
			}).done(function(resp){
				$("#commentInput").append("<div>"+resp+"</div>");
				$("#comment").val("");
			})
		})
		
	</script>
	
</body>
</html>