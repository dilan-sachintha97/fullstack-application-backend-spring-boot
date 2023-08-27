package com.code.fullstack.backend.service;

import com.code.fullstack.backend.dto.request.RequestUserDTO;
import com.code.fullstack.backend.dto.response.ResponseUserDTO;

import java.util.List;

public interface UserService {

    ResponseUserDTO saveUser(RequestUserDTO userDTO);

    List<ResponseUserDTO> getAllUsers();

    ResponseUserDTO getUser(long id);

    ResponseUserDTO updateUser(RequestUserDTO userDTO, long id);

    ResponseUserDTO deleteUser(long id);
}

