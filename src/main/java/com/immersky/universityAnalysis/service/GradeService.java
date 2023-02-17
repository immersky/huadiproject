package com.immersky.universityAnalysis.service;

import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.entity.Grade;

import java.util.List;

public interface GradeService {


    List<Grade> getList_r(Grade grade, OrderUtil orderUtil, PageUtil pageUtil);
    Integer getTotal_r(Grade grade);

    List<Grade> getList_s(Grade grade, OrderUtil orderUtil, PageUtil pageUtil);
    Integer getTotal_s(Grade grade);
}
