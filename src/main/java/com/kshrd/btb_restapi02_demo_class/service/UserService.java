package com.kshrd.btb_restapi02_demo_class.service;

import com.kshrd.btb_restapi02_demo_class.model.dto.UserDTO;
import com.kshrd.btb_restapi02_demo_class.model.entity.UserApp;
import com.kshrd.btb_restapi02_demo_class.model.request.UserRequest;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUser();
    Integer addNewUser(UserRequest userRequest);


}
