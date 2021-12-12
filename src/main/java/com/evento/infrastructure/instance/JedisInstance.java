package com.evento.infrastructure.instance;

import com.evento.infrastructure.contract.InstanceContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisInstance implements InstanceContract.IJedisInstance {

    @Bean
    @Override
    public Jedis jedis() {
        return new Jedis();
    }
}
