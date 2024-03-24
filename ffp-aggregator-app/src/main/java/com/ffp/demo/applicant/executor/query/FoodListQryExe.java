package com.ffp.demo.applicant.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.ffp.demo.database.ApplicantMapper;
import com.ffp.demo.domain.applicant.Applicant;
import com.ffp.demo.domain.applicant.gateway.ApplicantGateway;
import com.ffp.demo.dto.data.ApplicantDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component
public class FoodListQryExe {

    @Resource
    private ApplicantGateway applicantGateway;
    public MultiResponse<ApplicantDTO> execute() {


        List<Applicant> list =  applicantGateway.getAllApplicant();
        List<ApplicantDTO> applicantDTOList = new ArrayList<>();

        for(Applicant applicant : list) {
            ApplicantDTO applicantDTO = new ApplicantDTO();
            applicantDTO.setApplicantName(applicant.getApplicantName());
            applicantDTO.setAddress(applicant.getAddress());
            applicantDTO.setFoods(applicant.getFoods());
            applicantDTO.setDaysHours(applicant.getDaysHours());
            applicantDTO.setFacilityType(applicant.getFacilityType());
            applicantDTOList.add(applicantDTO);
        }
        MultiResponse<ApplicantDTO> r = MultiResponse.of(applicantDTOList);
        r.setErrCode("0");
        r.setErrMessage("");
        return r;
    }
}
