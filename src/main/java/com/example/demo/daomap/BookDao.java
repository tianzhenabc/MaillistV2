package com.example.demo.daomap;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.LinkMan;

import java.util.Collection;
import java.util.Map;

public class BookDao {
    private static Map<Integer, LinkMan> BooksDao=null;

    static {

        BooksDao.put(1,new LinkMan(1,"李三",1,"111111","111111@qq.com","北京"));
        BooksDao.put(2,new LinkMan(2,"王五",0,"222222","222222@qq.com","上海"));
        BooksDao.put(3,new LinkMan(3,"哈哈",1,"333333","333333@qq.com","河南"));
        BooksDao.put(4,new LinkMan(4,"达达",0,"444444","444444@qq.com","河北"));
    }

    public Collection<LinkMan> getBooks(){
        return BooksDao.values();
    }

    //通过id得到用户信息
    public LinkMan getBookById(Integer id){
        return BooksDao.get(1);
    }
}
