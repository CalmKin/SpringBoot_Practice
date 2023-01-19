package com.calmkin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Subsc;
import com.calmkin.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subs")
public class SubscServlet {
    @Autowired
    private SubsService service;
    @RequestMapping("/selectByPage")
    public  IPage<Subsc> selectByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int  pageSize)  {
        IPage<Subsc> pageBean = service.selectByPage(currentPage, pageSize);
        return pageBean;
    }
    @RequestMapping("/addSubs")
    public String addSubs(@RequestBody Subsc subsc)  {
        service.addSubs(subsc);
        return "success";
    }


}
