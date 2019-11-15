package com.smilerro.toolbox.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/15 0015 13:13
 */
public class BaseController {
    public Map getResult(){
        Map map = new HashMap();
        map.put("status",true);
        map.put("msg","success");
        return map;
    }
    public Map getResult(boolean status){
        Map map = new HashMap();
        map.put("status",status);
        map.put("msg",status?"success":"failed");
        return map;
    }
    public Map getResult(boolean status,String msg){
        Map map = new HashMap();
        map.put("status",status);
        map.put("msg",msg);
        return map;
    }
}
