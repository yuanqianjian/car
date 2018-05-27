/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-05-22 08:41:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.customers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>添加客户</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/pintuer.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/admin.css\">\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"js/pintuer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar flag = true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//验证身份证非重复\r\n");
      out.write("\t\t$('#identity').blur(function() {\r\n");
      out.write("\t\t\tvar identity = $(\"#identity\").val();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"customer/findIdentity.do\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"identity\" : identity\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tflag = result;\r\n");
      out.write("\t\t\t\t\tif(!flag){\r\n");
      out.write("\t\t\t\t\t\t$(\"#tip\").html(\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户名已存在\");\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#tip\").html(\"\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//提交表单\r\n");
      out.write("\t\t$('#form1').submit(function() {\r\n");
      out.write("\t\t\treturn flag;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"panel admin-panel\">\r\n");
      out.write("\t\t<div class=\"panel-head\">\r\n");
      out.write("\t\t\t<strong><span class=\"icon-pencil-square-o\"></span> 添加客户</strong>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"body-content\">\r\n");
      out.write("\t\t\t<form method=\"post\" class=\"form-x\" id=\"form1\" action=\"customer/addCustomer.do\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>身份证：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input w50\" id=\"identity\" name=\"identity\" data-validate=\"required:请输入身份证\" />\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tip\" style=\"color: red;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>姓名：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input w50\" name=\"custName\" data-validate=\"required:请输入姓名\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>性别：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"button-group radio\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"button active\"> \r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"男\" checked=\"checked\" />男 \r\n");
      out.write("\t\t\t\t\t\t</label> \r\n");
      out.write("\t\t\t\t\t\t<label class=\"button\"> \r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"女\" />女\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>地址：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input w50\" name=\"address\" data-validate=\"required:请输入地址\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>电话：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input w50\" name=\"phone\" data-validate=\"required:请输入电话\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label>职业：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input w50\" name=\"carEer\" data-validate=\"required:请输入职业\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div class=\"label\">\r\n");
      out.write("\t\t\t\t\t\t<label></label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"button bg-main icon-check-square-o\" type=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\t提交</button>\r\n");
      out.write("\t\t\t\t\t\t<button class=\"button bg-green icon-check-square-o\" type=\"reset\">重置</button>\r\n");
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
