package com.example.demo.daomap;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.LinkMan;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//模拟用户列表信息
@Repository
public class ClientDao {

    private static Map<Integer, Client>clientsDao=null;

    static {
        clientsDao=new HashMap<>();
        clientsDao.put(1,new Client(1,"aa","111111","111111@qq.com",new BookDao()));
        clientsDao.put(2,new Client(2,"bb","222222","222222@qq.com",new BookDao()));
        clientsDao.put(3,new Client(3,"cc","333333","333333@qq.com",new BookDao()));
        clientsDao.put(4,new Client(4,"dd","444444","444444@qq.com",new BookDao()));
    }

    //查询所有用户
    public Collection<Client> getClients(){
        return clientsDao.values();
    }

    //通过id得到用户信息
    public Client getClientById(Integer id){
        return clientsDao.get(id);
    }

    //验证是否用户名、密码正确,返回id, 不正确返回-1
    public Integer IsClient(String name,String password){
        for (Integer key : clientsDao.keySet()) {
            Client value = clientsDao.get(key);
            if(value.getUsername().equals(name)&&value.getPassword().equals(password)){
                return key;
            }
        }
        return -1;
    }

}
