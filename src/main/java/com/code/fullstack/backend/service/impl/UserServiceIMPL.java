package com.code.fullstack.backend.service.impl;
import com.code.fullstack.backend.dto.request.RequestUserDTO;
import com.code.fullstack.backend.dto.response.ResponseUserDTO;
import com.code.fullstack.backend.entity.User;
import com.code.fullstack.backend.exception.UserNotFoundException;
import com.code.fullstack.backend.repo.UserRepo;
import com.code.fullstack.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ResponseUserDTO> getAllUsers() {
        ArrayList<ResponseUserDTO> userDTOS = new ArrayList<>();

        for (User user : userRepo.findAll()) {
            ResponseUserDTO responseUserDTO = new ResponseUserDTO(
                    user.getId(),
                    user.getName(),
                    user.getUsername(),
                    user.getEmail()
            );
            userDTOS.add(responseUserDTO);
        }

        return userDTOS;
    }

    @Override
    public ResponseUserDTO getUser(long id) {
        User user = userRepo.findById(id).orElse(null);
        if (null == user) {
            throw new UserNotFoundException(id);
        }
        return new ResponseUserDTO(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail()
        );
    }

    @Override
    public ResponseUserDTO updateUser(RequestUserDTO userDTO, long id) {
        User user = userRepo.findById(id).orElse(null);
        if (null == user) {
            throw new UserNotFoundException(id);
        }

        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        User save = userRepo.save(user);

        return new ResponseUserDTO(
                save.getId(), save.getName(), save.getUsername(), save.getEmail()
        );

    }

    @Override
    public String deleteUser(long id) {

        if (!userRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
         userRepo.deleteById(id);
        return "User with DI "+id+" has been deleted";
    }
}