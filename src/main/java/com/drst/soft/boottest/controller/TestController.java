package com.drst.soft.boottest.controller;

import com.drst.soft.boottest.dto.TestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@CrossOrigin("*")
@RequestMapping("/sample")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public List<TestDTO> test() {
        log.info("test....");

        TestDTO testDTO1 = new TestDTO();
        testDTO1.setName("이종호");
        testDTO1.setAddress("서울");

        List<TestDTO> tList = new ArrayList<>();
        tList.add(testDTO1);

        return tList;
    }
}
