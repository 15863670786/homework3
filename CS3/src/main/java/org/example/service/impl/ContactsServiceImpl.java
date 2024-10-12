package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.pojo.Contacts;
import org.example.service.ContactsService;
import org.example.mapper.ContactsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts>
        implements ContactsService{
    @Resource
    private ContactsMapper contactsMapper;
    @Override
    public void show() {
        List<Contacts> links;
        System.out.println("个人通讯录联系人信息如下:");
        links = contactsMapper.selectList(null);
        for (Contacts link1 : links) {
            System.out.print("编号："+ link1.getId()+"，");
            System.out.print("姓名："+ link1.getName()+"，");
            System.out.print("地址："+ link1.getAddress()+"，");
            System.out.println("电话号码："+ link1.getNumber()+"，");
        }
    }

    @Override
    public void add() {
        Contacts contacts=new Contacts();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入联系人的姓名：");
        contacts.setName(scanner.nextLine());
        System.out.print("请输入联系人的手机号：");
        contacts.setNumber(scanner.nextLine());
        System.out.print("请输入联系人的地址：");
        contacts.setAddress(scanner.nextLine());
        contactsMapper.insert(contacts);
        System.out.println("联系人添加成功");
    }

    @Override
    public void updateContacts() {
        Contacts contacts=new Contacts();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入要更改的联系人id：");
        contacts.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("请输入要更改的联系人姓名：");
        contacts.setName(scanner.nextLine());
        System.out.print("请输入要更改的联系人手机号：");
        contacts.setNumber(scanner.nextLine());
        System.out.print("请输入要更改的联系人地址：");
        contacts.setAddress(scanner.nextLine());
        contactsMapper.updateById(contacts);
        System.out.println("修改成功");
    }

    @Override
    public void delete() {
        int id;
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入联系人的id：");
        id=scanner.nextInt();
        contactsMapper.deleteById(id);
        System.out.println("联系人删除成功");
    }
}



