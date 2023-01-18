package com.calmkin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

//TODO 修改Place的字段映射
@Data
public class Place {
    private Integer id;
    @TableField(value = "place_name")
    private String placeName;
    @TableField(value = "subs_num")
    private Integer subsNum;
    private Integer status;

}
