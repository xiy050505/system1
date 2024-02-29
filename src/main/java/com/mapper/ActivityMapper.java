package com.mapper;

import com.pojo.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {

    List<Activity> selectAll();

    Integer selectByName(String name);

    Activity selectByNameActivity(String name);

    Activity selectByNameAndUsername(@Param("username") String username, @Param("name") String name);

    void addAttendMenu(@Param("username") String username,@Param("name") String name);

    void updateByName(Activity activity);

    List<Activity> select(Activity activity);

    void addAll(Activity activity);
}
