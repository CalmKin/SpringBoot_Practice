package com.calmkin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.calmkin.pojo.Condition;
import com.calmkin.pojo.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

public interface ResultMapper extends BaseMapper<Result> {
    /*
    * 分页条件查询（根据用户的姓名和）
    * */
    @ResultMap("resultResultMap")
    List<Result> selectByPageAndCondition(@Param("begin") int begin,@Param("pageSize") int pageSize,@Param("condition") Condition condition);
    /*
    * 条件查询条目数量
    * */

    int totalCountByCondition(@Param("condition") Condition condition);

//    根据用户填写的身份证号和姓名进行查询
    @ResultMap("resultResultMap")
    List<Result> selectByCondition(@Param("cardID") String cardID,@Param("name") String name);

//    @Insert(" insert into result(id,user_id,time,place,affected) " +
//            "values (null,#{result.userId},#{result.checkTime},#{result.place},#{result.affected})")
//    void insertResult(@Param("result") Result result);

}
