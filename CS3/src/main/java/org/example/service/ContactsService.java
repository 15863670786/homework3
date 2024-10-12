package org.example.service;

import org.example.pojo.Contacts;
import org.example.pojo.Contacts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


@Service
public interface ContactsService extends IService<Contacts> {
    void show();

    void add();

    void updateContacts();

    void delete();
}