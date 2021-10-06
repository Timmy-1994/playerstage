### TODO
- [] check the syntas in `build.gradle` about dependencies duplicate ...etc

### `mybatis` reverse engineering
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
    [spring-boot-starter](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
    [columnOverride](https://mybatis.org/generator/configreference/columnOverride.html)
    - simple template :
        ```xml
            <!-- 配置需要生成程式碼的資料庫表 -->
            <table tableName="pms_brand" domainObjectName="PmsBrand"
                enableCountByExample="false" enableUpdateByExample="false"
                enableDeleteByExample="false" enableSelectByExample="false"
                selectByExampleQueryId="false">
                <!-- 指定是否只生成 domain 類，預設為 false；
                    如果設定為 true，則只生成 domain 類，如果還配置了sqlMapGenerator，那麼
                    在 mapper.xml 檔案中，只生成 resultMap 元素 -->
                <property name="modelOnly" value="false"/>

                <!-- 預設為 false；如果設定為 true，生成的 model 類會直接使用 column 本身的名字，而不會再使用駝峰命名方法。比如 CREATE_DATE，生成的屬性名字就是 CREATE_DATE,而不會是 createDate -->
                <property name="useActualColumnNames" value="false"/>

                <!-- 生成主鍵的方法，如果設定了該元素，MBG 會在生成的 <insert> 元素中生成一條正確的 <selectKey> 元素 -->
                <generatedKey column="id" sqlStatement="MySql" identity="true"/>

                <!-- 用來修改表中某個列的屬性，MBG 會根據修改後的配置來生成 domain 的屬性；
                    column：要重新設定的列名；一個 table 元素中可以定義多個 columnOverride 元素 -->
                <columnOverride column="%">
                    <!-- 使用 property 屬性來指定列要生成的屬性名稱 -->
                    <property name="property" value="showStatus"/>

                    <!-- javaType 用於指定生成的 domain 的屬性型別，使用型別的全限定名-->
                    <property name="javaType" value="java.lang.Integer"/>

                    <!-- jdbcType用於指定該列的JDBC型別
                    <property name="jdbcType" value=""/>
                    -->
                </columnOverride>
            </table>
        ```

### [`flyway` DB migration](https://flywaydb.org/documentation/usage/gradle/)
* [migration sql should name as `V1__*.sql`](https://stackoverflow.com/questions/53173291/flyway-cannot-find-migrations-location-in)



### file 
[UrlResource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/UrlResource.html)
[ImageSaving](http://www.java2s.com/example/java-utility-method/url-load/saveimage-string-imageurl-string-destinationfile-f9579.html)