package com.nihao.mapper;

import com.nihao.entity.IdRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IdMapper {
    @Insert("insert into id_table (key_name, index_num) value (#{key}, #{index})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    Long insert(IdRecord idRecord);

    @Results({
            @Result(property="key",column="key_name"),
            @Result(property="index",column="index_num")
    })
    @Select("select * from id_table where key_name = #{key}")
    IdRecord get(String key);

    @Results({
            @Result(property="key",column="key_name"),
            @Result(property="index",column="index_num")
    })
    @Select("select * from id_table")
    List<IdRecord> getAll();

    @Update("update id_table set index_num = #{index} where id = #{id} and key_name = #{key}")
    Long update(IdRecord idRecord);

    @Update("update id_table set index_num = index_num + #{pageSize} where key_name = #{key}")
    Long increase(@Param("key") String key, @Param("pageSize") Integer pageSize);
}
