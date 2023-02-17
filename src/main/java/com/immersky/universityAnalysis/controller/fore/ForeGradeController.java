package com.immersky.universityAnalysis.controller.fore;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.immersky.universityAnalysis.service.*;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.controller.BaseController;
import com.immersky.universityAnalysis.entity.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台管理-分数线页
 */
@Controller
public class ForeGradeController extends BaseController{
    @Resource(name="gradeService")
    private GradeService gradeService;
    @Resource(name="addressService")
    private AddressService addressService;

    //转到后台管理-分数线页-ajax
    @RequestMapping(value = "fore/grade", method = RequestMethod.GET)
    public String goGradeManagePage(HttpSession session, Map<String, Object> map){
        logger.info("获取前十条分数线信息");
        PageUtil pageUtil = new PageUtil(0, 10);
        List<Grade> gradeList = gradeService.getList_r(null, null, pageUtil);
        map.put("gradeList", gradeList);
        logger.info("获取分数线总数量");
        Integer gradeCount = gradeService.getTotal_r(null);
        for (int i=0;i<gradeList.size();i++)
        {
            gradeList.get(i).create(gradeList.get(i).getGrade_location());

        }
        map.put("gradeCount", gradeCount);
        logger.info("获取分页信息");
        pageUtil.setTotal(gradeCount);
        map.put("pageUtil", pageUtil);

        logger.info("转到后台管理-分数线页-ajax方式");
        return "fore/gradeManagePage";
    }


    //按条件查询分数线-ajax
    @ResponseBody
    @RequestMapping(value = "fore/grade/{index}/{count}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getGradeBySearch(@RequestParam(required = false) String grade_universityName/* 分数线名称 */,
                                   @RequestParam(required = false) String grade_type/* 分数线名称 */,
                                   @RequestParam(required = false) String grade_location/* 分数线名称 */,
                                   @RequestParam(required = false) String grade_upto/* 分数线名称 */,
                                        @RequestParam(required = false) String orderBy/* 排序字段 */,
                                        @RequestParam(required = false,defaultValue = "true") Boolean isDesc/* 是否倒序 */,
                                        @PathVariable Integer index/* 页数 */,
                                        @PathVariable Integer count/* 行数 */) throws UnsupportedEncodingException {



        if (grade_universityName != null) {
            //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
            grade_universityName = "".equals(grade_universityName) ? null : URLDecoder.decode(grade_universityName, "UTF-8");
        }
        if (grade_type != null) {
            //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
            grade_type = "".equals(grade_type) ? null : URLDecoder.decode(grade_type, "UTF-8");
        }
        if (grade_location != null) {
            //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
            grade_location = "".equals(grade_location) ? null : URLDecoder.decode(grade_location, "UTF-8");
        }
        if (grade_upto != null) {
            //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
            grade_upto = "".equals(grade_upto) ? null : URLDecoder.decode(grade_upto, "UTF-8");
        }

        System.out.println(grade_universityName);
        System.out.println(grade_type);
        System.out.println(grade_location);
        System.out.println(grade_upto);
        if (orderBy != null && "".equals(orderBy)) {
            orderBy = null;
        }
        //封装查询条件
        Grade grade = new Grade()
                .setGrade_universityName(grade_universityName);

        OrderUtil orderUtil = null;
        if (orderBy != null) {
            logger.info("根据{}排序，是否倒序:{}",orderBy,isDesc);
            orderUtil = new OrderUtil(orderBy, isDesc);
        }

        JSONObject object = new JSONObject();
        logger.info("按条件获取第{}页的{}条分数线", index + 1, count);
        PageUtil pageUtil = new PageUtil(index, count);

        List<Grade> gradeList = gradeService.getList_s(grade, orderUtil, pageUtil);
        Integer gradeCount = gradeService.getTotal_s(grade);
        if (grade_type!=null&& grade_type.equals("1"))
        {
            gradeList = gradeService.getList_r(grade, orderUtil, pageUtil);
            gradeCount = gradeService.getTotal_r(grade);
        }

        for (int i=0;i<gradeList.size();i++)
        {
            if (grade_location != null) {
                //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
                gradeList.get(i).setGrade_location(grade_location);
            }
            if (grade_type!=null&& grade_type.equals("1"))
            {
                gradeList.get(i).setGrade_type("文科");
            }
            gradeList.get(i).create(gradeList.get(i).getGrade_location());

        }

        if (grade_upto!=null&&grade_upto!="")
        {
            final int a=-Integer.valueOf(grade_upto);
            Collections.sort(gradeList, Comparator.comparing(Grade::getTrueValue));
            List<Grade> filteredGrades = gradeList.stream()
                    .filter(g -> g.getTrueValue() <= -a)
                    .collect(Collectors.toList());
            gradeList=filteredGrades;
        }
        System.out.println(gradeList);
        object.put("gradeList", JSONArray.parseArray(JSON.toJSONString(gradeList)));
        logger.info("按条件获取分数线总数量");

        object.put("gradeCount", gradeCount);
        logger.info("获取分页信息");
        pageUtil.setTotal(gradeCount);
        object.put("totalPage", pageUtil.getTotalPage());
        object.put("pageUtil", pageUtil);

        return object.toJSONString();
    }
}
