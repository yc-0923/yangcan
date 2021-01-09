package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAll();

    public void deleteUser(String username);

    public User findUserName(String username);

    public User userCheck(User user) throws Exception;

    public void updateUser(User user);
public void updateUserPassword(User user);
    boolean active(String code);

    User mangerCheck(User manger) throws Exception;

    void updateMangerPassword(User user);

    void updateManger(User user);

    List<User> findName(String name1);

    void regist(User user) throws Exception;
}

