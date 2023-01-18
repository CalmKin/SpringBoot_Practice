package com.calmkin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Result {
    // 检测结果id
    private Integer resId;
    // 用户id
    @TableField(value = "user_id")
    private Integer userId;
    private String userName;
    // 检测时间
    @TableField(value = "time")
    private String checkTime;
    // 检测地点
    private String place;
    private String affected;
}
