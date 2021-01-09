package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSelf {



    UserService service=new UserServiceImpl();

    public UserSelf(User user){


        JFrame frame=new JFrame("欢迎用户："+user.getName());

        JLabel username=new JLabel(user.getUsername());
        JLabel email=new JLabel(user.getEmail());
        JLabel name=new JLabel(user.getName());
        JLabel phone =new JLabel(user.getPhone());
        JLabel sex=new JLabel(user.getSex());
        JLabel age=new JLabel(user.getAge());


        JLabel usernam=new JLabel("用户名：");

        JLabel emai=new JLabel("邮箱：");
        JLabel nam=new JLabel("姓名：");
        JLabel phon =new JLabel("电话：");
        JLabel se=new JLabel("性别：");
        JLabel ag=new JLabel("年龄：");
       username.setBounds(250,30,150,20);

        usernam.setBounds(190,30,70,20);

        email.setBounds(250,60,150,20);
        emai.setBounds(190,60,70,20);


        name.setBounds(250,90,150,20);
        nam.setBounds(190,90,70,20);

        phone.setBounds(250,120,150,20);
        phon.setBounds(190,120,70,20);

        sex.setBounds(250,150,150,20);
        se.setBounds(190,150,70,20);
        age.setBounds(250,180,150,20);
        ag.setBounds(190,180,70,20);


        frame.getContentPane().add(ag);
        frame.getContentPane().add(age);
        frame.getContentPane().add(se);
        frame.getContentPane().add(sex);
        frame.getContentPane().add(phon);
        frame.getContentPane().add(phone);
        frame.getContentPane().add(emai);
        frame.getContentPane().add(email);
        frame.getContentPane().add(nam);
        frame.getContentPane().add(name);

        frame.getContentPane().add(username);
        frame.getContentPane().add(usernam);
        frame.getContentPane().add(new JLabel());


        frame.setSize(700,500);
        frame.setLocation(600,300);
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        User user=new User();
        user.setEmail("faf");
        user.setPassword("fas;f");
        user.setUsername(";dsf");
        user.setPhone("q43ef");
        user.setName("杨灿");
        new UserSelf(user);
    }



}
