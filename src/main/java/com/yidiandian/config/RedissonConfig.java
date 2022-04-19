package com.yidiandian.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 云澜
 * @Date: 2022/4/19 22:45
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Configuration
public class RedissonConfig {

    @Bean
    public Redisson redisson(){
        Config config = new Config(  );
        config.useSingleServer().setAddress( "redis://127.0.0.1:6379" ).setDatabase( 0 );
        return (Redisson) Redisson.create(config);
    }
}
