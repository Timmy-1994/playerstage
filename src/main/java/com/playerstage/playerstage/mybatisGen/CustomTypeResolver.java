package com.playerstage.playerstage.mybatisGen;

import java.sql.Types;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomTypeResolver extends JavaTypeResolverDefaultImpl {
    
    public CustomTypeResolver() {
        super();

        log.info(
            "[ PrimitiveTypeWrapper.getBooleanInstance ]  {} \n", 
            PrimitiveTypeWrapper.getBooleanInstance()
        );

        log.info(
            "[  FullyQualifiedJavaType.getBooleanPrimitiveInstance ]  {} \n", 
            FullyQualifiedJavaType.getBooleanPrimitiveInstance()
        );

        typeMap.put(
            Types.TINYINT, 
            new JavaTypeResolverDefaultImpl.JdbcTypeInformation(
                "TINYINT",
                PrimitiveTypeWrapper.getBooleanInstance()
            )
        );

    }
}
