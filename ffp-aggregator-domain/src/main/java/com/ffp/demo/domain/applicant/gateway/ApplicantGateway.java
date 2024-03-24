package com.ffp.demo.domain.applicant.gateway;

import com.ffp.demo.domain.applicant.Applicant;

import java.util.List;

//Assume that the credit info is in another distributed Service
public interface ApplicantGateway {
    public List<Applicant> getAllApplicant() ;
}
