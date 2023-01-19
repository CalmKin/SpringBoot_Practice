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

    public User(String cardID,String tele,String userName,String addr)
    {
        this.setCardID(cardID);
        this.setTele(tele);
        this.setUserName(userName);
        this.setAddr(addr);
    }

}
