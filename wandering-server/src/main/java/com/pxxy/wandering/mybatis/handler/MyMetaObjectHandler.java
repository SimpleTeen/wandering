package com.pxxy.wandering.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j // 该注解说明可以使用slf4j日志打印
@Component // 该注解说明把处理器加载到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    // 填充时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
