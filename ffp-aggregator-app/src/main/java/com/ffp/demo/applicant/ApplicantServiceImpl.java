package com.ffp.demo.applicant;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.ffp.demo.api.ApplicantServiceI;
import com.ffp.demo.applicant.executor.query.FoodListQryExe;
import com.ffp.demo.domain.applicant.gateway.ApplicantGateway;
import com.ffp.demo.dto.data.ApplicantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@CatchAndLog
public class ApplicantServiceImpl implements ApplicantServiceI {


    @Resource
    FoodListQryExe foodListQryExe;
    public MultiResponse<ApplicantDTO> getAllApplicant(){
        return foodListQryExe.execute();
    }
}
