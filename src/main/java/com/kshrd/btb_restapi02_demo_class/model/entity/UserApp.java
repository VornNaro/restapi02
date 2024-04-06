package com.kshrd.btb_restapi02_demo_class.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserApp {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;
}
