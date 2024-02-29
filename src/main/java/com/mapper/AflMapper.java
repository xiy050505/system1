package com.mapper;

import com.pojo.Afl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AflMapper {

    void addAfl(Afl afl);

    List<Afl> selectAllByUsername(String username);

    List<Afl> selectAll();

    void updateByUsername(@Param("status") String status,@Param("username") String username,@Param("startTime") String startTime);

}
