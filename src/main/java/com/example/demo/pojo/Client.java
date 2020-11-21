package com.example.demo.pojo;

import com.example.demo.daomap.BookDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//用户

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private BookDao links;
}
