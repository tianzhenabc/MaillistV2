package com.example.demo.daomap;

import com.example.demo.pojo.LinkMan;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookDao {

    private Map<Integer, LinkMan> BooksDao=null;
    private Integer initId=5;//主键
    public BookDao(){
        BooksDao=new HashMap<>();
        BooksDao.put(1,new LinkMan(1,"李三",1,"111111","111111@qq.com","北京"));
        BooksDao.put(2,new LinkMan(2,"王五",0,"222222","222222@qq.com","上海"));
        BooksDao.put(3,new LinkMan(3,"哈哈",1,"333333","333333@qq.com","河南"));
        BooksDao.put(4,new LinkMan(4,"达达",0,"444444","444444@qq.com","河北"));

    }

    //增加一个联系人
    public void save(LinkMan one){
        if(one.getId()==null){
            one.setId(initId++);
        }
        BooksDao.put(one.getId(),one);
    }

    //查询全部联系人
    public Collection<LinkMan> getBooks(){
        return BooksDao.values();
    }

    //通过id查询联系人
    public LinkMan getLinkById(Integer id){
        return BooksDao.get(id);
    }

    //通过id 删除联系人
    public void deleteLinkById(Integer id){
        BooksDao.remove(id);
    }



}
