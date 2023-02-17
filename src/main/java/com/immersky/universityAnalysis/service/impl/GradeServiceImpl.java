package com.immersky.universityAnalysis.service.impl;

import com.immersky.universityAnalysis.dao.GradeMapper;
import com.immersky.universityAnalysis.entity.Grade;
import com.immersky.universityAnalysis.service.GradeService;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {
    private GradeMapper gradeMapper;
    @Resource(name = "gradeMapper")
    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }



    @Override
    public List<Grade> getList_r(Grade grade, OrderUtil orderUtil, PageUtil pageUtil) {
        return gradeMapper.select_r(grade,orderUtil,pageUtil);
    }



    @Override
    public Integer getTotal_r(Grade grade) {
        return gradeMapper.selectTotal_r(grade);
    }
    @Override
    public List<Grade> getList_s(Grade grade, OrderUtil orderUtil, PageUtil pageUtil) {
        return gradeMapper.select_s(grade,orderUtil,pageUtil);
    }




    @Override
    public Integer getTotal_s(Grade grade) {
        return gradeMapper.selectTotal_s(grade);
    }
}
