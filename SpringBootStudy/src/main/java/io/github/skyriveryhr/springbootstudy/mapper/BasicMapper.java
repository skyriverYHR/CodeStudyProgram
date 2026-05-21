package io.github.skyriveryhr.springbootstudy.mapper;

import java.util.List;

public interface BasicMapper<T,ID> {
    //增一条
    int insert(T t);
    //删一条
    int delete(ID id);
    //查一条
    T select(ID id);
    //查全部
    List<T> selectAll();
}
