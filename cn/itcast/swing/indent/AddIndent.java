package cn.itcast.swing.indent;

import cn.itcast.domain.Indent;
import cn.itcast.domain.User;
import cn.itcast.service.IndentService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.IndentServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.user_manger.RegisterUser;
import cn.itcast.swing.user_manger.User_Window;
import cn.itcast.util.UuidUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class AddIndent {
    public AddIndent(User user){
        JFrame frame=new JFrame("添加订单");
        UserService service=new UserServiceImpl();

        JLabel btna=new JLabel("欢迎");
        btna.setBounds(320,0,160,20);
        frame.add(btna);
        JTextField s_Id=new JTextField();
        JTextField s_Date=new JTextField();
        JTextArea s_desc=new JTextArea(3,10);


        JLabel id=new JLabel("订单编号：");
        s_Id.setText(UuidUtil.getUuid());
        JLabel date=new JLabel("下单时间：");

        s_Date.setText(new SimpleDateFormat("yyyy-MM-dd- HH-hh-mm").format(new Date()));

        JLabel desc=new JLabel("备注信息：");

        s_Id.setBounds(250,60,250,20);

        id.setBounds(190,60,170,20);

        s_Date.setBounds(250,85,250,20);

        date.setBounds(190,85,70,20);

        s_desc.setBounds(250,110,250,200);
        desc.setBounds(190,180,70,20);




        frame.add(s_Date);
        frame.add(s_desc);
        frame.add(s_Id);
        frame.add(id);
        frame.add(date);
        frame.add(desc);



        JButton submit=new JButton("提交");

          JButton reset=new JButton("重置");

        submit.setBounds(300,350,70,30);
        reset.setBounds(375,350,70,30);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit){

                    Indent indent=new Indent();
                    indent.setIdate(s_Date.getText());
                    indent.setId(s_Id.getText());
                    indent.setIdesc(s_desc.getText());
                    indent.setCid(user.getUsername());

                    System.out.println(s_Date.getText());
                    System.out.println(s_Id.getText());
                    System.out.println(s_desc.getText());

                    IndentService indentService=  new IndentServiceImpl();
                    if(s_Id.getText()!=null){
                        indent.setCid(user.getUsername());
                        System.out.println(user.getUsername());
                        indentService.addIndent(indent);
                    }


                    frame.setVisible(false);
                    new User_Window(user);






                }
            }
        });


        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                s_Date.setText("");
                s_desc.setText("");
                s_Id.setText("");




            }
        });


        frame.add(submit);

        frame.add(reset);
        frame.add(new JLabel());

        frame.setSize(700,500);
        frame.setLocation(600,300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new AddIndent(new User());
    }
}
