package com.docs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@tk.mybatis.spring.annotation.MapperScan("com.docs.mapper")
@EnableTransactionManagement
public class DalConfig {
}
