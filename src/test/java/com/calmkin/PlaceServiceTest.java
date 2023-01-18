package com.calmkin;

import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlaceServiceTest {

    @Autowired
    private PlaceService placeService;

    @Test
    public void AccessiblePlace()
    {
        System.out.println(placeService.accessiblePlace());
    }
    @Test
    public void TestselectByPage() {
        PageBean<Place> pageBean = placeService.selectByPage(1, 5);
        System.out.println(pageBean.getLis());
    }
}
