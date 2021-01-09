package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao usd=new UserDao();
    @Override
    public List<User> findAll() {




        return usd.findAll();
    }

    @Override
    public void deleteUser(String username) {
        usd.deleteByUserName(username);
    }
    @Override
    public User findUserName(String username) {




        return  usd.findUserName(username);
    }

    @Override
    public User userCheck(User user) throws Exception {
        return usd.login(user);
    }

    @Override
    public void updateUser(User user) {


       usd.updateUser(user);
    }

    @Override
    public void updateUserPassword(User user) {

        usd.updateUserPassword(user);
    }


    public boolean active(String code) {

       User user= usd.findByCode(code);

       if(user!=null){
           usd.updateStatus(user);
           return true;
       }
        return false;
    }

    @Override
    public User mangerCheck(User manger) throws Exception {
        return usd.manger(manger);
    }

    @Override
    public void updateMangerPassword(User user) {
        usd.updateMangerPassword(user);
    }

    @Override
    public void updateManger(User user) {
        usd.updateManger(user);
    }

    @Override
    public List<User> findName(String name1) {
        return usd.findByName(name1);
    }

    @Override
    public void regist(User user) throws Exception {
        usd.register(user);
    }


}
