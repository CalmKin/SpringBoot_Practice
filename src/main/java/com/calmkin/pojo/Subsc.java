package com.calmkin.pojo;

import lombok.Data;

//用户的预约信息展示，和数据库里面的预约信息不完全相同，用于
@Data
public class Subsc {
     private  String userName;
     private  String tele;
     private  String cardID;
     private  String home;
     private  String subPlace;
     private  String subTime;
}
