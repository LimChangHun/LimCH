<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 게시판</title>
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
        	width: 10%;
        	float:left;
        }
        #writeTittle{
            border: 1px solid #00000010;
            height:100%;
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

        #footer{
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
    	#ti{
    		width:90%;
    		height:30px;
    	}
    	#writeContents{
            width: 100%;
            height: 300px;
        }
        p{
        	width: 100%;
        	height:220px;
        }
    </style>
</head>
<body>
	<form action="writeModifyComplete?seq_board=${li.board_seq1}" method="post">
	<div class="container">
    <br>
    <br>
		 <div class="row">
		     <div id="header"><h1>글 수정하기</h1></div>
		 </div>
		 <div class="row">
         <div id="tittle" name="title1"> 
		     <input type="text" id="ti" name="title" value="${li.title}">
		    <div id="tittle1" class="gray">제목 </div>
		  </div>
		 </div>
		 
		 <div class="row">
             <div id="write"> 
             ${li.writer}　
		      <div id="write1" class="gray">글쓴이 </div>
		      <div id="search" name="search1">${li.viewcount}</div>
		      <div id="search1" class="gray">조회 </div>
             </div>  
		 </div>
		 <div class="row">
		 	<div id="writeContents" name="contents1"><textarea id="summernote" name="contents">${li.contents}</textarea></div>	 
		 </div>
		
        <br>
        <div class="row">
		 <div id="footer">
		
		 	<input type="button" value="목록가기" id="cancle">
		 	<input type="submit" value="수정하기" id="modify">    
		 </div>
		 </div>
	</div>
</form>
	<script>		
		$("#cancle").on("click",function(){
			$(location).attr("href","board");
		})
		$("#modify").on("click",function(){
			$(location).attr("href","writeModifyComplete?seq_board=${li.board_seq1}");
		})

		$(document).ready(function() {
	        $('#summernote').summernote();
	    });
	</script>
	
	
</body>
</html>
