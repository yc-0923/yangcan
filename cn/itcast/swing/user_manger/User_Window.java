package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.Window;
import cn.itcast.swing.indent.AddIndent;
import cn.itcast.swing.indent.FindIndent;
import cn.itcast.swing.indent.UpdateIndent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Window {
    private JFrame frame=new JFrame("客户订单管理系统");

    public User_Window(User user){

        JMenu indentAdd=new JMenu("订单添加");

        JMenuItem indent_Add=new JMenuItem("订单添加");

        indent_Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == indent_Add) {

                    frame.setVisible(false);
                    new AddIndent(user);
                }
            }
        });
        indentAdd.add(indent_Add);
        JMenu indentAlter=new JMenu("订单修改");
        JMenuItem indent_Alter=new JMenuItem("订单修改");

        indent_Alter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == indent_Alter) {

                    new UpdateIndent(user);
                }
            }
        });

        indentAlter.add(indent_Alter);
        JMenu indentFind=new JMenu("订单查询");
        JMenuItem indent_Find=new JMenuItem("订单查询");

        indentFind.add(indent_Find);

        indent_Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == indent_Find) {

                    new FindIndent();
                }
            }
        });
        JMenu userSelf=new JMenu("用户个人中心");

        JMenuItem user_Self=new JMenuItem("用户个人中心");


        JMenuItem user_exit=new JMenuItem("退出登录");

        user_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == user_exit) {
                    frame.dispose();
                    new Window();
                }
            }
        });
        userSelf.add(user_Self);
        userSelf.add(user_exit);
        JMenu about=new JMenu("关于");




        user_Self.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==user_Self){

                    UserService service=new UserServiceImpl();
                   User user1=  service.findUserName(user.getUsername());
                    new UserSelf(user1);
                }
            }
        });




        JMenuBar menuBar=new JMenuBar();


        menuBar.add(indentAdd);
        menuBar.add(indentAlter);
        menuBar.add(indentFind);
        menuBar.add(userSelf);
        menuBar.add(about);


        frame.setJMenuBar(menuBar);


        frame.setVisible(true);

        frame.setSize(700,600);


        frame.setLocation(600,300);






    }

    public static void main(String[] args) {

        new User_Window(new User());
    }

}
