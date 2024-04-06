package com.kshrd.btb_restapi02_demo_class.service.imp;

import com.kshrd.btb_restapi02_demo_class.exception.FieldEmptyException;
import com.kshrd.btb_restapi02_demo_class.exception.UserNotFoundException;
import com.kshrd.btb_restapi02_demo_class.mapper.UserMapper;
import com.kshrd.btb_restapi02_demo_class.model.dto.UserDTO;
import com.kshrd.btb_restapi02_demo_class.model.entity.UserApp;
import com.kshrd.btb_restapi02_demo_class.model.request.UserRequest;
import com.kshrd.btb_restapi02_demo_class.repository.UserRepository;
import com.kshrd.btb_restapi02_demo_class.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserDTO userDTO = new UserDTO();
    UserApp userApp = new UserApp();

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(Integer userId) {

        if (userRepository.findUserById(userId) != null){
            userApp = userRepository.findUserById(userId);
            userDTO = userMapper.toUserDTO(userApp);
            return userDTO;
        }else throw new UserNotFoundException(userId);

    }

    @Override
    public List<UserDTO> getAllUser() {
        // create new object with arrayList
        List<UserApp> userApps = new ArrayList<>();
        List<UserDTO> userDTOS = new ArrayList<>();

        // Mapping data between userApp and UserDto
        userApps = userRepository.findAllUser();
        userDTOS = userMapper.toUserDTOs(userApps);

        return userDTOS;
    }

    @Override
    public Integer addNewUser(UserRequest userRequest) {

        if (userRequest.getName().isBlank() || userRequest.getName().contains("string")){
            throw new FieldEmptyException("UserName can not empty");
        }
        if (userRequest.getEmail().isBlank() || userRequest.getEmail().contains("string")){
            throw new FieldEmptyException("Email can not empty");
        }
        if (userRequest.getPassword().isBlank() || userRequest.getPassword().contains("string")){
            throw new FieldEmptyException("Password can not empty");
        }
        if (userRequest.getAddress().isBlank() || userRequest.getAddress().contains("string")){
            throw new FieldEmptyException("Address can not empty");
        }
            Integer storeUserId = userRepository.saveUser(userRequest);
            if (storeUserId != null){
                return storeUserId;
            }

        return null;
    }
}
