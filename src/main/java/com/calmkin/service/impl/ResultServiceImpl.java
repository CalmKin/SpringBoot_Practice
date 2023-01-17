package com.calmkin.service.impl;

import com.calmkin.mapper.ResultMapper;
import com.calmkin.pojo.Condition;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Result;
import com.calmkin.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//这个类相当于一个池子，集成了service接口的所有方法

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

//    分页条件查询
    @Override
    public PageBean<Result> selectByPageAndCondition(int begin, int pageSize, Condition condition) {
        /*因为like里面需要的是 %str%的形式，这里需要手动添加*/
        String userName = condition.getUserName();
        if(userName!=null &&userName.length()>0 )
        {
            condition.setUserName("%"+userName+"%");
        }
        List<Result> conditions = resultMapper.selectByPageAndCondition(begin,pageSize,condition);

        int totalCount= resultMapper.totalCountByCondition(condition);    //获取总的条目数

        PageBean<Result> pageBean = new PageBean<>(totalCount,conditions);

        return pageBean;
    }
//     用户个人检测记录查询
    @Override
    public List<Result> selectByCondition(String cardID,String userName) {

        List<Result> results = resultMapper.selectByCondition(cardID,userName);

        return results;

    }

}
