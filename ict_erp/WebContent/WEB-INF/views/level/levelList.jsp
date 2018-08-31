<%@page import="com.ict.erp.vo.LevelInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<div>
		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" onclick="chk(this)"></th>
					<th>레벨번호</th>
					<th>레벨등급</th>
					<th>레벨명</th>
					<th>레벨설명</th>
				</tr>
			</thead>
			<tbody id="liTbody">
			<c:forEach items="${liList}" var="li">
				<tr>
					<td><input type="checkbox" name="liNum" value="${li.liNum}"></td>
					<td>${li.liNum}</td>
					<td>${li.liLevel}</td>
					<td>${li.liName}</td>
					<td>${li.liDesc}</td>
				</tr>
			</c:forEach>
			<c:if test="${empty liList}">
				<tr>
					<td colspan="5">레벨이 없습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>
		<div class="btns">
		<button id="add" onclick="addRow()" >레벨추가</button>
		<button id="save" onclick="saveLevel()" >레벨저장</button>
		<button id="del" onclick="deleteLevel()">레벨삭제</button>
		
		
		</div>
		<div>
		<select name="search">
		<option value="liDesc">레벨설명</option>
		<option value="liName">레벨명</option>
		</select>
		<input type="text" name="searchText">
		<button onclick="searchTest()">검색</button>
		</div>
	</div>

	<script>
	var cnt = '${rMap.cnt}';
	if(cnt){
		if(cnt>0){
			alert('${rMap.msg}');
			location.href='/level/levelList';
			
		}
	}
	var emptyList = '${empty liList}';
	function addRow(){
		var html='<tr>';
		html +='<td>&nbsp;</td>';
		html +='<td>&nbsp;</td>';
		html +='<td><input type="text" name="liLevel"></td>';
		html +='<td><input type="text" name="liName"></td>';
		html +='<td><input type="text" name="liDesc"></td>';
		html +='</tr>';
		var obj = document.querySelector('#liTbody');
		if(emptyList){
			obj.innerHTML = html;
			emptyList = false;
		}else{
			obj.insertAdjacentHTML('beforeend',html);
		}
		
	}
	function makeParam(name,option){
		var selector = 'input[name=' + name + ']';
		if(!document.querySelector(selector)){
			selector = 'select[name=' + name + ']';
			if(!document.querySelector(selector)){
				selector = 'textarea[name=' + name + ']';
			}
		}
		if(option){
			selector += option;
		}
		var objs = document.querySelectorAll(selector);
		var param = ''
		for(var i=0;i<objs.length;i++){
			param += name + '=' + objs[i].value + '&';
		}
		return param;
	}
	function saveLevel() {
		var params = makeParam('liLevel');
		params += makeParam('liName');
		params += makeParam('liDesc');
		location.href='/level/saveLevelList?' + params;
		
	}
	function chk(f){
		document.querySelectorAll('input[name=liNum]').forEach((el)=> {
			el.checked = f.checked;
		});
	}
	function deleteLevel(){
		var params = makeParam('liNum',':checked');
		location.href='/level/deleteLevelList?' + params;
	}
	function searchTest(){
		var params = makeParam('search');
		params += makeParam('searchText');
		console.log(params)
		location.href = '/level/levelList?' + params;
		
		
	}
	</script>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />