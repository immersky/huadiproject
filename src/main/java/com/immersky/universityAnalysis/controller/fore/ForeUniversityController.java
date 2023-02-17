package com.immersky.universityAnalysis.controller.fore;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.immersky.universityAnalysis.service.*;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.controller.BaseController;
import com.immersky.universityAnalysis.entity.Address;
import com.immersky.universityAnalysis.entity.University;
import com.immersky.universityAnalysis.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 后台管理-高校页
 */
@Controller
public class ForeUniversityController extends BaseController{
    @Resource(name="universityService")
    private UniversityService universityService;
    @Resource(name="addressService")
    private AddressService addressService;

    //转到后台管理-高校页-ajax
    @RequestMapping(value = "fore/university", method = RequestMethod.GET)
    public String goUniversityManagePage(HttpSession session, Map<String, Object> map){
        logger.info("获取前十条高校信息");
        PageUtil pageUtil = new PageUtil(0, 10);
        List<University> universityList = universityService.getList(null, null, pageUtil);
        map.put("universityList", universityList);
        logger.info("获取高校总数量");
        Integer universityCount = universityService.getTotal(null);
        map.put("universityCount", universityCount);
        logger.info("获取分页信息");
        pageUtil.setTotal(universityCount);
        map.put("pageUtil", pageUtil);

        logger.info("转到后台管理-高校页-ajax方式");
        return "fore/universityManagePage";
    }


    //转到后台管理-高校详情页-ajax
    @RequestMapping(value = "university/{uid}", method = RequestMethod.GET)
    public String getUniversityById(HttpSession session, Map<String,Object> map, @PathVariable Integer uid/* 高校ID */){
        logger.info("获取university_id为{}的高校信息",uid);
        University university = universityService.get(uid);


        map.put("university",university);

        logger.info("转到后台管理-高校详情页-ajax方式");
        return "fore/include/universityDetails";
    }

    //按条件查询高校-ajax
    @ResponseBody
    @RequestMapping(value = "fore/university/{index}/{count}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUniversityBySearch(@RequestParam(required = false) String university_name/* 高校名称 */,
                                  @RequestParam(required = false) String orderBy/* 排序字段 */,
                                  @RequestParam(required = false,defaultValue = "true") Boolean isDesc/* 是否倒序 */,
                                  @PathVariable Integer index/* 页数 */,
                                  @PathVariable Integer count/* 行数 */) throws UnsupportedEncodingException {


        if (university_name != null) {
            //如果为非空字符串则解决中文乱码：URLDecoder.decode(String,"UTF-8");
            university_name = "".equals(university_name) ? null : URLDecoder.decode(university_name, "UTF-8");
        }
        if (orderBy != null && "".equals(orderBy)) {
            orderBy = null;
        }
        //封装查询条件
        University university = new University()
                .setUniversity_name(university_name);

        OrderUtil orderUtil = null;
        if (orderBy != null) {
            logger.info("根据{}排序，是否倒序:{}",orderBy,isDesc);
            orderUtil = new OrderUtil(orderBy, isDesc);
        }

        JSONObject object = new JSONObject();
        logger.info("按条件获取第{}页的{}条高校", index + 1, count);
        PageUtil pageUtil = new PageUtil(index, count);
        List<University> universityList = universityService.getList(university, orderUtil, pageUtil);
        object.put("universityList", JSONArray.parseArray(JSON.toJSONString(universityList)));
        logger.info("按条件获取高校总数量");
        Integer universityCount = universityService.getTotal(university);
        object.put("universityCount", universityCount);
        logger.info("获取分页信息");
        pageUtil.setTotal(universityCount);
        object.put("totalPage", pageUtil.getTotalPage());
        object.put("pageUtil", pageUtil);

        return object.toJSONString();
    }
}
