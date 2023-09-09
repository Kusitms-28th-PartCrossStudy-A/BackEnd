package com.example.kusithm_part_study.global.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApiController {
    @RequestMapping("/")
    public String partCross() {
        return "part cross A팀!";
    }
}
