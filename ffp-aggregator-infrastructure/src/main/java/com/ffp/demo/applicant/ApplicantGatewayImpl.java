package com.ffp.demo.applicant;

import com.ffp.demo.database.dataobject.ApplicantDO;
import com.ffp.demo.database.ApplicantMapper;
import com.ffp.demo.domain.applicant.Applicant;
import com.ffp.demo.domain.applicant.gateway.ApplicantGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicantGatewayImpl implements ApplicantGateway {
    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public List<Applicant> getAllApplicant() {
        List<ApplicantDO> applicantDOS = applicantMapper.getAllValidApplicantList();

        List<Applicant> list = new ArrayList<>();
        for(ApplicantDO applicantDO : applicantDOS){
            Applicant  applicant = new Applicant();
            applicant.setApplicantName(applicantDO.getApplicantName());
            applicant.setFoodItems(applicantDO.getFoodItems());
            applicant.setAddress(applicantDO.getFoodItems());
            applicant.setDaysHours(applicantDO.getDaysHours());
            applicant.setFacilityType(applicantDO.getFacilityType());
            list.add(applicant);
        }

        return list;
    }
}
