package com.immersky.universityAnalysis.controller.fore;

import com.alibaba.fastjson.JSONObject;
import com.immersky.universityAnalysis.controller.BaseController;
import com.immersky.universityAnalysis.entity.Address;
import com.immersky.universityAnalysis.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class ForeAddressController extends BaseController {
    @Resource(name = "addressService")
    private AddressService addressService;

    //根据address_areaId获取地址信息-ajax
    @RequestMapping(value = "address/{areaId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    protected String getAddressByAreaId(@PathVariable String areaId) {
        JSONObject object = new JSONObject();
        logger.info("获取AreaId为{}的地址信息");
        List<Address> addressList = addressService.getList(null, areaId);
        if (addressList == null || addressList.size() <= 0) {
            object.put("success", false);
            return object.toJSONString();
        }
        logger.info("获取该地址可能的子地址信息");
        List<Address> childAddressList = addressService.getList(null, addressList.get(0).getAddress_areaId());
        object.put("success", true);
        object.put("addressList", addressList);
        object.put("childAddressList", childAddressList);
        return object.toJSONString();
    }
}
