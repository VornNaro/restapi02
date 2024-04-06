package com.kshrd.btb_restapi02_demo_class.mapper;

import com.kshrd.btb_restapi02_demo_class.model.dto.UserDTO;
import com.kshrd.btb_restapi02_demo_class.model.entity.UserApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    @Mapping(source ="name" , target ="userName" )
    @Mapping(source ="email" , target ="userEmail" )
    @Mapping(source ="address" , target ="userAddress" )
    UserDTO toUserDTO(UserApp userApp);
    List<UserDTO> toUserDTOs(List<UserApp> userApps);

}
