package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserControl {

    JFrame frame=new JFrame("用户管理");
    public UserControl(){


        UserService service=new UserServiceImpl();

        String [] titles={"用户名","密码","姓名","性别","年龄","电话","邮箱","删除"};

        List<User> list=service.findAll();

       Object [][] user=new Object[list.size()][20];
       for(int i=0;i<list.size();i++){
           user[i][0]=list.get(i).getUsername();
           user[i][1]=list.get(i).getPassword();
           user[i][2]=list.get(i).getName();
           user[i][3]=list.get(i).getSex();
           user[i][4]=list.get(i).getAge();
           user[i][5]=list.get(i).getPhone();
           user[i][6]=list.get(i).getEmail();
           user[i][7]=false;



       }
       JPanel panel=new JPanel();
       JButton protectValue=new JButton("保存");

        JButton delete=new JButton("删除");
        JButton find=new JButton("查找");

        JLabel userNumber=new JLabel("用户的数目："+list.size());
        panel.add(userNumber);
        JTable table =new JTable(user,titles);



       JScrollPane scr=new JScrollPane(table);
       frame.add(panel, BorderLayout.NORTH);

       frame.add(scr,BorderLayout.CENTER);

        protectValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==protectValue){
                    for(int i=0;i<table.getRowCount();i++){


                            User user=new User();

                        user.setUsername((String) table.getValueAt(i,0));
                        user.setPassword((String) table.getValueAt(i,1));
                        user.setName((String) table.getValueAt(i,2));
                        user.setSex((String) table.getValueAt(i,3));
                        user.setAge((String) table.getValueAt(i,4));
                        user.setPhone((String) table.getValueAt(i,5));
                        user.setEmail((String) table.getValueAt(i,6));


                      service.updateUser(user);
                    }


                }
            }
        });



        table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor( new JCheckBox("",false)));



        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==delete){
                    for(int i=0;i<table.getRowCount();i++){
                        //System.out.println(table.getValueAt(i,7));
                        if(true == (boolean)table.getValueAt(i, 7)){

                            service.deleteUser((String)table.getValueAt(i,0));
                          frame.setVisible(false);

                        }
                    }new UserControl();
                }
            }
        });
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==find){

                  new FindUser();




                }
            }
        });
        panel.add(protectValue);

        panel.add(delete);

        panel.add(find);




        frame.setSize(1200,500);
        frame.setLocation(350,300);
        frame.setVisible(true);



    }

    public static void main(String[] args) {

        User user=new User();
        user.setUsername("18574795279");
        user.setPassword("666666");
        user.setName("杨灿");
        user.setEmail("1842772080@qq.com");
        new UserControl();
    }


}
