package ua.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqa.aqa.addressbook.model.GroupData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

  @Test
  public void testDbConnection(){
    Connection conn=null;
    try{
      conn= DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=");
      Statement st= conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
      Groups groups=new Groups();
      while (rs.next()){
        groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(groups);
    }
    catch (SQLException ex){
      System.out.println("SQL Exception "+ex.getMessage());
      System.out.println("SQL State "+ex.getSQLState());
      System.out.println("Vendor error "+ex.getErrorCode());


    }





  }

}
