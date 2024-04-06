package com.kshrd.btb_restapi02_demo_class.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String address;

}
