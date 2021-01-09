package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MangerSelf {



    UserService service=new UserServiceImpl();

    public MangerSelf(User user){


        JFrame frame=new JFrame("欢迎管理员："+user.getName());

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

        frame.add(ag);
        frame.add(age);
        frame.add(se);
        frame.add(sex);
        frame.add(phon);
        frame.add(phone);
        frame.add(emai);
        frame.add(email);
        frame.add(nam);
        frame.add(name);

        frame.add(username);
        frame.add(usernam);




        JButton updateBtn=new JButton("修改");
        JButton passwordBtn=new JButton("修改密码");
        updateBtn.setBounds(250,350,70,30);
        passwordBtn.setBounds(350,350,100,30);



        frame.add(updateBtn);
       frame.add(passwordBtn);

        frame.add(new JLabel());

        frame.setSize(700,500);
        frame.setLocation(600,300);
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        User user=new User();
        user.setUsername("18574795279");
        user.setPassword("666666");
        user.setName("杨灿");
        user.setEmail("1842772080@qq.com");
        new MangerSelf(user);
    }

}
