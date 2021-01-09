package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MangerLogin {



 private JFrame frame=new JFrame("管理员登录");

 private JButton submit=new JButton("登录");

 private  JButton reset=new JButton("重置");

 private JLabel jLabeA=new JLabel("用户名：");

 private JLabel jLabeB=new JLabel("密码：");//用户名和密码的输入

 private JLabel jLabeC=new JLabel("管理员登录系统");

 private JLabel infoLab=new JLabel();

 private JTextField nameText=new JTextField();

 private JPasswordField passwordField=new JPasswordField();


 public MangerLogin(User user){
  Font fnt=new Font("Serief",Font.ITALIC+Font.BOLD,35);
  jLabeC.setFont(fnt);

  submit.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    if(e.getSource()==submit){
     String username=nameText.getText();
     String password=new String (passwordField.getPassword());
     User manger=new User();
     manger.setUsername(username);
     manger.setPassword(password);

     UserServiceImpl service=new UserServiceImpl();
     User user=null;
     try {
        user= service.mangerCheck(manger);
     } catch (Exception exception) {
      System.out.println("出错了");
     }

     if(user==null){
      infoLab.setText("用户名或密码错误");
     }else{

      infoLab.setText("登录成功");

      frame.setVisible(false);

      new Manger_Window(user);

     }

    }



   }
  });

  reset.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {

    if(e.getSource()==reset){


     nameText.setText("");
     passwordField.setText("");
     infoLab.setText("");

    }


   }
  });

  frame.setLayout(null);
  frame.addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
   frame.setVisible(false);
   }
  });
  jLabeA.setBounds(55,35,60,20);

  jLabeB.setBounds(68,60,60,20);

  frame.setLocation(500,600);
  infoLab.setBounds(120,135,220,30);

  nameText.setBounds(125,35,100,20);
  passwordField.setBounds(125,60,100,20);
  submit.setBounds(80,90,60,20);

  reset.setBounds(160,90,60,20);

  frame.setResizable(false);
  JLabel btna=new JLabel("欢迎管理员");
  btna.setBounds(145,0,160,20);
  frame.add(btna);
  frame.add(nameText);
  frame.add(passwordField);
  frame.add(infoLab);
  frame.add(jLabeA);
  frame.add(jLabeB);

  frame.add(jLabeC);

  frame.add(reset);
  frame.add(submit);
  frame.setSize(380,230);
  frame.setLocation(750,500);
  frame.setVisible(true);

 }


    public static void main(String[] args) {

    new MangerLogin(new User());

    }
}

















