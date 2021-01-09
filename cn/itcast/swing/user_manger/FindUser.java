package cn.itcast.swing.user_manger;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindUser {

    public FindUser(){
        JFrame frame=new JFrame("查找用户");

        JTextField findUserName=new JTextField();
        JButton find_btn=new JButton("检索");
        JLabel name_j=new JLabel("用户名");
        JLabel nam=new JLabel("");

        name_j.setBounds(400,20,50,20);
        findUserName.setBounds(450,20,100,20);
        find_btn.setBounds(550,20,60,20);




        frame.add(find_btn);

        frame.add(findUserName);

        frame.add(name_j);

        frame.add(nam);

        find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==find_btn){
                    String username=findUserName.getText();
                    System.out.println(username);
                    UserService service=new UserServiceImpl();
                    User list= (User) service.findUserName(username);

                    if(list!=null){


                    String [] titles={"用户名","密码","姓名","性别","年龄","电话","邮箱","删除"};


                    Object [][] user=new Object[1][20];

                        user[0][0]=list.getUsername();
                        user[0][1]=list.getPassword();
                        user[0][2]=list.getName();
                        user[0][3]=list.getSex();
                        user[0][4]=list.getAge();
                        user[0][5]=list.getPhone();
                        user[0][6]=list.getEmail();
                        user[0][7]=false;




                    JPanel panel=new JPanel();

                    JTable table =new JTable(user,titles);


                    JScrollPane scr=new JScrollPane(table);
                    frame.add(panel, BorderLayout.NORTH);

                    frame.add(scr,BorderLayout.CENTER);
                    frame.remove(find_btn);

                    find_btn.setBounds(500,500,60,30);


                    frame.setVisible(true);
                } else{
                        JLabel none=new JLabel("查无此人");
                        none.setFont(new Font("Serief",Font.BOLD,30));
                        none.setBounds(400,170,299,200);
                        frame.add(none);

                        frame.add(new JLabel(""));
                      frame.setVisible(true);
                    }

                }
            }
        });



        JTextField findName=new JTextField();
        JButton findbtn=new JButton("检索");
        JLabel name=new JLabel("姓名");

        name.setBounds(400,50,60,20);
        findName.setBounds(450,50,100,20);
        findbtn.setBounds(550,50,60,20);

        findbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==findbtn){
                    String name1=findName.getText();
                    System.out.println(name1);
                    UserService service=new UserServiceImpl();
                    List<User> list=   service.findName(name1);

                    if(list.size()>0){


                        String [] titles={"用户名","密码","姓名","性别","年龄","电话","邮箱","删除"};


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
                        JLabel userNumber=new JLabel("用户的数目："+list.size());
                        panel.add(userNumber);
                        JTable table =new JTable(user,titles);


                        JScrollPane scr=new JScrollPane(table);

                      frame.add(panel, BorderLayout.NORTH);

                        frame.add(scr,BorderLayout.CENTER);
                        frame.remove(findbtn);
                        find_btn.setBounds(500,500,60,30);



                        frame.remove(findbtn);
                        frame.remove(findName);
                        frame.remove(findUserName);
                        frame.remove(name);
                        frame.remove(find_btn);
                        frame.remove(name_j);


                        frame.setVisible(true);
                    } else{
                        JLabel none=new JLabel("查无此人");
                        none.setFont(new Font("Serief",Font.BOLD,30));
                        none.setBounds(400,170,299,200);
                        frame.add(none);


                        frame.add(new JLabel(""));
                        frame.setVisible(true);
                    }

                }
            }
        });



        frame.add(findbtn);

        frame.add(findName);

        frame.add(name);

        frame.add(nam);



        frame.setSize(1200,500);
        frame.setLocation(350,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FindUser();
    }
}
