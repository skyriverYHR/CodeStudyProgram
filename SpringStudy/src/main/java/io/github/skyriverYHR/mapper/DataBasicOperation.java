package io.github.skyriverYHR.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础数据库操作接口 (BaseMapper)
 * @param <T> 实体类类型 (如 Camp)
 * @param <ID> 主键类型 (如 Integer)
 */
public interface DataBasicOperation<T, ID> { //T指代类型，ID主键关键字类型。 ID用于快速插叙修改，不用于复杂逻辑
    // 增加
    int insert(T entity);
    // 更新
    int update(T entity);
    //删除一条数据
    int delete(ID id);
    // 删除多条数据
    int deleteByIds(@Param("id") List<ID> id); //@Param 用于xml使用传入的id数据
}
