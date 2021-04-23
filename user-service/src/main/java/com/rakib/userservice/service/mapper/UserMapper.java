package com.rakib.userservice.service.mapper;

import com.rakib.userservice.entity.UserInfo;
import com.rakib.userservice.service.dto.UserDTO;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public static UserDTO entityToDto(UserInfo userInfo){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfo, userDTO);
        return userDTO;
    }

    public static UserInfo dtoToEntity(UserDTO userDto){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDto, userInfo);
        return userInfo;
    }

}
