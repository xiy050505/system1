package com.mapper;

import com.pojo.Avatar;

import java.util.List;

public interface AvatarMapper {
    Avatar selectByUsername(String username);
}
