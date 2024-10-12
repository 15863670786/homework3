package org.example.mysqlServer;

import org.example.pojo.Contacts;
import org.example.util.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class UpdateContacts {
    Connection connection= GetConnection.getConnect();
    public void update() throws SQLException {
        Contacts contacts =new Contacts();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入要更改的联系人id：");
        contacts.setId(scanner.nextLine());
        System.out.print("请输入要更改的联系人姓名：");
        contacts.setName(scanner.nextLine());
        System.out.print("请输入要更改的联系人手机号：");
        contacts.setNumber(scanner.nextLine());
        System.out.print("请输入要更改的联系人地址：");
        contacts.setAddress(scanner.nextLine());
        String sql="update phone set number=?,name=?,address=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, contacts.getNumber());
        preparedStatement.setString(2, contacts.getName());
        preparedStatement.setString(3, contacts.getAddress());
        preparedStatement.setString(4, contacts.getId());
        preparedStatement.execute();
        System.out.println("修改成功");
    }
}