package com.rain.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 常用参数注解使用
 *
 * @author RainZero
 * @date 2021/03/03 11:19
 */
@RestController
public class ParameterTestController {

    //http://localhost:8080/car/2/owner/zhangsan?age=25&inters=ball&inters=game
    @GetMapping("/car/{id}/owner/{username}")
    public Map getCar(@PathVariable("id") Integer id,
                      @PathVariable("username") String username,
                      @PathVariable Map<String, String> pv,
                      @RequestHeader("user-Agent") String userAgent,
                      @RequestParam("age") Integer age,
                      @RequestParam("inters") List<String> inters,
                      @RequestParam Map<String, String> param
    ) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("age", age);
        map.put("inters", inters);
        map.put("param", param);
        return map;
    }

    //http://localhost:8080/car/sell;low=23;brand=audi,Honda,fort
    @GetMapping("/car/{path}")
    public Map sellCar(@MatrixVariable Integer low,
                       @MatrixVariable List<String> brand,
                       @PathVariable("path") String path) {

        Map<String, Object> map = new HashMap<>(16);
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    //http://localhost:8080/boss/1;age=20/2;age=30
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }


}
