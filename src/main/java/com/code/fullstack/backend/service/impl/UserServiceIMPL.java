package com.code.fullstack.backend.service.impl;
import com.code.fullstack.backend.dto.request.RequestUserDTO;
import com.code.fullstack.backend.dto.response.ResponseUserDTO;
import com.code.fullstack.backend.entity.User;
import com.code.fullstack.backend.repo.UserRepo;
import com.code.fullstack.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseUserDTO saveUser(RequestUserDTO userDTO) {
        User user = new User(
                1,
                userDTO.getUsername(),
                userDTO.getName(),
                userDTO.getEmail()
        );

        User saveUser = userRepo.save(user);

        ResponseUserDTO responseUserDTO = new ResponseUserDTO(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getUsername(),
                saveUser.getEmail()
        );
        return responseUserDTO;
    }
}
