package com.calmkin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;

import java.util.List;

public interface PlaceService {
//    查询所有地点
     IPage<Place> selectByPage(int currPage, int pageSize);
//    添加新的地点
     void addPlace(Place place);
//    修改地点信息
     void changeSingle(Place place);
//    批量删除地点
     void deleteByIds(List<Integer> lis);

//    获取所有可以使用的核酸检测点
     List<Place> accessiblePlace();

     void updateNumOfSubs(String place);

}
