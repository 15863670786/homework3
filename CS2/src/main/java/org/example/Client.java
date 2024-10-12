package org.example;


import org.example.mysqlServer.AddContacts;
import org.example.mysqlServer.DeleteContacts;
import org.example.mysqlServer.ShowContacts;
import org.example.mysqlServer.UpdateContacts;

import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        int choose;
        while(true){
            System.out.println("###########欢迎来到个人通讯录系统###########");
            System.out.println("1:查看联系人，2：添加，3：更改，4：删除");
            System.out.print("请输入操作编号:");
            choose=scanner.nextInt();
            switch (choose){
                case 1->new ShowContacts().show();
                case 2->new AddContacts().add();
                case 3->new UpdateContacts().update();
                case 4->new DeleteContacts().delete();
            }
        }
    }
}