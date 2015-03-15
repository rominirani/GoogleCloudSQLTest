package com.mycompany.app;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class ClearGuestbookServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

Connection conn = null;
      try {
           String CLOUDSQL_IP     = System.getProperty("CLOUDSQL_IP");
           String CLOUDSQL_USERID = System.getProperty("CLOUDSQL_USERID");
           String CLOUDSQL_PWD    = System.getProperty("CLOUDSQL_PWD");
           conn = DriverManager.getConnection("jdbc:mysql://" + CLOUDSQL_IP + "/guestbook",CLOUDSQL_USERID, CLOUDSQL_PWD);
           String statement = "DELETE from entries";
           PreparedStatement stmt = conn.prepareStatement(statement);
           stmt.executeUpdate();
         }
         catch (Exception e) { 
           System.out.println(e.getMessage());
         }
         finally {
           try { 
              if (conn != null) conn.close();
           } catch (Exception e) {}
         } 
  resp.sendRedirect("index.jsp");
}
}
