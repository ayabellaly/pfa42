package com.example.cabinetdentistspring.services;

import com.example.cabinetdentistspring.DTO.UserDto;
import com.example.cabinetdentistspring.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}