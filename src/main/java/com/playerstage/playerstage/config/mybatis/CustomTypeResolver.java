package com.playerstage.playerstage.config.mybatis;

import java.sql.Types;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

public class CustomTypeResolver extends JavaTypeResolverDefaultImpl {
    
    public CustomTypeResolver() {
        super();
        typeMap.put(Types.TINYINT, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Boolean.class.getName())));
    }
}
