package org.example.mysqlServer;

import org.example.pojo.Contacts;
import org.example.util.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class AddContacts {
    Connection connection= GetConnection.getConnect();
    public void add() throws SQLException {
        Contacts contacts =new Contacts();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入联系人的姓名：");
        contacts.setName(scanner.nextLine());
        System.out.print("请输入联系人的手机号：");
        contacts.setNumber(scanner.nextLine());
        System.out.print("请输入联系人的地址：");
        contacts.setAddress(scanner.nextLine());
        String sql="insert into phone set number=?,name=?,address=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, contacts.number);
        preparedStatement.setString(2, contacts.name);
        preparedStatement.setString(3, contacts.address);
        preparedStatement.execute();
        System.out.println("联系人添加成功");
    }
}