package com.code.fullstack.backend.controller;
import com.code.fullstack.backend.dto.request.RequestUserDTO;
import com.code.fullstack.backend.dto.response.ResponseUserDTO;
import com.code.fullstack.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save-user")
    public ResponseUserDTO saveUser(@RequestBody RequestUserDTO userDTO){
       return userService.saveUser(userDTO);
    }

    @GetMapping(value = "/all-users")
    public List<ResponseUserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public ResponseUserDTO getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseUserDTO updateUser(@RequestBody RequestUserDTO userDTO, @PathVariable long id){
        return userService.updateUser(userDTO,id);
    }


}
