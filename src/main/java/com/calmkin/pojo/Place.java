package com.calmkin.pojo;

import lombok.Data;

@Data
public class Place {
    private Integer id;
    private String placeName;
    private Integer subsNum;
//    该地点是否提供预约服务
     private Integer status;

}
