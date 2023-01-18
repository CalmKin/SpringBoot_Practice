package com.calmkin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.calmkin.pojo.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PlaceMapper extends BaseMapper<Place> {        //TODO 这里一定要继承BaseMapper这个接口，否则就没法自动生成sql的函数
}
