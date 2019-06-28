<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        h1{
            color: #00000080;
            text-align: center;
        }
        #header{
            width: 100%;
        }
        #search{
            float: right;
        }
        select{
            height: 30px;
            float: right;
        }
        #searchBtn{
            float: right;
            background-color: #00000050;
            color: white;
        }
        #session,#nav{
            width: 100%;
            float: left;
        }
        #div1,#navNum{
            float: left;
            width: 10%;
            text-align: center;
        }
        #div2,#navTittle{
            float: left;
            width: 60%;
        }
        #navTittle{
            text-align: center;
        }
        #div3,#navWriter{
            float: left;
            width: 10%;
            text-align: center;
        }
        #div4,#navDay{
            float: left;
            width: 10%;
            text-align: center;
        }
        #div5,#navSearch{
            float: left;
            width: 10%;
            text-align: center;
        }
        
        #num{
            width: 100%;
            text-align:center;
        }      
        .btn1{
            float:right;
            background-color: #00000050;
            color: white;
        }
        #footer{
            width: 100%;
        }
        #write{
            float: right;
            background-color: #00000050;
            color: white;
        }
        #mypage{
            float: right;
            background-color: #00000050;
            color: white;
        }
        a{
			color:black;	
		}
		.naviBtn{
			color:#00000080;	
		}
		.page-link{
			color:#00000080;
		}
    </style>
<body>
	<br>
	<form action="titleSearch.board">
	<div class="container">
    <div><h1>글쓰기 게시판</h1></div>
  <div class="row">
        <div id="header">
        <input type="submit" value="검색" id="searchBtn"> 
        <input type="text" id="search" name="titleSearch"> 
        <select id="select" name="opp">
                <option name="opp">전체</option>
                <option name="opp">제목</option>
                <option name="opp">작성자</option>
            </select>
        </div>
  </div>
     <hr style="border: solid 2px #00000030">
  <div class="row">
   <div id="nav">
    <div id="navNum">번호</div>
    <div id="navTittle">제목</div>
    <div id="navWriter">작성자</div>
    <div id="navDay">작성일</div>
    <div id="navSearch">조회</div>
  </div>
    </div>
     <hr>
  <div class="row">
       <div id="session">
                <c:forEach var="board" items="${result}">
                			<div id="div1">${board.board_seq1}</div>
                			<div id="div2">
                			<a href="/boardView?seq_board=${board.board_seq1}">
                			${board.title}
                			</a>      			
                			</div>
               				<div id="div3">${board.writer}</div>
                 			<div id="div4">${fn:substring(board.writedate,0,10)}</div>
                 			<div id="div5">${board.viewcount}</div>           
                </c:forEach>
         </div>
  </div>
     <hr>
  <div class="row">
       <div id="num">
        <!-- <input type="button" value="4" class="btn1">
        <input type="button" value="3" class="btn1">
        <input type="button" value="2" class="btn1">
        <input type="button" value="1" class="btn1"> 여기다 받아와서 navi page 만들기!-->
        <c:forEach var="num" items="${sb}">
        	<a href="selectNum.board?num=${num}" class="naviBtn">${num}</a>
        </c:forEach>
</div>
</div>
  <div class="row">
    <div id="footer">
    	<input type="button" value="마이페이지" id="mypage">
    	<input type="button" value="글쓰기" id="write">
	</div>
  </div>
    <div class="row p-0 m-0 numBox">
            <div class="col-12 d-flex justify-content-center navi mt-1">
               <nav aria-label="Page navigation example">
                  <ul class="pagination pagination-sm">${getNavi}</ul>
               </nav>
            </div>
         </div>
 </div>
 </form>
 	
 	<script>
 		$("#mypage").on("click",function(){
 			$(location).attr("href","mypageProc");
 		})
 		
 		$("#write").on("click",function(){
 			$(location).attr("href","writePage");
 		})
// 		document.getElementById("searchBtn").onclick=function(){
//			location.href="titleSearch.board"; 
//		}
 	</script>
 	
</body>
</html>