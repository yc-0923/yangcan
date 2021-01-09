package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser) throws Exception{

        String sql="Select * from user where username=? and password=?";

        User user=null;
        try{
            user =  template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            return null;
        }


    }

    public int register(User register) throws Exception{

        String sql="insert into user(username,password,email,name,phone,sex,age) values(?,?,?,?,?,?,?);";

        System.out.println("registerSql===="+sql);
        int flag =  template.update(sql ,register.getUsername(),register.getPassword(),register.getEmail(),register.getName()
        ,register.getPhone(),register.getSex(),register.getAge());

        return flag;
    }
    public User manger(User loginUser) throws Exception{

        String sql="Select * from manger where username=? and password=?";


        User user =  template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());

        return user;
    }
    public List<User> findAll(){

        String sql="select * from user";
        List<User> users= template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    public void deleteByUserName(String username){

        String sql="delete from user where username=?";
        template.update(sql,username);

    }


    public User findUserName(String username) {

        try{
        String sql="select * from user where username= ?";
       User user =  template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);


        return user;
        }
        catch (EmptyResultDataAccessException e ) {
            return null;
        }

    }

    public void updateUser(User user) {
        String sql="update user set username=?,password=? ,email=? ,name=? ,phone=? ,sex=? ,age =?where username=?";


        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getPhone(),user.getSex(),user.getAge(),
                user.getUsername());

    }

    public void updateUserPassword(User user) {
        String sql="update user set password=?where username=?";


        template.update(sql,user.getPassword(), user.getUsername());

    }

    public int findTotalCount() {
        String sql="select count(*) from user";
       return  template.queryForObject(sql,Integer.class);

    }

    public List<User> findByPage(int start, int rows) {
    String sql="select * from user limit ?,?";
   return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);


    }

    public int findTotalCount(String username, String name, String phone) {

        String str[] =new String [3];
        str[0]=username;
        str[1]=name;
        str[2]=phone;

        String sql="select count(*) from user where 1=1";

        for(int i=0;i<3;i++){
            if(str[i]!=null&&i==0&&(!"".equals(str[i]))){
                sql+="  and  "+" username "+"  like  '%"+str[i]+"%' ";
            }

            if(str[i]!=null&&i==1&&(!"".equals(str[i]))){
                sql+="  and  "+" name "+"  like  '%"+str[i]+"%' ";
            }


            if(str[i]!=null&&i==2&&(!"".equals(str[i]))){
                sql+="  and  "+" phone "+"  like  '%"+str[i]+"%' ";
            }
        }


        return  template.queryForObject(sql,Integer.class);




    }

    public List<User> findByPage(int start, int rows, String username, String name, String phone) {

        String str[] =new String [3];
        str[0]=username;
        str[1]=name;
        str[2]=phone;

        String sql="select * from user    where 1=1";

        for(int i=0;i<3;i++){
            if(str[i]!=null&&i==0&&(!"".equals(str[i]))){
                sql+="  and  "+" username "+"  like  '%"+str[i]+"%' ";
            }

            if(str[i]!=null&&i==1&&(!"".equals(str[i]))){
                sql+="  and  "+" name "+"  like  '%"+str[i]+"%' ";
            }


            if(str[i]!=null&&i==2&&(!"".equals(str[i]))){
                sql+="  and  "+" phone "+"  like  '%"+str[i]+"%' ";
            }
        }

        sql+=" limit ?,? ";


        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);


    }

    public User findByCode(String code) {

        try{
            String sql="select * from user where code= ?";
            User user =  template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);


            return user;
        }
        catch (EmptyResultDataAccessException e ) {
            return null;
        }



    }


    public void updateStatus(User user) {


        String sql="update user set status='Y' where username=?";


        template.update(sql ,user.getUsername());
    }

    public void updateMangerPassword(User user) {
        String sql="update manger set password=?where username=?";


        template.update(sql,user.getPassword(), user.getUsername());


    }

    public void updateManger(User user) {
        String sql="update manger set username=?,password=? ,email=? ,name=? ,phone=? ,sex=? ,age =?where username=?";


        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getPhone(),user.getSex(),user.getAge(),
                user.getUsername());

    }

    public List<User> findByName(String name1) {
        String sql="select * from user  where name  like '%"+name1+"%'  ORDER BY age DESC ";
        List<User> users= template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;

    }
}
