package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;

import cn.itcast.service.impl.UserServiceImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class UserLogin   {








    private JFrame frame=new JFrame("用户登录");

 private JButton submit=new JButton("登录");

 private  JButton reset=new JButton("重置");

 private JLabel jLabeA=new JLabel("用户名：");

 private JLabel jLabeB=new JLabel("密码：");//用户名和密码的输入
private JLabel checkCode=new JLabel("验证码");//验证码

    private JTextField checkCodeText=new JTextField();//验证码的输入

 private JLabel jLabeC=new JLabel("用户登录系统");

 private JLabel infoLab=new JLabel();

 private JTextField nameText=new JTextField();

 private JPasswordField passwordField=new JPasswordField();






 public UserLogin(){










     Font fnt=new Font("Serief",Font.ITALIC+Font.BOLD,35);
  jLabeC.setFont(fnt);


  submit.addActionListener(new ActionListener( ) {
   @Override
   public void actionPerformed(ActionEvent e ) {
    if(e.getSource()==submit){

     String username=nameText.getText();
     String password=new String (passwordField.getPassword());
     User user=new User();
     user.setUsername(username);
     user.setPassword(password);

     UserServiceImpl service=new UserServiceImpl();



     User user1=null;
     try {
        user1= service.userCheck(user);
     } catch (Exception exception) {
      System.out.println("出错了");
     }

     if(user1==null){
      infoLab.setText("用户名或密码错误");
     }else{

      infoLab.setText("登录成功");

      frame.setVisible(false);
        user=new UserServiceImpl().findUserName(user.getUsername());
        //System.out.println("登录ok");
      new User_Window(user);
     }

    }

    }





  });
  reset.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {


     nameText.setText("");
     passwordField.setText("");
     infoLab.setText("");




   }
  });

  frame.setResizable(false);
  frame.setLayout(null);
  frame.addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
    frame.setVisible(false);
   }
  });
  jLabeA.setBounds(55,35,60,20);

  jLabeB.setBounds(68,60,60,20);

  infoLab.setBounds(120,145,220,30);

  nameText.setBounds(125,35,100,20);
  passwordField.setBounds(125,60,100,20);

  checkCode.setBounds(55,85,60,20);

     checkCodeText.setBounds(125,85,40,20);
  submit.setBounds(80,130,60,20);
JButton login=new JButton("注册");
login.setBounds(200,130,60,20);
  reset.setBounds(140,130,60,20);

  frame.setLocation(750,500);

  JLabel btna=new JLabel("欢迎用户");
  btna.setBounds(145,0,160,20);

  login.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    if(e.getSource()==login){

        frame.setVisible(false);
     new RegisterUser();
    }
   }
  });
  frame.add(btna);
  frame.add(nameText);
  frame.add(login);
  frame.add(passwordField);
  frame.add(infoLab);
  frame.add(jLabeA);
  frame.add(jLabeB);
  frame.add(jLabeC);

  frame.add(reset);
  frame.add(submit);

  frame.setSize(380,230);
  frame.setVisible(true);

 }


    public static void main(String[] args) {

    new UserLogin();

    }
}

















