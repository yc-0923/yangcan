package cn.itcast.service;//mvc模式的一个接口


import cn.itcast.domain.Indent;

import java.util.List;

public interface IndentService {
    void addIndent(Indent indent);

    List<Indent> findAll(String username);

    void deleteIndent(String valueAt);

    void updateIndent(Indent indent);

    Indent findById(String valueAt);

    List<Indent> findAll();
}
