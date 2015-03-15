package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=container>\n");
      out.write("      <h1>Simple Guestbook</h1>\n");
      out.write("      <div class=\"panel panel-default\">\n");
      out.write("        <div class=\"panel-heading\">\n");
      out.write("          <h3 class=\"panel-title\">New Entry</h3>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"panel-body\">\n");
      out.write("          <form role=\"form\" action=\"add\" method=post>\n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                <textarea class=\"form-control\" name=\"entry\" id=\"entry\" rows=\"3\"></textarea>\n");
      out.write("              </div>\n");
      out.write("              <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <ul class=\"list-group\">\n");
      out.write("      ");

      Connection conn = null;
      try {
           String CLOUDSQL_IP     = System.getProperty("CLOUDSQL_IP");
           String CLOUDSQL_USERID = System.getProperty("CLOUDSQL_USERID");
           String CLOUDSQL_PWD    = System.getProperty("CLOUDSQL_PWD");
           conn = DriverManager.getConnection("jdbc:mysql://" + CLOUDSQL_IP + "/guestbook",CLOUDSQL_USERID, CLOUDSQL_PWD);
          ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM entries");
          while (rs.next()) {
             String entry = rs.getString("entry");
      
      out.write("\n");
      out.write("        <li class=\"list-group-item\" class=entry>");
      out.print(entry);
      out.write("</li>\n");
      out.write("        ");
 
        }
         }
         catch (Exception e) { 
            out.println(e.getMessage());
         }
         finally {
               try { 
                  if (conn != null) conn.close();
               } catch (Exception e) {}
         } 
        
      out.write("\n");
      out.write("      </ul>\n");
      out.write("      <form role=form action=\"clear\" method=post>\n");
      out.write("        <button type=\"submit\" class=\"btn btn-danger\">Clear Entries</button>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
