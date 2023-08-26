package com.code.fullstack.backend.service;

import com.code.fullstack.backend.dto.request.RequestUserDTO;
import com.code.fullstack.backend.dto.response.ResponseUserDTO;

public interface UserService {

    ResponseUserDTO saveUser(RequestUserDTO userDTO);
}
