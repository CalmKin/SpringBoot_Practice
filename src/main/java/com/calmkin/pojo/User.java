package com.calmkin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    private Integer id;
    @TableField(value = "card_id")
    private String cardID;
    private String tele;
    @TableField(value = "user_name")
    private String userName;
    private String addr;
}
