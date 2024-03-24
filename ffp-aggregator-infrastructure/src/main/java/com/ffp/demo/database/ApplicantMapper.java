package com.ffp.demo.database;

import com.ffp.demo.database.dataobject.ApplicantDO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ApplicantMapper {
  List<ApplicantDO> getAllValidApplicantList();
}
