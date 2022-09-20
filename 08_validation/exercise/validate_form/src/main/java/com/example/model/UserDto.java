package com.example.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "Tên không được để trống.")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5, tối đa 45 ký tự.")
    private String firstName;

    @NotBlank(message = "Tên không được để trống.")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5, tối đa 45 ký tự.")
    private String lastName;

    @NotBlank(message = "SĐT không được để trống.")
    @Pattern(regexp = "^0\\d{9}$", message = "SĐT phải có 10 số, và bắt đầu bằng số 0.")
    private String phoneNumber;

    @NotBlank(message = "Tuổi không được để trống.")
    @Pattern(regexp = "^1[89]|[2-7]\\d|80$", message = "Tuổi phải từ 18-80.")
//    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18.")
    private String age;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$",
            message = "Email phải đúng định dạng.")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
    }
}
