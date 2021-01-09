package cn.itcast.service.impl;

import cn.itcast.dao.IndentDao;
import cn.itcast.domain.Indent;
import cn.itcast.service.IndentService;

import java.util.List;

public class IndentServiceImpl implements IndentService {

    IndentDao indentDao=new IndentDao();
    @Override
    public void addIndent(Indent indent) {

        indentDao.addIndent(indent);
    }

    @Override
    public List<Indent> findAll(String username) {
        return indentDao.findAll(username);
    }

    @Override
    public void deleteIndent(String valueAt) {

        indentDao.deleteIndent( valueAt);
    }

    @Override
    public void updateIndent(Indent indent) {


        indentDao.updateIndent(indent);
    }


    public Indent findById(String valueAt) {
       return indentDao.findById(valueAt);
    }

    @Override
    public List<Indent> findAll() {
        return indentDao.findAll();
    }
}
