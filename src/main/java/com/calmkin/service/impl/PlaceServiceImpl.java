package com.calmkin.service.impl;

import com.calmkin.mapper.PlaceMapper;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;        /*这里会红线提示，*/

    // 添加新的检测点
    @Override
    public void addPlace(Place place)
    {
        placeMapper.insert(place);
    }

    //    分页查询功能
    @Override
    public void deleteByIds(List<Integer> ids) {
        placeMapper.deleteBatchIds(ids);
    }
    @Override
    public void changeSingle(Place place) {
        //会根据对象里面的id属性进行修改
        placeMapper.updateById(place);
    }
    @Override
    public PageBean<Place> selectByPage(int currPage, int pageSize) {

        int begin = (currPage-1)*pageSize;

        List<Place>  lis = placeMapper.selectAllPlaces(begin,pageSize);

        int tot = placeMapper.totalCount();

        PageBean<Place> pageBean  = new PageBean<>(tot,lis);

        return pageBean;

    }

//修改单个地点的信息

    @Override
    public List<String> accessiblePlace() {
        List<String> strings = placeMapper.accessiblePlace();
        return strings;
    }
}
