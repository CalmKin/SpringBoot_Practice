package com.calmkin.pojo;

import lombok.Data;

@Data
public class Result {
    // 检测结果id
    private Integer resId;
    // 用户id
    private Integer userId;
    private String userName;
    // 检测时间
    private String checkTime;
    // 检测地点
    private String place;
    private String affected;
}
