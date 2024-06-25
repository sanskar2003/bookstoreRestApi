package com.sanskar.project.bookstore.services;

import com.sanskar.project.bookstore.dto.UserDTO;
import com.sanskar.project.bookstore.entity.UserEntity;
import com.sanskar.project.bookstore.exception.ResourceNotFoundException;
import com.sanskar.project.bookstore.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public UserService(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    public UserDTO saveUser(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepo.save(userEntity);
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserDTO getUserById(Long user_id){
        UserEntity userEntity = userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException(STR."User doesn't exist with id: \{user_id}"));
        return modelMapper.map(userEntity, UserDTO.class);
    }
}
