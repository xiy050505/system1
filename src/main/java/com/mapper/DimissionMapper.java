package com.mapper;

import com.pojo.Afl;
import com.pojo.Dimission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DimissionMapper {

    void addDimission(Dimission dimission);

    List<Dimission> selectAllByUsername(String username);

    List<Dimission> selectAll();

    void updateByUsername(@Param("status") String status, @Param("username") String username);

}
