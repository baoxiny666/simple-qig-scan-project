package com.tglh.simpleqigscanproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.tglh.simpleqigscanproject.entity.DepartMent;
import com.tglh.simpleqigscanproject.entity.InsertAdvise;
import com.tglh.simpleqigscanproject.service.QigScanService;
import net.sf.json.JSONArray;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/qig")
public class QigScanController {
    @Autowired
    private QigScanService qigScanService;

    @RequestMapping("/departmentfu")
    @ResponseBody
    public String fu(){
        List<DepartMent> list =  qigScanService.selectFuSelectFu();
        String goBackFu = JSONArray.fromObject(list).toString();
        return goBackFu;
    }

    @RequestMapping("/departmentson")
    @ResponseBody
    public String son(String fuNumber){
        List<DepartMent> list =  qigScanService.selectFuSelectSon(fuNumber);
        String goBackSon = JSONArray.fromObject(list).toString();
        return goBackSon;
    }

    @RequestMapping("/insertData")
    @ResponseBody
    public String insertData(String base64Data){
        try{
            String insertBase64Data = new String(Base64.decodeBase64(base64Data));
            //创建SimpleDateFormat对象，指定样式    2019-05-13 22:39:30
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date currentDate=new Date();


            InsertAdvise insertAdvise = new InsertAdvise();
            //转换成 JSONObject 对象
            JSONObject decodeJsonObject = JSONObject.parseObject(insertBase64Data);
            insertAdvise.setRules_name(decodeJsonObject.get("rules_name")==null?"":decodeJsonObject.get("rules_name").toString().replaceAll("'", "\\\\\'"));
            insertAdvise.setFlow_name(decodeJsonObject.get("flow_name")==null?"":decodeJsonObject.get("flow_name").toString().replaceAll("'", "\\\\\'"));
            insertAdvise.setDepart_ment(Integer.valueOf(decodeJsonObject.get("depart_ment").toString()));
            insertAdvise.setDepart_ment_son(Integer.valueOf(decodeJsonObject.get("depart_ment_son").toString()));
            insertAdvise.setAdvise_yij(decodeJsonObject.get("advise_yij")==null?"":decodeJsonObject.get("advise_yij").toString().replaceAll("'", "\\\\\'"));
            insertAdvise.setSubmit_person(decodeJsonObject.get("submit_person")==null?"":decodeJsonObject.get("submit_person").toString().replaceAll("'", "\\\\\'"));
            insertAdvise.setTele_phone(decodeJsonObject.get("tele_phone")==null?"":decodeJsonObject.get("tele_phone").toString().replaceAll("'", "\\\\\'"));
            insertAdvise.setCreate_time(sdf1.format(currentDate));
            insertAdvise.setDepart_ment_fu_name(decodeJsonObject.get("depart_ment_fu_name").toString());
            insertAdvise.setDepart_ment_son_name(decodeJsonObject.get("depart_ment_son_name").toString());
            int flag =  qigScanService.insertData(insertAdvise);
            // List<DepartMent> list =  qigScanService.insertData();
            //String finalStr = needInsertStr.replaceAll("'", "\\\\\'"); //作用等于在单引号前面加上转义符号\//对于其他特殊字符也是一样
            JSONObject jsonObject = new JSONObject();

            if(flag > 0){
                jsonObject.put("code",200);
                jsonObject.put("msg","插入成功");

            }
            return jsonObject.toJSONString();
        }catch (Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",407);
            jsonObject.put("msg","提交失败");
            return jsonObject.toJSONString();
        }
    }
}
