package cn.itcast.swing;

import cn.itcast.domain.User;
import cn.itcast.swing.user_manger.MangerLogin;
import cn.itcast.swing.user_manger.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    private JFrame frame=new JFrame("客户订单管理系统");

   public Window(){

       JMenu menu=new JMenu("关于");
       JMenuItem userContorl =new JMenuItem("软件介绍");

       JMenuItem indentContorl=new JMenuItem("帮助");


       JButton userLogin=new JButton("用户");

       userLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getSource()==userLogin){
                   new UserLogin();
                   frame.dispose();
               }
           }
       });


       menu.add(userContorl);

       menu.add(indentContorl);

       JMenuBar menuBar=new JMenuBar();


       menuBar.add(menu);

       userLogin.setBounds(200,200,100,30);
	   frame.getContentPane().add(userLogin);
       frame.setJMenuBar(menuBar);
       frame.getContentPane().add(new JLabel(("")));


       frame.setVisible(true);

       frame.setSize(700,600);


       frame.setLocation(600,300);

   }

    public static void main(String[] args) {

        new Window();
    }


}