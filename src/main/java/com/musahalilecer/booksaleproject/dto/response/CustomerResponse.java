package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerResponse {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerResponse(Integer id, String email, String phone, String surname, String name, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.address = address;
    }

    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
}
