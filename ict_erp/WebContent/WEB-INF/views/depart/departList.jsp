<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:set var="di" value="${diList}" />
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<table class="table table-bordered table-hover">

				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서코드</th>
						<th>부서이름</th>
						<th>부서설명</th>
					</tr>
				</thead>
				<tr>
				<tbody>
					<c:forEach var="di" items="${diList}">
						<tr onclick="search(${di.diNum})">
							<td>${di.diNum}</td>
							<td>${di.diCode}</td>
							<td>${di.diName}</td>
							<td>${di.diDesc}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		<div class="page" style="text-align:center">
			<c:if test="${page.sBlock!=1}">
				[<a href="<%=rPath%>/depart/departList?page=${page.sBlock-page.blockSize}">pre</a>]
			</c:if>
			<c:forEach	begin="${page.sBlock}" end="${page.lBlock}" var="p"> <!-- begin = 1  end = 10 -->
				[<a href="<%=rPath%>/depart/departList?page=${p}">${p}</a>]
			</c:forEach>
			<c:if test="${page.lBlock!=page.totalPage}"> 
				[<a href="<%=rPath%>/depart/departList?page=${page.sBlock+page.blockSize}">next</a>]
			</c:if>
	</div>
	<script>
	function search(diNum) {
	location.href = "/depart/departView?diNum="+ diNum;
		
	}
	</script>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />