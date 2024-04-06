package com.kshrd.btb_restapi02_demo_class.controller;

import com.kshrd.btb_restapi02_demo_class.model.dto.UserDTO;
import com.kshrd.btb_restapi02_demo_class.model.reponse.BaseApiResponse;
import com.kshrd.btb_restapi02_demo_class.model.request.UserRequest;
import com.kshrd.btb_restapi02_demo_class.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/test")
//    public String getMessage(){
//        return "Welcome BTB class";
//    }
//    @GetMapping("/testlogging")
//    public String testLogging(){
//        LOG.warn("This is a Warn log");
//        LOG.debug("This is a DEBUG log");
//        LOG.info("This is an INFO log");
//        LOG.error("This is an ERROR log");
//        return "Added some log output to console....";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer userId){

        BaseApiResponse<UserDTO> response = BaseApiResponse.<UserDTO>builder()
                .message("Get User By Id Success")
                .payload(userService.getUserById(userId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){
        BaseApiResponse<List<UserDTO>>response= BaseApiResponse.<List<UserDTO>> builder()
                .message("get User all")
                .payload(userService.getAllUser())
                .timestamp(new Timestamp((System.currentTimeMillis())))
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

    // Add new user
    @PostMapping("/addNewUser")
    public ResponseEntity<?> postUser(@RequestBody UserRequest userRequest){

        Integer storeIdNewUser = userService.addNewUser(userRequest);
        BaseApiResponse<UserDTO> response = BaseApiResponse.<UserDTO>builder()
                .message("Add new user success")
                .payload(userService.getUserById(storeIdNewUser))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);

    }




}
