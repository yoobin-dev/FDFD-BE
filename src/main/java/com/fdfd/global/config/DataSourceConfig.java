package com.fdfd.global.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("!test")
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return new HikariDataSource();
    }

    // 두 번째 DB 연결 시 아래 주석을 해제하고 application-db.yml secondary 설정도 함께 해제하세요.
    // @Bean(name = "secondaryDataSource")
    // @ConfigurationProperties("spring.datasource.secondary")
    // public DataSource secondaryDataSource() {
    //     return new HikariDataSource();
    // }
}
