package com.codegym.repository.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "English", 10, true, "no"));
        emailList.add(new Email(2, "Vietnamese", 15, false, "no"));
        emailList.add(new Email(3, "Chinese", 25, true, "no"));
        emailList.add(new Email(4, "Japanese", 50, false, "no"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }

    @Override
    public void update(Email email) {
        for (Email item : emailList) {
            if (email.getId() == item.getId()) {
                emailList.remove(item);
                emailList.add(email);
                break;
            }
        }
    }

    @Override
    public Email findById(int id) {
        for (Email items : emailList) {
            if (items.getId() == id) {
                return items;
            }
        }

        return null;
    }

    @Override
    public List<String> findLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Chinese");
        languageList.add("Japanese");
        return languageList;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
