package com.calmkin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlaceServiceTest {

    @Autowired
    private PlaceService placeService;
    @Test
    public void TestaddPlace()
    {
        Place place = new Place();
        place.setSubsNum(100);
        place.setPlaceName("家里蹲");
        place.setStatus(1);
        placeService.addPlace(place);
    }

    //    分页查询功能
//    @Test
//
//    public void TestdeleteByIds(List<Integer> ids) {
//        placeMapper.deleteBatchIds(ids);
//    }
//    @Test
//
//    public void TestchangeSingle(Place place) {
//        //会根据对象里面的id属性进行修改，会自动执行动态sql
//        placeMapper.updateById(place);
//    }
//    @Test
//
//    public IPage<Place> TestselectByPage(int currPage, int pageSize) {
//
//        IPage<Place> page = new Page<>(currPage,pageSize);
//
//        IPage<Place> placeIPage = placeMapper.selectPage(page, null);
//
//        System.out.println(placeIPage);
//
//        return placeIPage;
//
//    }
//
//    //修改单个地点的信息
//    @Test
//
//    public List<Place> TestaccessiblePlace() {
//
//        LambdaQueryWrapper<Place> qw = new LambdaQueryWrapper<Place>();
//
//        qw.eq(Place::getStatus,1);     //根据place里面的status条件来查询，找等于1的
//
//        qw.select(Place::getPlaceName,Place::getStatus);
//
//        List<Place> places = placeMapper.selectList(qw);
//
//        return places;
//    }
//
//    //修改当前地点的预约人数
//    @Test
//
//    public void TestupdateNumOfSubs(String place)
//    {
//        LambdaQueryWrapper<Place> qw = new LambdaQueryWrapper<>();
//
//        qw.eq(Place::getPlaceName,place);
//
//        Place place1 = placeMapper.selectOne(qw);
//
//        place1.setSubsNum(  place1.getSubsNum() + 1   );
//
//        changeSingle(place1);
//    }
}
