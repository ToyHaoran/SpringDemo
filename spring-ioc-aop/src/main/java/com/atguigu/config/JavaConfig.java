package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.atguigu")
@PropertySource(value = "classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement //开启事务注解的支持
public class JavaConfig {

    @Bean  //druid连接池
    public DataSource dataSource(@Value("${jdbc.driver}") String driver,
                                 @Value("${jdbc.url}") String url,
                                 @Value("${jdbc.username}") String username,
                                 @Value("${jdbc.password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean //jdbcTemplate
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        //内部要进行事务的操作，基于的连接池
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        //需要连接池对象
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}


