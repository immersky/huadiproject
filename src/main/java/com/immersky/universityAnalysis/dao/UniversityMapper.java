package com.immersky.universityAnalysis.dao;
import com.immersky.universityAnalysis.entity.University;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.entity.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UniversityMapper {

    List<University> select(@Param("university") University university, @Param("orderUtil") OrderUtil orderUtil, @Param("pageUtil") PageUtil pageUtil);
    University selectOne(@Param("university_id") Integer university_id);
    Integer selectTotal(@Param("university") University university);
}
