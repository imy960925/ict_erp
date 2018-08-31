<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	
	<table class = "table table-bordered table-hover">
	<tr>
	<th>메뉴번호</th>
	<th>메뉴이름</th>
	<th>메뉴가격</th>
	<th>메뉴설명</th>
	</tr>
	<tbody id = "meiTbody">
	<c:forEach var="mei" items="${meiList}">
	<tr>
	<td><input type="checkbox" name="meiNum" value="${mei.meiNum}"></td>
		<td>${mei.meiNum}</td>
		<td>${mei.meiName}</td>
		<td>${mei.meiPrice}</td>
		<td>${mei.meiDesc}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<div class="button">
	<button id="add" onclick="addRow()" >메뉴추가</button>
	<button id="save" onclick="saveLevel()" >메뉴수정</button>
	<button id="del" onclick="deleteLevel()">메뉴삭제</button>
	</div>
	<div>
	<select name="search">
	<option value="meiName">메뉴이름</option>
	<option value="meiDesc">메뉴설명</option>
	</select>
	</div>
	
	<script>
	function chk(f){
		document.querySelectorAll('input[name=meiNum]').forEach((el)=> {
			el.checked = f.checked;
		};
	}
	function menuDelete(){
		var params = makeParam('meiNum',':checked');
		location.href='/menu/menuDelete?' + params;
	}
	</script>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />