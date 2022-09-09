package com.example.repository.impl;

import com.example.model.Dictionary;
import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static List<Dictionary> dictionaryList;

    static {
        dictionaryList = new ArrayList<>();
        dictionaryList.add(new Dictionary("black", "màu đen"));
        dictionaryList.add(new Dictionary("red", "màu đỏ"));
        dictionaryList.add(new Dictionary("blue", "màu lam"));
        dictionaryList.add(new Dictionary("pink", "màu hồng"));
        dictionaryList.add(new Dictionary("yellow", "màu vàng"));
        dictionaryList.add(new Dictionary("green", "màu xanh lá"));
        dictionaryList.add(new Dictionary("orange", "màu cam"));
    }

    @Override
    public String search(String eng) {
        for (Dictionary dictionary : dictionaryList) {
            if (eng.toLowerCase().equals(dictionary.getEng())) {
                return dictionary.getVie();
            }
        }
        return "Not found!";
    }
}
