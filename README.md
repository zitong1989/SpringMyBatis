`注`: 该项目只是集成了SpringMVC+MyBatis，没有其他功能
## Development environment
1. spring: 3.2.16-RELEASE
2. mybatis: 3.3
3. mybatis-spring: 1.2.3
4. connection pool: bonecp

## Profile description
1. [bonecp document](http://jolbox.com/)
2. [mybatis-spring document](http://mybatis.org/spring/zh/mappers.html)
3. MapperScannerConfigurer使用sqlSessionFactoryBeanName替换sqlSessionFactory,因为sqlSessionFactory在使用外部properties文件时,${key}无法替换为真实值ֵ
4. mybatis日志
   **mybatis3.2.x**之后需要将日志信息配置到mapper，java.sql不再起作用,例如：
   com.inspur.spring.demo.user.dao.UserMapper=TRACE #输出结果集
   com.inspur.spring.demo.user.dao.UserMapper=DEBUG #只输出sql
   `注`:mybatis日志中slf4j>commons-logging>log4j,若采用log4j需要在mybatis-confg.xml文件中增加
   ```
   <settings>  
        <setting name="logImpl" value="LOG4J" />    
    </settings> 
   ```
5. spring @ResponseBody中文乱码
原因是Spring默认的字符集是`ISO-8859-1`,需要将字符集设置为`UTF-8`
``` xml
<mvc:annotation-driven>
	<mvc:message-converters register-defaults="true">
		<bean class="org.springframework.http.converter.StringHttpMessageConverter">
			<constructor-arg value="UTF-8" />
			<property name="writeAcceptCharset" value="false" />
		</bean>
	</mvc:message-converters>
</mvc:annotation-driven>
```

## Junit Test
1. 在执行单元测试时需要加载spring-context.xml和mybatis-config.xml，代码示例
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml", "classpath*:mybatis-config.xml" })
public class TestExample {

}
```
建议将spring-context.xml和mybatis-config.xml放到test/resources中，这样运行测试用例时不会出现找不到配置文件的错误。*以后有更好的处理方法，再进行改进。*