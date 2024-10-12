package org.example.controller;

import jakarta.annotation.Resource;
import org.example.service.ContactsService;
import org.springframework.stereotype.Controller;


@Controller
public class ContactsController {
    @Resource
    private ContactsService contactsService;
    public void controller(int choose){
        switch (choose){
            case 1-> contactsService.show();
            case 2->contactsService.add();
            case 3->contactsService.updateContacts();
            case 4->contactsService.delete();
        }
    }
}