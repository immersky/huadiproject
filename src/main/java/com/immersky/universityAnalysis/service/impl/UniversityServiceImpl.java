package com.immersky.universityAnalysis.service.impl;


import com.immersky.universityAnalysis.dao.UniversityMapper;
import com.immersky.universityAnalysis.entity.University;
import com.immersky.universityAnalysis.service.UniversityService;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("universityService")
public class UniversityServiceImpl implements UniversityService {
    private UniversityMapper universityMapper;
    @Resource(name = "universityMapper")
    public void setUniversityMapper(UniversityMapper universityMapper) {
        this.universityMapper = universityMapper;
    }




    @Override
    public List<University> getList(University university, OrderUtil orderUtil, PageUtil pageUtil) {
        return universityMapper.select(university,orderUtil,pageUtil);
    }

    @Override
    public University get(Integer university_id) {
        return universityMapper.selectOne(university_id);
    }

    @Override
    public Integer getTotal(University university) {
        return universityMapper.selectTotal(university);
    }
}
