/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-05-22 07:15:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>系统信息</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/pintuer.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("*{ margin:0px; padding:0px;}\r\n");
      out.write(".error-container{ background:#fff; border:1px solid #0ae;  text-align:center; width:450px; margin:250px auto; font-family:Microsoft Yahei; padding-bottom:30px; border-top-left-radius:5px; border-top-right-radius:5px;  }\r\n");
      out.write(".error-container h1{ font-size:16px; padding:12px 0; background:#0ae; color:#fff;} \r\n");
      out.write(".errorcon{ padding:35px 0; text-align:center; color:#0ae; font-size:18px;}\r\n");
      out.write(".errorcon i{ display:block; margin:12px auto; font-size:30px; }\r\n");
      out.write(".errorcon span{color:red;}\r\n");
      out.write("h4{ font-size:14px; color:#666;}\r\n");
      out.write("a{color:#0ae;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"no-skin\">\r\n");
      out.write("<div class=\"error-container\"> \r\n");
      out.write("    <h1> 汽车租赁系统-信息提示 </h1>   \r\n");
      out.write("    <div class=\"errorcon\">     \r\n");
      out.write("        <i class=\"icon-smile-o\"></i>对不起，您访问的页面不存在！！\r\n");
      out.write("   </div>\r\n");
      out.write("    <h4 class=\"smaller\" align=\"center\"><a href=\"user/validation.do\" target=\"_top\">返回首页</a></h4>\r\n");
      out.write("   \r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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