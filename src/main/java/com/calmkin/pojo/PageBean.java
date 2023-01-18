package com.calmkin.pojo;

import lombok.Data;

import java.util.List;
@Data
public class PageBean <T>{      //因为后面可能不止做Brand类型的分页查询，所以定义为自定义泛型，传什么参数就new什么对象
    private int totalCount;
    private List<T> lis;
}
