package com.kshrd.btb_restapi02_demo_class.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO{
    private String userName;
    private String userEmail;
    private String userAddress;
}
