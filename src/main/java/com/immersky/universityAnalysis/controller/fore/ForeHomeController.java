package com.immersky.universityAnalysis.controller.fore;

import com.alibaba.fastjson.JSONObject;
import com.immersky.universityAnalysis.util.OrderUtil;
import com.immersky.universityAnalysis.util.PageUtil;
import com.immersky.universityAnalysis.controller.BaseController;

import com.immersky.universityAnalysis.entity.User;

import com.immersky.universityAnalysis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ForeHomeController extends BaseController {
    @Resource(name = "userService")
    private UserService userService;


    //主页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToPage(HttpSession session, Map<String, Object> map) {
        logger.info("检查用户是否登录");
        Object userId = checkUser(session);
        if (userId != null) {
            logger.info("获取用户信息");
            User user = userService.get(Integer.parseInt(userId.toString()));
            map.put("user", user);
        }

        logger.info("转到主页");
        return "fore/homePage";
    }

    //转到错误页
    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String goToErrorPage() {
        return "fore/errorPage";
    }


    @ResponseBody
    @RequestMapping(value = "product/nav/{category_id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getProductByNav(@PathVariable("category_id") Integer category_id) {
        JSONObject object = new JSONObject();
        if (category_id == null) {
            object.put("success", false);
            return object.toJSONString();
        }

        return object.toJSONString();
    }
}
