<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
	<script>
	alert('${tmiList.msg}');
	if(${tmiList.cnt}==1) {
		location.href = 'movie/movieList';
	}
	</script>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
<form action="/movie/movieInsert">
<table class="table table-bordered table-hover">
<thead>
<tr>
<th>번호</th>
<td><input type="number" name="tmNum"></td>
</tr>
<tr>
<th>영화제목</th>
<td><input type="text" name="tmName"></td>
</tr>
<tr>
<th>가격</th>
<td><input type="number" name="tmPrice"></td>
</tr>
<tr>
<th>시작시간</th>
<td><input type="text" name="tmStartdat"></td>
</tr>
<tr>
<th>종료시간</th>
<td><input type="text" name="tmEnddat"></td>
</tr>
<tr>
<th>개봉일</th>
<td><input type="text" name="tmCredat"></td>
</tr>
<tr>
<th>영화설명</th>
<td><input type="text" name="tmDesc"></td>
</tr>
<tr>
<th>관객수</th>
<td><input type="number" name="tmCnt"></td>
</tr>
<tr>
<th>이미지</th>
<td><input type="text" name="tmImg"></td>
</tr>
</thead>
<button>영화추가</button>

</table>
</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />