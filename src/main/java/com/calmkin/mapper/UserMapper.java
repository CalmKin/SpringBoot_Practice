package com.calmkin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.calmkin.pojo.Subsc;
import com.calmkin.pojo.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户id查询用户信息
     */
//    void insertUser(Subsc subsc);
//    根据身份证号判断寻找用户id,如果能找到，那就只插入预约记录，找不到，那就同时插入用户信息和预约记录
//    Integer getUserId(String cardID);

}
