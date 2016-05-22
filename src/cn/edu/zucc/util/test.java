package cn.edu.zucc.util;


import cn.edu.zucc.model.FileupdownBean;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;
import sun.security.util.Length;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shentao on 2016/5/18.
 */
public class test {
public static  void main(String[] args) throws IOException {

//
//    ApplicationContext wac  = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//    SessionFactory sf  = (SessionFactory)wac.getBean("sessionFactory");
//    Session session = sf.openSession();
//    List children = session.createQuery("from FileupdownBean ").list();
//    Iterator iterator = children.iterator();
//    while(iterator.hasNext()){
//        FileupdownBean userEntity = (FileupdownBean) iterator.next();
//        System.out.println(userEntity.getName());
//    }


    String s;

        s="test.txt.doc";

        String[]t=s.split("\\.");//字符分隔标志
        //输出起始用户名
        System.out.println("user name:"+t[0]);
        //判断,如果分隔符后面还有字符串,则继续进行输出
        if(t.length>1){
            System.out.println("format :"+t[t.length-1]);
        }else{
            System.out.println("null");
        }




    //System.out.println(new File("F:\\吃啥app-项目章程.txt.doc").getName().endsWith(".doc"));
}


}
