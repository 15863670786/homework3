package org.example.mysqlServer;

import org.example.pojo.Contacts;
import org.example.util.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ShowContacts {
    Connection connection= GetConnection.getConnect();
    public void show() throws SQLException {
        String sql="select * from phone";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        List<Contacts> links =new ArrayList<>();
        while(resultSet.next()){
            Contacts contacts =new Contacts();
            contacts.setAddress(resultSet.getString("address"));
            contacts.setName(resultSet.getString("name"));
            contacts.setNumber(resultSet.getString("number"));
            contacts.setId(resultSet.getString("id"));
            links.add(contacts);
        }
        System.out.println("个人通讯录联系人信息如下:");
        for (Contacts link1 : links) {
            System.out.print("编号："+ link1.id+"，");
            System.out.print("姓名："+ link1.name+"，");
            System.out.print("地址："+ link1.address+"，");
            System.out.println("电话号码："+ link1.number+"，");
        }
        System.out.println("");
    }
}