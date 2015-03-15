package com.mycompany.app;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;

import java.util.List;

public class SignGuestbookServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

  String entry = req.getParameter("entry");   
  
  Connection conn = null;
      try {
          String CLOUDSQL_IP     = System.getProperty("CLOUDSQL_IP");
          String CLOUDSQL_USERID = System.getProperty("CLOUDSQL_USERID");
          String CLOUDSQL_PWD    = System.getProperty("CLOUDSQL_PWD");
          conn = DriverManager.getConnection("jdbc:mysql://" + CLOUDSQL_IP + "/guestbook",CLOUDSQL_USERID, CLOUDSQL_PWD);
          String statement = "INSERT INTO entries (entry) VALUES( ? )";
          PreparedStatement stmt = conn.prepareStatement(statement);
          stmt.setString(1, entry);
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
