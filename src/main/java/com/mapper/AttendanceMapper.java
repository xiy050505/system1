package com.mapper;

import com.pojo.Attendance;
import org.apache.ibatis.annotations.Param;


public interface AttendanceMapper {
    Attendance attendanceSelect(@Param("username") String username,@Param("year") String year,@Param("month") String month);

    void updateTypeLate(@Param("late") String late,@Param("username") String username,@Param("year") String year,@Param("month") String month);
    void updateTypeEarly(@Param("early") String early,@Param("username") String username,@Param("year") String year,@Param("month") String month);
    void updateTypeAbsence(@Param("absence") String absence,@Param("username") String username,@Param("year") String year,@Param("month") String month);
    void updateTypeAfl(@Param("afl") String afl,@Param("username") String username,@Param("year") String year,@Param("month") String month);
}
