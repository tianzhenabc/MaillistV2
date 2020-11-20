package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//联系人
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkMan {
    private Integer id;
    private String name;
    private Integer gender; //0女；1男
    private String Tel;
    private String email;
    private String address;

}
