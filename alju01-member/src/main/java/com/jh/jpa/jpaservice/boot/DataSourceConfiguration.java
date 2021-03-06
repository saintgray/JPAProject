package com.jh.jpa.jpaservice.boot;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.jh.jpa.jpaservice.store" })
public class DataSourceConfiguration {

    @Bean
    @Primary
    public DataSource mySqlDataSource() {
        System.out.println("=================  mySqlDataSource initiated  =================");
        return DataSourceBuilder.create()
                                .url("jdbc:mysql://database-op-mysql.colzvrncohgs.ap-northeast-2.rds.amazonaws.com:3306/dream?serverTimezone=UTC")
                                .username("mnm")
                                .password("angel3028123")
                                .build();
    }


}
