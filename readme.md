### TODO
- [ ] check the syntas in `build.gradle` about dependencies duplicate ...etc

### `mybatis` reverse engineering
* consider using [`mybatis plus`](https://baomidou.com/guide/)

* [MyBatisGenerator-Tool](https://github.com/kingcos/MyBatisGenerator-Tool)
    Gradle offical plugin that I can find are without parameters deliver functionality.
    Therefore, define ant task to gernerate mappers & model files.

* `typeHandler`
    `org.mybatis.spring.boot` will use the package path in `application.properties`. just define the specify `columnOverride` in `mybatisGeneratorConfig.xml`.

* `typeResolver`
    According to officail docuement : 
    > Classpath Issues
        Initially, the plugin classpath is very limited - it only contains MyBatis generator itself. If you need to add something to the plugin’s classpath (for example, a JDBC driver)

    Not only define `type="${package}"` on `typeResolver` node in `mybatisGeneratorConfig.xml` but also need add the `jar` of `typeResolver.java` as dependency to `build.gradle` for building task
     
* `mybatisGeneratorConfig.xml`
    * [spring-boot-starter](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
    * [configure](https://gist.github.com/rorast/6c0900e5dc4c5ed222cc239589896c46)
        * `runtimes`
            * [`Mybatis3DynamicSql`](https://mybatis.org/mybatis-dynamic-sql/docs/select.html)
            * `Mybatis3`
                * [example & criteria usage](https://zhuanlan.zhihu.com/p/42411540)，runtime should be `Mybatis3`
                    ```java
                        UserExample example = new UserExample();
                        UserExample.Criteria criteria = example.createCriteria();

                        example.setOrderByClause("${cloumn name} asc"); // 升序
                        example.setDistinct(false); // 不去重

                        criteria.addNameEqualTo("${username}");

                        userMapper.selectByExample(example); // select * from user where name=${username} order by ${cloumn name} asc
                    ```

### [`flyway` DB migration](https://flywaydb.org/documentation/usage/gradle/)
* [migration sql should name as `V1__*.sql`](https://stackoverflow.com/questions/53173291/flyway-cannot-find-migrations-location-in)


### file handle
[UrlResource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/UrlResource.html)
[ImageSaving](http://www.java2s.com/example/java-utility-method/url-load/saveimage-string-imageurl-string-destinationfile-f9579.html)


### schedule
* [crontab](https://crontab.guru)