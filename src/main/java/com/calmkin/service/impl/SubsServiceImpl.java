package com.calmkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.calmkin.mapper.PlaceMapper;
import com.calmkin.mapper.ResultMapper;
import com.calmkin.mapper.SubsMapper;
import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.*;
import com.calmkin.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class SubsServiceImpl implements SubsService {
    @Autowired
    private SubsMapper subsMapper;
    @Autowired
    private    UserMapper userMapper;
    @Autowired
    private    PlaceMapper placeMapper;
    @Autowired
    private    ResultMapper resultMapper;
    //    分页查询服务
    @Override
    public IPage<Subsc> selectByPage(int currentPage, int pageSize) {

        IPage<Subsc> page = new Page<>(currentPage,pageSize);

        IPage<Subsc> page1 = subsMapper.selectPage(page, null);

        return page1;
    }
//    添加预约记录服务,同时根据预约记录添加检测结果记录
    @Override
    public void addSubs(Subsc subsc) {

        String userCardId = subsc.getCardID();

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();

        lqw.eq(User::getCardID,userCardId);
        lqw.select(User::getId);

        User user = userMapper.selectOne(lqw);
        Integer userId = user.getId();
//        先判断是否存在用户
//        如果不存在，那就抽取用户bean，进行插入用户操作
        if( user.getId() == null )
        {
            User tmp_user = new User(subsc.getCardID(),subsc.getTele(),subsc.getUserName(),subsc.getHome());
            userMapper.insert(tmp_user);

            LambdaQueryWrapper<User> lqw2 = new LambdaQueryWrapper<>();
            lqw2.select(User::getId);
            lqw2.eq(User::getCardID,tmp_user.getCardID());
            User user1 = userMapper.selectOne(lqw2);
            userId = user1.getId();
        }

//      插入预约记录
        subsMapper.insert(subsc);

        /*生成随机结果*/
        String[] randomResult = {"阴性","阴性","阴性","阳性","阳性","阴性","阴性","阴性","阴性","阳性"};
        Random random = new Random();
        int pick = random.nextInt(10);
        Result result = new Result();
        result.setUserName(subsc.getUserName());
        result.setPlace(subsc.getSubPlace());
        result.setCheckTime(subsc.getSubTime());
        result.setUserId(userId);
        result.setAffected(randomResult[pick]);

        //      更新检测点的预约情况,人数加一
        LambdaQueryWrapper<Place> lqw2 = new LambdaQueryWrapper<>();
        lqw2.eq(Place::getPlaceName,subsc.getSubPlace());
        //先获取当前预约地点的对象，方便后面做修改操作
        Place place = placeMapper.selectOne(lqw2);
        //更新地点预约人数信息
        place.setSubsNum(place.getSubsNum()+1);
        //找到地名等于指定地名的记录进行修改操作
        placeMapper.update(place,lqw2);
        //同时插入一条新的检测结果
        resultMapper.insert(result);
    }

}
