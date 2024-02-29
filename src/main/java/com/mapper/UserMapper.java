package com.mapper;

import com.pojo.User;
import com.pojo.EInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

     User mselect(User user);

     User eselect(User user);

     void register(@Param("username") String username, @Param("password") String password,@Param("status") String status);

     User selectByUsername(String username);

     void updateByUsername(@Param("status") String status,@Param("username") String username);

     EInformation eSelectByUsername(String username);

     List<EInformation> selectAll();

     void updateInformation(EInformation eI);

     void addInformation(EInformation eI);

     void deleteByUsername(String username);

     List<EInformation> select(EInformation eI);
}
