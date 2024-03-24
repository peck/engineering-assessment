package com.ffp.demo.api;

import com.alibaba.cola.dto.MultiResponse;
import com.ffp.demo.dto.data.ApplicantDTO;

public interface ApplicantServiceI {
    MultiResponse<ApplicantDTO> getAllApplicant();
}
