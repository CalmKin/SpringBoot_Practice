package com.calmkin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

//用户的预约信息展示，和数据库里面的预约信息不完全相同，用于
@Data
public class Subsc {
     @TableField(value = "user_name")
     private  String userName;
     private  String tele;
     @TableField(value = "card_id")
     private  String cardID;
     private  String home;
     @TableField(value = "place_name")
     private  String subPlace;
     @TableField(value = "book_time")
     private  String subTime;
}
