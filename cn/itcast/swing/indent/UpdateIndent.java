package cn.itcast.swing.indent;

import cn.itcast.domain.Indent;
import cn.itcast.domain.Product;
import cn.itcast.domain.User;
import cn.itcast.service.IndentService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.IndentServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.swing.user_manger.FindUser;
import cn.itcast.swing.user_manger.UserControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpdateIndent {
    JFrame frame = new JFrame("订单修改");

    public UpdateIndent(User user1) {


       IndentService service = new IndentServiceImpl();

        String[] titles = {"订单编号", "订单时间", "备注", "状态", "订单明细","删除"};

        List<Indent> list = service.findAll(user1.getUsername());

        Object[][] user = new Object[list.size()][20];
        for (int i = 0; i < list.size(); i++) {
            user[i][0] = list.get(i).getId();
            user[i][1] = list.get(i).getIdate();
            user[i][2] = list.get(i).getIdesc();
            if(("".equals(list.get(i).getStatus()))||(list.get(i).getStatus()==null)){
                user[i][3] ="受理中";
            }else{
                user[i][3] =list.get(i).getStatus();
            }

            user[i][4] = false;

            user[i][5] = false;



        }
        JPanel panel=new JPanel();
        JButton protectValue=new JButton("保存");

        JButton delete=new JButton("删除");
        JButton _indent=new JButton("订单");
        JButton reEnter=new JButton("刷新");
        JLabel userNumber=new JLabel("订单的数目："+list.size());
        panel.add(userNumber);

        JTable table = new JTable(user, titles);


        JScrollPane scr = new JScrollPane(table);

        reEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==reEnter){
                    frame.setVisible(false);
                    new UpdateIndent(user1);
                }
            }
        });
        protectValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==protectValue){
                    for(int i=0;i<table.getRowCount();i++){


                       Indent indent=new Indent();
                        indent.setId((String) table.getValueAt(i,0));

                        indent.setIdesc((String) table.getValueAt(i,2));



                        service.updateIndent(indent);
                    }


                }
            }
        });




        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==delete){
                    int flag=0;
                    for(int i=0;i<table.getRowCount();i++){
                        //System.out.println(table.getValueAt(i,7));
                        if(true == (boolean)table.getValueAt(i, 5)){

                            service.deleteIndent((String)table.getValueAt(i,0));
                            System.out.println((String)table.getValueAt(i,0));
                            frame.setVisible(false);
                            flag=1;

                        }
                    }
                    if(flag==1)new UpdateIndent(user1);
                }
            }
        });












        panel.add(protectValue);

        panel.add(delete);

        panel.add(_indent);

        panel.add(reEnter);

        frame.add(panel,BorderLayout.NORTH);

        frame.add(scr, BorderLayout.CENTER);






        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox("", false)));


        table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox("", false)));


        frame.setSize(1200, 500);
        frame.setLocation(350, 300);
        frame.setVisible(true);


    }

    public static void main(String[] args) {

        User user = new User();
        user.setUsername("18574795279");
        user.setPassword("666666");
        user.setName("李志辉");
        user.setEmail("1842772080@qq.com");
        new UpdateIndent(user);
    }
}