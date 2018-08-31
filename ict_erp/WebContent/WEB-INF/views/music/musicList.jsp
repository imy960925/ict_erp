<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>노래제목</th>
					<th>가수</th>
					<th>배급사</th>
					<th>좋아요</th>
					<th>싫어요</th>
					<th>점수</th>
					<th>발매일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty miList}">
					<tr>
						<td colspan="8">등록된 음악이 없습니다</td>
					</tr>
				</c:if>
				<c:forEach items="${miList}" var="mi">
					<tr>
						<td>${mi.mcNum}</td>
						<td>${mi.mcName}</td>
						<td>${mi.mcSinger}</td>
						<td>${mi.mcVendoer}</td>
						<td>${mi.mcLike}</td>
						<td>${mi.mcDisLike}</td>
						<td>${mi.mcCredat}</td>
						<td>${mi.mcDesc}</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />