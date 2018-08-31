<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${empty miList}">
<script>
alert('${miList.msg}');
if(${miList.cnt}==1) {
	location.href = 'member/memberList';
}

</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	<form action="/member/memberInsert" method="post">
	<table class = "table table-bordered">
		<tr>
		<th>아이디</th>
		<td><input type="text" name="miId"></td>
		</tr>
		<tr>
		<th>이름</th>
		<td><input type="text" name="miName"></td>
		</tr>
		<tr>
		<th>비밀번호</th>
		<td><input type="password" name="miPwd"></td>
		</tr>
		<tr>
		<th>부서코드</th>
		<td><input type="text" name="diCode"></td>
		</tr>
		<tr>
		<th>권한레벨</th>
		<td><input type="number" name="liLevel"></td>
		</tr>
		<tr>
		<th>이메일</th>
		<td><input type="text" name="miEmail"></td>
		</tr>
		<tr>
		<th>부서설명</th>
		<td><input type="text" name="miDesc"></td>
		</tr>
		<tr>
		<th>전화번호</th>
		<td><input type="text" name="miPhone"></td>
		</tr>
		<tr>
		<th>우편번호</th>
		<td><input type="text" name="miZipCode"></td>
		</tr>
		<tr>
		<th>주소1</th>
		<td><input type="text" name="miAddress1"></td>
		</tr>
		<tr>
		<th>주소2</th>
		<td><input type="text" name="miAddress2"></td>
		</tr>
		</table>
	<button>추가</button>
	</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />