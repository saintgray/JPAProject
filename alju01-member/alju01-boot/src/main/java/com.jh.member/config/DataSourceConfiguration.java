package com.jh.member.config;

import org.springframework.beans.factory.annotation.Value;
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
@EnableJpaRepositories(basePackages = { "com.jh.member" })
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    @Primary
    public DataSource mySqlDataSource() {
        System.out.println("=================  mySqlDataSource initiated  =================");
        return DataSourceBuilder.create()
                                .url(this.url)
                                .username(this.username)
                                .password(this.password)
                                .build();
    }


}
