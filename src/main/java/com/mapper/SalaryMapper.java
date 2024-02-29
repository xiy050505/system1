package com.mapper;

import com.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryMapper {
    Salary selectCurrentSalary(@Param("username") String username, @Param("month") String month);


    List<Salary> selectAllByUsername(String username);
}
