package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser {

    public RegisterUser(){
        JFrame frame=new JFrame("注册");
        UserService service=new UserServiceImpl();

        JLabel btna=new JLabel("欢迎注册小灿管理系统");
        btna.setBounds(245,0,160,20);
        frame.add(btna);
        JTextField username=new JTextField();
        JTextField email=new JTextField();
        JTextField name=new JTextField();
        JTextField phone =new JTextField();
        JTextField sex=new JTextField();
        JTextField age=new JTextField();
        JTextField password=new JTextField();


        JLabel usernam=new JLabel("用户名：");
        JLabel passwor=new JLabel("密码：");

        JLabel emai=new JLabel("邮箱：");
        JLabel nam=new JLabel("姓名：");
        JLabel phon =new JLabel("电话：");
        JLabel se=new JLabel("性别：");
        JLabel ag=new JLabel("年龄：");
        username.setBounds(250,60,150,20);

        usernam.setBounds(190,60,70,20);

        password.setBounds(250,85,150,20);

        passwor.setBounds(190,85,70,20);

        email.setBounds(250,110,150,20);
        emai.setBounds(190,110,70,20);


        name.setBounds(250,135,150,20);
        nam.setBounds(190,135,70,20);

        phone.setBounds(250,165,150,20);
        phon.setBounds(190,165,70,20);

        sex.setBounds(250,195,150,20);
        se.setBounds(190,195,70,20);
        age.setBounds(250,225,150,20);
        ag.setBounds(190,225,70,20);

        frame.add(ag);
        frame.add(age);
        frame.add(passwor);
        frame.add(password);
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



        JButton register=new JButton("注册");

        register.setBounds(285,250,70,30);


        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==register){
                    User user=new User();

                    UserService service=new UserServiceImpl();

                    user.setUsername(username.getText());
                    user.setPassword(password.getText());
                    user.setEmail(email.getText());
                    user.setName(name.getText());
                    user.setSex(sex.getText());
                    user.setAge(age.getText());
                    user.setPhone(phone.getText());

                    User user1= (User) service.findUserName(username.getText());


                    if(user1==null){
                        try {
                            service.regist(user);
                        } catch (Exception exception) {
                            System.out.println("出错了");
                        }
                    }else{

                        JLabel reregister=new JLabel("注册成功");

                        reregister.setBounds(260,300,100,30);
                        frame.add(reregister);
                        frame.add(new JLabel(""));

                        frame.setVisible(true);

                    }

                }
            }
        });


        frame.add(register);

        frame.add(new JLabel());

        frame.setSize(700,500);
        frame.setLocation(600,300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new RegisterUser();
    }
}
