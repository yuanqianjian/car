/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-05-22 07:51:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.systemManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modifyRoleManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\">\r\n");
      out.write("<title>修改角色权限</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/pintuer.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/admin.css\">\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"js/pintuer.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".selectbox {\r\n");
      out.write("\twidth: 1200px;\r\n");
      out.write("\theight: 220px;\r\n");
      out.write("\tmargin: 100px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".selectbox div {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"role/FindRole.do\",\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t$(result).each(\r\n");
      out.write("\t\t\t\t\t\tfunction(index, domEle) {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#roleId\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"<option value='\" + domEle.roleId + \"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ domEle.roleName + \"</option>\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//查询不同角色的权限\r\n");
      out.write("\t\t$('#roleId').change(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\tvar roleId = $(\"#roleId\").val();\r\n");
      out.write("\t\t\t\t\t$(\"#select1\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#select2\").empty();\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"role/FindRoleMenu.do\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\"roleId\" : roleId\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t$(result).each(\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfunction(index, domEle) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#select1\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\"<option value='\" + domEle.menuId + \"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ domEle.menuName\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</option>\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"role/FindRoleMenuNo.do\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\"roleId\" : roleId\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t$(result).each(\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfunction(index, domEle) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#select2\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\"<option value='\" + domEle.menuId + \"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ domEle.menuName\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</option>\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//移到右边\r\n");
      out.write("\t\t$('#add').click(function() {\r\n");
      out.write("\t\t\t//先判断是否有选中\r\n");
      out.write("\t\t\tif (!$(\"#select1 option\").is(\":selected\")) {\r\n");
      out.write("\t\t\t\talert(\"请选择需要移动的选项\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//获取选中的选项，删除并追加给对方\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\t$('#select1 option:selected').appendTo('#select2');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//移到左边\r\n");
      out.write("\t\t$('#remove').click(function() {\r\n");
      out.write("\t\t\t//先判断是否有选中\r\n");
      out.write("\t\t\tif (!$(\"#select2 option\").is(\":selected\")) {\r\n");
      out.write("\t\t\t\talert(\"请选择需要移动的选项\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//获取选中的选项，删除并追加给对方\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\t$('#select2 option:selected').appendTo('#select1');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//全部移到右边\r\n");
      out.write("\t\t$('#add_all').click(function() {\r\n");
      out.write("\t\t\t//获取全部的选项,删除并追加给对方\r\n");
      out.write("\t\t\t$('#select1 option').appendTo('#select2');\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//全部移到左边\r\n");
      out.write("\t\t$('#remove_all').click(function() {\r\n");
      out.write("\t\t\t$('#select2 option').appendTo('#select1');\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//双击选项\r\n");
      out.write("\t\t$('#select1').dblclick(function() { //绑定双击事件\r\n");
      out.write("\t\t\t//获取全部的选项,删除并追加给对方\r\n");
      out.write("\t\t\t$(\"option:selected\", this).appendTo('#select2'); //追加给对方\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//双击选项\r\n");
      out.write("\t\t$('#select2').dblclick(function() {\r\n");
      out.write("\t\t\t$(\"option:selected\", this).appendTo('#select1');\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//提交表单\r\n");
      out.write("\t\t$('#form1').submit(function() {\r\n");
      out.write("\t\t\tvar arr1 = [];\r\n");
      out.write("\t\t\t$(\"#select1 option\").each(function(index, domEle) {\r\n");
      out.write("\t\t\t\tarr1[index] = $(this).val();\r\n");
      out.write("\t\t\t\t$(\"#hidden\").val(arr1.join(\",\"));\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"panel admin-panel\">\r\n");
      out.write("\t\t<div class=\"panel-head\">\r\n");
      out.write("\t\t\t<strong><span class=\"icon-pencil-square-o\"></span> 修改角色权限</strong>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"body-content\">\r\n");
      out.write("\t\t\t<form method=\"post\" class=\"\" id=\"form1\"\r\n");
      out.write("\t\t\t\taction=\"role/modifyRoleMenu.do\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>要修改权限的角色：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<select id=\"roleId\" name=\"roleId\" class=\"input w50\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-validate=\"required:请选择角色\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">--请选择角色--</option>\r\n");
      out.write("\t\t\t\t\t\t</select> <input type=\"hidden\" id=\"hidden\" name=\"menuIdStr\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"selectbox\" >\r\n");
      out.write("\t\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>想设置的权限:&nbsp;&nbsp;&nbsp;</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t\t<select multiple=\"multiple\" name=\"menuId\" class=\"input w50\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"select1\" style=\"height: 300px;width: 200px\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\" style=\"height: 300px;width: 130px\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\" style=\"margin-top: 40px\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"add\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" style=\"width: 70px\" class=\"button bg-yellow\" title=\"添加选中权限\" />&gt;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"add_all\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" style=\"width: 70px\" class=\"button bg-yellow\" title=\"添加全部权限\" />&gt;&gt;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"remove\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" style=\"width: 70px\" class=\"button bg-yellow\" title=\"移除选中权限\" />&lt;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"remove_all\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" style=\"width: 70px\" class=\"button bg-yellow\" title=\"移除全部权限\" />&lt;&lt;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\" style=\"height: 300px;width: 50px\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>不需要的权限:&nbsp;&nbsp;&nbsp;</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select multiple=\"multiple\" id=\"select2\" class=\"input w50\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"height: 300px;width: 200px\"></select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\" style=\"height: 300px;width: 50px\"></div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\" style=\"margin-top: 260px\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"button bg-main icon-check-square-o\" type=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t改变权限</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}