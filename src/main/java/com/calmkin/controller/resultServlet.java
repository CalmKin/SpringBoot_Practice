package com.calmkin.controller;

import com.calmkin.pojo.*;
import com.calmkin.service.ResultService;
import com.calmkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/result")
public class resultServlet {
    @Autowired
    private ResultService resultService;
    @Autowired
    private UserService userService;
    //条件分页查询
    @GetMapping( "/selectByPageAndCondition"  )
    public PageBean<Result> selectByPageAndCondition(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestBody Condition condition)  {
        //因为是get方法传递的参数，是  begin=xxx ? pageSize=xxx 的形式，所以可以用getParameter方法获取
        //url里面的参数依然是用RequestParam来标记的，请求体里面的json数据是用RequestParam来标记的
        int begin = (currentPage-1)*pageSize;
        //调用service层,直接返回对象，SpringMVC会自动将对象转化为json数据
        PageBean<Result> pageBean = resultService.selectByPageAndCondition(begin, pageSize,condition);
        return pageBean;
    }
    //获取用户信息
    @RequestMapping("/selectUserById")
    public User selectUserById(@RequestParam("id") int id)  {
        User user = userService.selectAllById(id);
        return user;
    }

//    用户用身份证号查询核酸结果
@RequestMapping("/selectByCondition")
public List<Result> selectByCondition(@RequestBody Query query) {
        List<Result> results = resultService.selectByCondition(query.getCardID(),query.getUserName());
        return results;
    }

}

