package com.calmkin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Subsc;

public interface SubsService {
//    获取所有的预约记录
    public IPage<Subsc> selectByPage(int currentPage, int pageSize);

//    新增预约记录
    public void addSubs(Subsc subsc);
}
