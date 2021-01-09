package cn.itcast.swing.indent;

import cn.itcast.domain.Indent;
import cn.itcast.domain.User;
import cn.itcast.service.IndentService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.IndentServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.user_manger.FindUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindIndent {

    public FindIndent(){
        JFrame frame=new JFrame("订单查找");

        JTextField findUserName=new JTextField();
        JButton find_btn=new JButton("检索");
        JLabel name_j=new JLabel("订单编号");
        JLabel nam=new JLabel("");

        name_j.setBounds(400,20,90,20);
        findUserName.setBounds(450,20,100,20);
        find_btn.setBounds(550,20,60,20);


        find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==find_btn){
                    if (e.getSource() == find_btn) {
                        String username = findUserName.getText();


                        IndentService service=new IndentServiceImpl();
                        String[] titles = {"订单编号", "订单时间", "备注", "状态"};

                        Indent list = service.findById(username);

                        if(list!=null){


                        System.out.println(list);
                        Object[][] user = new Object[1][20];

                        user[0][0] = list.getId();
                        user[0][1] = list.getIdate();
                        user[0][2] = list.getIdesc();
                        if (("".equals(list.getStatus())) || (list.getStatus() == null)) {
                            user[0][3] = "受理中";
                        } else {
                            user[0][3] = list.getStatus();
                        }


                        JPanel panel = new JPanel();
                        JButton protectValue = new JButton("保存");


                        JButton reEnter = new JButton("刷新");


                        JTable table = new JTable(user, titles);


                        JScrollPane scr = new JScrollPane(table);

                        frame.add(panel, BorderLayout.NORTH);

                        frame.add(scr,BorderLayout.CENTER);
                        frame.remove(find_btn);
                        frame.remove(findUserName);
                        frame.setVisible(true);
                    }else {
                            JLabel none=new JLabel("没有该订单");
                            none.setFont(new Font("Serief",Font.BOLD,30));
                            none.setBounds(400,170,299,200);
                            frame.add(none);


                            frame.add(new JLabel(""));
                            frame.setVisible(true);
                        }
                    }

                    }
            }
        });


        frame.add(find_btn);

        frame.add(findUserName);

        frame.add(name_j);

        frame.add(nam);


         frame.setSize(1200, 500);
        frame.setLocation(350, 300);
        frame.setVisible(true);



    }



    public static void main(String[] args) {
        new FindIndent();
    }
}
