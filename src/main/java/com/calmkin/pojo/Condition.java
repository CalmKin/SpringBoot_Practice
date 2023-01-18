package com.calmkin.pojo;

import lombok.Data;

//通过Lombok依赖，简化pojo开发
@Data
public class Condition {
    private String userName;
    private String status;
}
