package com.ffp.demo.web;

import com.alibaba.cola.dto.MultiResponse;
import com.ffp.demo.api.ApplicantServiceI;
import com.ffp.demo.dto.data.ApplicantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {

    @Autowired
    private ApplicantServiceI applicantServiceI;

    @GetMapping(value = "/api/foods")
    public MultiResponse<ApplicantDTO> getAllFoods() {
        return applicantServiceI.getAllApplicant();
    }
}
