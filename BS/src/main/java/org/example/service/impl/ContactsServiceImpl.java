package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.mapper.ContactsMapper;
import org.example.pojo.Contacts;
import org.example.pojo.Contacts;
import org.example.service.ContactsService;
import org.example.mapper.ContactsMapper;
import org.example.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts>
        implements ContactsService{
    @Resource
    private ContactsMapper contactsMapper;
    @Override
    public Result show() {
        List<Contacts> links = contactsMapper.selectList(null);
        return Result.ok(links);
    }

    @Override
    public Result add(Contacts contacts) {
        contacts.setId(null);
        contactsMapper.insert(contacts);
        return Result.ok(null);
    }

    @Override
    public Result updateContacts(Contacts contacts) {
        contactsMapper.updateById(contacts);
        return Result.ok(null);
    }

    @Override
    public Result delete(int id) {
        contactsMapper.deleteById(id);
        return Result.ok(null);
    }
}



