package org.example;

import jakarta.annotation.PostConstruct;
import org.example.controller.ContactsController;
import org.example.pojo.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Client {
    @Autowired
    private ContactsController contactsController;
    public static void main(String[] args){
        SpringApplication.run(Client.class,args);
    }

    @PostConstruct
    public void run(){
        Scanner scanner=new Scanner(System.in);
        int choose;
        while(true){
            System.out.println("###########欢迎来到个人通讯录系统###########");
            System.out.println("1:查看联系人，2：添加，3：更改，4：删除");
            System.out.print("请输入操作编号:");
            choose=scanner.nextInt();
            contactsController.controller(choose);
        }
    }
}