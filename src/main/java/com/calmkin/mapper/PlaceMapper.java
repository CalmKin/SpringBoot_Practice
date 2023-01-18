package com.calmkin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.calmkin.pojo.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PlaceMapper extends BaseMapper<Place> {        //TODO 这里一定要继承BaseMapper这个接口，否则就没法自动生成sql的函数

    // 修改当前地点的预约人数
//    @Update("update place set subs_num = subs_num+1 where place_name = #{place}")
//    void updateNumOfSubs(String place);


    //分页查询功能
//    @Select("select * from place limit #{begin},#{pageSize}")
//    List<Place> selectAllPlaces(@Param("begin") int begin,@Param("pageSize") int pageSize);

    //选择所有的可以使用的核酸检测点
//    @ResultMap("placeResultMap")
//    @Select("select place_name,status from place where status=1")
//    List<String> accessiblePlace();



    //修改功能
//    void updatePlace(Place place);

    //批量删除地点
//    void deleteByIds(@Param("ids") int[] ids);


}
