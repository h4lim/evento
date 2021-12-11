package com.evento.infrastructure.contract;

import com.evento.avro.Email;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.plugins.Docket;

public class InstanceContract {

    public interface IEmailInstance {
        JavaMailSender getJavaMailSender();
    }

    public interface IRestTemplateInstance {
        RestTemplate restTemplate();
    }

    public interface IRedisInstance {
        JedisConnectionFactory jedisConnectionFactory();

        RedisTemplate<String, Object> redisTemplate();
    }

    public interface IElasticSearchInstance {
        RestHighLevelClient client();

        ElasticsearchOperations elasticsearchTemplate();
    }

    public interface IKafkaConsumerInstance {
        ConsumerFactory<String, Email> consumerFactory();

        RetryPolicy retryPolicy();

        FixedBackOffPolicy backOffPolicy();

        RetryTemplate retryTemplate();

        ConcurrentKafkaListenerContainerFactory<String, Email> kafkaListenerContainerFactory();
    }

    public interface IKafkaProducerInstance {
        ProducerFactory<String, Email> producerFactory();

        KafkaTemplate<String, Email> kafkaTemplate();
    }

    public interface ISwaggerInstance {
        Docket docket();
    }
}
