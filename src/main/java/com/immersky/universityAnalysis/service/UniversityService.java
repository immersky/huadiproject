package com.immersky.universityAnalysis.service;
import com.immersky.universityAnalysis.entity.University;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.entity.University;

import java.util.List;

public interface UniversityService {


    List<University> getList(University university, OrderUtil orderUtil, PageUtil pageUtil);
    University get(Integer university_id);
    Integer getTotal(University university);
}
