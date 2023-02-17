package com.immersky.universityAnalysis.dao;

import com.immersky.universityAnalysis.entity.Grade;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {


    List<Grade> select_r(@Param("grade") Grade grade, @Param("orderUtil") OrderUtil orderUtil, @Param("pageUtil") PageUtil pageUtil);
    Integer selectTotal_r(@Param("grade") Grade grade);


    List<Grade> select_s(@Param("grade") Grade grade, @Param("orderUtil") OrderUtil orderUtil, @Param("pageUtil") PageUtil pageUtil);
    Integer selectTotal_s(@Param("grade") Grade grade);
}
