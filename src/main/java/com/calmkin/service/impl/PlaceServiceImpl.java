package com.calmkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        //会根据对象里面的id属性进行修改，会自动执行动态sql
        placeMapper.updateById(place);
    }

    @Override
    public IPage<Place> selectByPage(int currPage, int pageSize) {

        IPage<Place> page = new Page<>(currPage,pageSize);

        IPage<Place> placeIPage = placeMapper.selectPage(page, null);

        System.out.println(placeIPage);

        return placeIPage;

    }

    //修改单个地点的信息
    @Override
    public List<Place> accessiblePlace() {

        LambdaQueryWrapper<Place> qw = new LambdaQueryWrapper<Place>();

        qw.eq(Place::getStatus,1);     //根据place里面的status条件来查询，找等于1的

        qw.select(Place::getPlaceName,Place::getStatus);

        List<Place> places = placeMapper.selectList(qw);

        return places;
    }

    //修改当前地点的预约人数
    @Override
    public void updateNumOfSubs(String place)
    {
        LambdaQueryWrapper<Place> qw = new LambdaQueryWrapper<>();

        qw.eq(Place::getPlaceName,place);

        Place place1 = placeMapper.selectOne(qw);

        place1.setSubsNum(  place1.getSubsNum() + 1   );

        changeSingle(place1);
    }

}
