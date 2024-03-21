package com.moon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义版 Knife4j 组件配置文件.
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "defaultApi3")
    public Docket defaultApi2() {

        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("Success").build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("参数错误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("没有认证").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("没有访问权限").build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());

        ApiInfo apiInfoBuilder = new ApiInfoBuilder().title("SpringBoot实战项目")
                .description("springboot-demo项目 Restful APIS ~~~~~")
                .termsOfServiceUrl("http://www.xxx.com")
                .contact(new Contact("明月", "http://www.moon.com", "xx@qq.com"))
                .version("1.0")
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfoBuilder)
                .tags(new Tag("baidu", "百度接口API"), getTags())
                //分组名称
                .groupName("2.X版本")
                .enable(true)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.moon.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }


    private Tag[] getTags() {

        return new Tag[] {
                new Tag("alibaba", "阿里巴巴API接口"),
                new Tag("tencent", "腾讯API接口")
        };
    }



}
