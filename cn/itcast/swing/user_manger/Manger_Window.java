package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.Window;
import cn.itcast.swing.indent.IndentManger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.Window;
import cn.itcast.swing.indent.IndentManger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manger_Window {
    private JFrame frame=new JFrame("客户订单管理系统");

    public Manger_Window(User user){

        JMenu user_Menu=new JMenu("用户管理");

        JMenu indent_Menu=new JMenu("订单管理");

        JMenuItem indentMenu=new JMenuItem("订单管理");

        indent_Menu.add(indentMenu);
        JMenu loginMenu=new JMenu("管理员个人中心");
        indentMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==indentMenu){

                    new IndentManger(user);
                }
            }
        });
        JMenuItem login_Menu=new JMenuItem("管理员个人中心");
        JMenuItem login_exit=new JMenuItem("退出登录");
        JMenuItem user_Item=new JMenuItem("用户管理");

        user_Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==user_Item){

                    new UserControl();
                }
            }
        });
        user_Menu.add(user_Item);
        loginMenu.add(login_Menu);
        loginMenu.add(login_exit);


        JMenu about=new JMenu("关于");


        login_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==login_exit){
                    frame.dispose();
                    new Window();

                }
            }
        });

        login_Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==login_Menu){
                    UserService userService=new UserServiceImpl();

                    try {
                        new MangerSelf(userService.mangerCheck(user));
                    } catch (Exception exception) {
                        System.out.println("出错了");
                    }
                }
            }
        });





        JMenuBar menuBar=new JMenuBar();


        menuBar.add(user_Menu);
        menuBar.add(indent_Menu);
        menuBar.add(loginMenu);
        menuBar.add(about);


        frame.setJMenuBar(menuBar);


        frame.setVisible(true);

        frame.setSize(700,600);


        frame.setLocation(600,300);






    }

    public static void main(String[] args) {

        new Manger_Window(new User());
    }

}
