package org.example.mysqlServer;

import org.example.util.GetConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteContacts {
    Connection connection= GetConnection.getConnect();
    public void delete() throws SQLException {
        int id;
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入联系人的id:");
        id=scanner.nextInt();
        String sql = "delete from phone where id="+id;
        Statement statement = connection.createStatement();
        statement.execute(sql);
        System.out.println("联系人删除成功");
    }
}