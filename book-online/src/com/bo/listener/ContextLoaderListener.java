package com.bo.listener;

import com.bo.entity.Book;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 邵琪
 * @ClassName ContextLoaderListener
 * @Description 上下文加载监听，在服务器启动的时候即刻生效，用来生成用户数据和图书数据
 * @Date 2019/10/3
 * @Version 1.0
 **/

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * @Description 容器初始化方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列表
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "111@qq.com", "698d51a19d8a121ce581499d7b701668", "肉丸", "user111.jpg", "江苏南京", LocalDate.of(2000, 2, 28)),
                new User(2, "222@qq.com", "698d51a19d8a121ce581499d7b701668", "包子", "user11.jpg", "浙江杭州", LocalDate.of(1999, 2, 12)),
                new User(3, "333@qq.com", "698d51a19d8a121ce581499d7b701668", "馒头", "user22.jpg", "湖北武汉", LocalDate.of(2000, 3, 17))
        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1,"见识","1.jpg","吴军"),
                new Book(2,"茶花女","2.png","小仲马"),
                new Book(3,"活着","3.jpg","余华"),
                new Book(4,"羊皮卷","4.jpg","奥格·曼狄诺"),
                new Book(5,"朱自清经典","5.jpg","桑楚"),
                new Book(6,"见识","1.jpg","吴军"),
                new Book(7,"茶花女","2.png","小仲马"),
                new Book(8,"活着","3.jpg","余华"),
                new Book(9,"羊皮卷","4.jpg","奥格·曼狄诺"),
                new Book(10,"朱自清经典","5.jpg","桑楚"),
                new Book(11,"见识","1.jpg","吴军"),
                new Book(12,"茶花女","2.png","小仲马")

        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("bookList", bookList);
    }

    /**
     * 销毁方法
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}
