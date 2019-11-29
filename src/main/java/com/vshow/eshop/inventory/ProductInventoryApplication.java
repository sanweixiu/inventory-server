package com.vshow.eshop.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableEurekaClient
public class ProductInventoryApplication {

	public static void main(String[] args) {
        SpringApplication.run(ProductInventoryApplication.class, args);
    }
	
	@Bean
	public JedisPool jedis() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10);
		config.setTestOnBorrow(true);
		JedisPool pool = new JedisPool(config, "localhost", 6379);
		return pool;
	}
}
