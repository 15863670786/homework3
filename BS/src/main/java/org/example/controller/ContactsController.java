package org.example.controller;

import jakarta.annotation.Resource;
import org.example.pojo.Contacts;
import org.example.pojo.Contacts;
import org.example.service.ContactsService;
import org.example.util.Result;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("phone")
public class ContactsController {
    @Resource
    private ContactsService contactsService;
    @PostMapping("show")
    public Result show(){
        Result result=contactsService.show();
        return result;
    }
    @PostMapping("add")
    public Result add(@RequestBody Contacts contacts){
        Result result=contactsService.add(contacts);
        return result;
    }
    @PostMapping("update")
    public Result update(@RequestBody Contacts contacts){
        Result result=contactsService.updateContacts(contacts);
        return result;
    }
    @PostMapping("delete")
    public Result delete(@RequestParam int id){
        Result result=contactsService.delete(id);
        return result;
    }
}