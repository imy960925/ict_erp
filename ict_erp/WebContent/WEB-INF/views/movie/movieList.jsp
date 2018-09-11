<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	<table class= "table table-bordered table-hover">
	<thead>
	<tr>
		<th>번호</th>
	    <th>영화제목</th>
		<th>가격</th>
		<th>시작시간</th>
		<th>종료시간</th>
		<th>개봉일</th>
		<th>영화설명</th>
		<th>관객수</th>
		<th>이미지</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${empty tmiList}">
					<tr>
						<td colspan="9">등록된 음악이 없습니다</td>
					</tr>
				</c:if>
				<c:forEach items="${tmiList}" var="tmi">
					<tr>
						<td>${tmi.tmNum}</td>
						<td>${tmi.tmName}</td>
						<td>${tmi.tmPrice}</td>
						<td>${tmi.tmStartdat}</td>
						<td>${tmi.tmEnddat}</td>
						<td>${tmi.tmCredat}</td>
						<td>${tmi.tmDesc}</td>
						<td>${tmi.tmCnt}</td>
						<td>${tmi.tmImg}</td>
					</tr>
				</c:forEach>
	
	</tbody>

	
	</table>
	
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />