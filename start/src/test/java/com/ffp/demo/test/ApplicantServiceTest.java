package com.ffp.demo.test;

import com.alibaba.cola.dto.Response;
import com.ffp.demo.api.ApplicantServiceI;
import com.ffp.demo.dto.data.ErrorCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantServiceTest {

    @Autowired
    private ApplicantServiceI applicantServiceI;


    @Before
    public void setUp() {

    }

    @Test
    public void testApplicantService(){
        //1.prepare

        //2.execute

        //3.assert error
//        Assert.assertEquals();
    }
}
