<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<title>查询客户</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript">
	function Delete(id) {
		if (confirm("您确定要删除吗?")) {
			location.href = "customer/DeleteCustomer.do?identity=" + id;
		}
	}

	function Update(id) {
		location.href = "customer/SelectCustomer.do?identity=" + id;
	}

	function Select(id) {
		location.href = "customer/SelectCustomer.do?identity=" + id;
	}

    function change(pageNum) {
        //给表单pageNum和pageSize表单项赋值value
        $("#pageNum").val(pageNum);
        //提交表单
        $("#form1").submit();
    }
</script>
</head>
<body>
	<form method="post" id="form1" action="customer/findCustomers.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 客户查询</strong>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>身份证</th>
					<th>姓名</th>
					<th>性别</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${requestScope.customersList }" var="cust"
					varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${cust.identity }</td>
						<td>${cust.custName }</td>
						<td>${cust.sex }</td>
						<td><div class="button-group">
								<a class="button border-green"
									href="javascript:Select('${cust.identity }')"><span
									class="icon-search"></span> 查询</a>
							</div>
							<div class="button-group">
								<a class="button border-blue"
									href="javascript:Update('${cust.identity }')"><span
									class="icon-edit"></span> 修改</a>
							</div>
							<div class="button-group">
								<a class="button border-red"
									href="javascript:Delete('${cust.identity }')"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="8">
						共&nbsp;${requestScope.total }&nbsp;条数据，共&nbsp;${requestScope.pages}&nbsp;页

						<div class="pagelist">
							<c:if test="${requestScope.pageNum == 1 }">
								<a href="javaScript:void();">上一页</a>
							</c:if>
							<c:if test="${requestScope.pageNum != 1 }">
								<a href="javaScript:change(${requestScope.pageNum-1 });">上一页</a>
							</c:if>
							<%--显示所有页码--%>
							<%--<c:if test="${requestScope.pages <= 5}">--%>
							<c:forEach  begin="1" end="${requestScope.pages}" step="1" var="i">
								<c:if test="${requestScope.pageNum == i }">
									<span class="current">${i}</span>
								</c:if>
								<c:if test="${requestScope.pageNum != i }">
									<a href="javaScript:change(${i});">${i}</a>
								</c:if>
							</c:forEach>
							<%--</c:if>--%>

							<%--最多显示五个页码--%>
							<%--<c:if test="${requestScope.pages > 5}">--%>
							<%--<c:forEach  begin="1" end="${requestScope.pages}" step="1" var="i">--%>
							<%--<c:if test="${requestScope.pageNum == i }">--%>
							<%--<span class="current">${i}</span>--%>
							<%--</c:if>--%>
							<%--<c:if test="${requestScope.pageNum - 1 == i }">--%>
							<%--<a href="javaScript:change(${i});">${i}</a>--%>
							<%--</c:if>--%>
							<%--<c:if test="${requestScope.pageNum - 2 == i }">--%>
							<%--<a href="javaScript:change(${i});">${i}</a>--%>
							<%--</c:if>--%>
							<%--<c:if test="${requestScope.pageNum + 1 == i }">--%>
							<%--<a href="javaScript:change(${i});">${i}</a>--%>
							<%--</c:if>--%>
							<%--<c:if test="${requestScope.pageNum + 2 == i }">--%>
							<%--<a href="javaScript:change(${i});">${i}</a>--%>
							<%--</c:if>--%>
							<%--</c:forEach>--%>
							<%--</c:if>--%>


							<c:if test="${requestScope.pages == requestScope.pageNum }">
								<a href="javaScript:void();">下一页</a>
							</c:if>
							<c:if
									test="${requestScope.pages != requestScope.pageNum }">
								<a href="javaScript:change(${requestScope.pageNum+1 });">下一页</a>
							</c:if>

						</div>
					</td>
					<td><input type="hidden" name="custName"
						value="${requestScope.oldCust.custName }" /> <input type="hidden"
						name="identity" value="${requestScope.oldCust.identity }" /> <input
						type="hidden" name="sex" value="${requestScope.oldCust.sex }" />
						<input type="hidden" name="address"
						value="${requestScope.oldCust.address }" /> <input type="hidden"
						name="phone" value="${requestScope.oldCust.phone }" /> <input
						type="hidden" name="carEer"
						value="${requestScope.oldCust.carEer }" /> <input type="hidden"
						id="pageNum" name="pageNum" /><input type="hidden"
						id="pageSize" name="pageSize" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>