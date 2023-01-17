package com.calmkin.controller;

import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController     /*RestController整合了responsebody和Controller*/
@RequestMapping("/place")
public class placeServlet implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    private PlaceService service;
    //分页查询所有核酸检测地点
//    返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖==@ResponseBody==注解和==@EnableWebMvc==注解
    @RequestMapping("/selectAllByPage")
    public PageBean<Place> selectAllByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize)  {
        PageBean<Place>  pageBean= service.selectByPage(currentPage,pageSize);
        return pageBean;
    }

    //添加新的地点
    //使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    @RequestMapping("/addPlace")
    public String addPlace(@RequestBody Place place)  {
        service.addPlace(place);
        //返回纯文本数据，提示前端添加成功
        return "success";
    }

    //修改单个地点的信息
    @RequestMapping("/changePlace")
    public String changePlace(@RequestBody Place place) {
        service.changeSingle(place);
        return "success";
    }

//    批量删除地点信息
    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestBody int [] lis) {
        service.deleteByIds(lis);
        return "success";
    }
    @RequestMapping("/initPlaces")
    public List<String> initPlaces()  {
        List<String> lis = service.accessiblePlace();
        return lis;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println(applicationContext.getBean(SubscServlet.class));
    }
}
