package com.ffp.demo.domain.applicant;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Permit implements Serializable {
    private Long id;
    private String permit;
    private String priorPermit;
    private String expirationDate ;
    private String status;
    private String approvedDate;
    private String receivedDate;
    private String nio_sent;
}
