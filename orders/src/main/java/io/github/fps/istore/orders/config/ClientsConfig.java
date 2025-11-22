package io.github.fps.istore.orders.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.github.fps.istore.orders.client")
public class ClientsConfig {
}
