package test.cn.itcast.swing.user_manger; 

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
//import org.junit.Test;
//import org.junit.Before; 
//import org.junit.After;

import java.util.List;

/** 
* Manger_Window Tester. 
* 
* @author <Authors name> 
* @since <pre>1�� 6, 2021</pre> 
* @version 1.0 
*/ 
public class Manger_WindowTest { 



/** 
* 
* Method: main(String[] args) 
* 
*/ 
//@Test
public void testMain() throws Exception { 
List<User> list=new UserDao().findAll();
    System.out.println(list);
} 


} 
