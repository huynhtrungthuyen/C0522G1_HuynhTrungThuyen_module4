package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;

    @NotBlank(message = "Tên bài hát không được để trống.")
    @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String name;

    @NotBlank(message = "Tên nghệ sĩ không được để trống.")
    @Size(max = 300, message = "Tên nghệ sĩ không được quá 300 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên nghệ sĩ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String singer;

    @NotBlank(message = "Tên thể loại không được để trống.")
    @Size(max = 1000, message = "Tên thể loại không được quá 1000 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$", message = "Tên thể loại không chứa các kí tự đặc biệt (ngoại trừ dấu ',').")
    private String category;

    @NotBlank(message = "Link nhạc không được để trống.")
    private String file;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
    }
}