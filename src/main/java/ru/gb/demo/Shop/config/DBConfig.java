package ru.gb.demo.Shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.h2.tools.Server;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.demo.Shop.aspects.LogAspect;

import java.sql.SQLException;


@Configuration
@ComponentScan(basePackages = "ru.gb.demo.Shop")
@EnableAspectJAutoProxy
public class DBConfig {
        @Bean(initMethod = "start", destroyMethod = "stop")
        public Server inMemoryH2DatabaseaServer() throws SQLException {
            return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
        }

    @Bean
    public LogAspect aspect(){return new LogAspect();}
}
