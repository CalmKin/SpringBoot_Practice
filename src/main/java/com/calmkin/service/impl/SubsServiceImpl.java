package com.calmkin.service.impl;

import com.calmkin.mapper.PlaceMapper;
import com.calmkin.mapper.ResultMapper;
import com.calmkin.mapper.SubsMapper;
import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Result;
import com.calmkin.pojo.Subsc;
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
    public PageBean<Subsc> selectByPage(int currentPage, int pageSize) {

        int offset = (currentPage-1)*pageSize;

        List<Subsc> lis = subsMapper.selectAllSubs(offset,pageSize);

        int tot = subsMapper.selectTotalCount();

        PageBean<Subsc> pageBean = new PageBean<>(tot,lis);

        return pageBean;
    }
//    添加预约记录服务,同时根据预约记录添加检测结果记录
    @Override
    public void addSubs(Subsc subsc) {

        String userCardId = subsc.getCardID();

        Integer userId = userMapper.getUserId(userCardId);
//        先判断是否存在用户
//        如果不存在，那就抽取用户bean，进行插入用户操作
        if( userId == null )
        {
            userMapper.insertUser(subsc);
            userId =  userMapper.getUserId(userCardId);
        }
//      插入预约记录
        subsMapper.addSubscription(subsc);



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
        placeMapper.updateNumOfSubs(subsc.getSubPlace());
//        同时插入一条新的检测结果
        resultMapper.insertResult(result);


        /*此处需要提交事务*/
//        sqlSession.commit();

    }


}
