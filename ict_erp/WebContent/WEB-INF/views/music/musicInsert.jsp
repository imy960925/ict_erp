<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<script>
alert('${miList.msg}');
if(${miList.cnt}==1) {
	location.href = 'music/musicList';
}
</script>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	<form action="/music/musicInsert" method="post">
	<table class="table table-bordered table-hover" >
	<tr>
	<th>번호</th>
	<td><input type="number" name="mcNum"></td>
	</tr>
	<tr>
	<th>노래제목</th>
	<td><input type="text" name="mcName"></td>
	</tr>
	<tr>
	<th>가수이름</th>
	<td><input type="text" name="mcSinger"></td>
	</tr>
	<tr>
	<th>배급사</th>
	<td><input type="text" name="ncVendoer"></td>
	</tr>
	<tr>
	<th>좋아요</th>
	<td><input type="number" name="mcLike"></td>
	</tr>
	<tr>
	<th>싫어요</th>
	<td><input type="number" name="mcDisLike"></td>
	</tr>
	<tr>
	<th>점수</th>
	<td><input type="text" name="mcCredat"></td>
	</tr>
	<tr>
	<th>발매일</th>
	<td><input type="text" name="mcDesc"></td>
	</tr>
	
	</table>
	<button>음악 추가</button>
	</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />