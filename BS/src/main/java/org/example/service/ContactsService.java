package org.example.service;

import org.example.pojo.Contacts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.util.Result;
import org.springframework.stereotype.Service;


@Service
public interface ContactsService extends IService<Contacts> {
    Result show();

    Result add(Contacts contacts);

    Result updateContacts(Contacts contacts);

    Result delete(int id);
}