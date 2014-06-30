package com.baidu.push.example.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/17 0017 14:56
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class Jackson2HttpMessageConverterConfig {
    private ObjectMapper mapper;
    private MappingJackson2HttpMessageConverter converter;

    public Jackson2HttpMessageConverterConfig() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/json"));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        converter.setObjectMapper(mapper);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public MappingJackson2HttpMessageConverter getConverter() {
        return converter;
    }

    public StringHttpMessageConverter getStringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }
}
