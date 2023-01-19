package com.calmkin;

import com.calmkin.service.ResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResultServiceTest {

    @Autowired
    private ResultService resultService;

    @Test
    public void selectByCondition()
    {
        System.out.println(resultService.selectByCondition("364751238945627841","赵六"));
    }

}
