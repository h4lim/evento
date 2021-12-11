package com.evento.infrastructure.instance;

import com.evento.avro.Email;
import com.evento.infrastructure.contract.InstanceContract;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Consumer configuration.
 */
@Configuration
public class KafkaConsumerInstance implements InstanceContract.IKafkaConsumerInstance {

    @Value(value = "${spring.kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.schemaRegistryAddress}")
    private String schemaRegistryAddress;

    @Value(value = "${spring.kafka.max.redelivery.attempts}")
    private int maxRetryAttempts;

    @Value(value = "${spring.kafka.max.redelivery.interval}")
    private long retryInterval;

    /**
     * Consumer configs consumer factory.
     *
     * @return the consumer factory
     */
    @Override
    @Bean
    public ConsumerFactory<String, Email> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8085");

        return new DefaultKafkaConsumerFactory<>(props);
    }

    /**
     * Retry policy retry policy.
     *
     * @return the retry policy
     */
    @Override
    @Bean
    public RetryPolicy retryPolicy() {
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(maxRetryAttempts);
        return simpleRetryPolicy;
    }

    /**
     * Back off policy fixed back off policy.
     *
     * @return the fixed back off policy
     */
    @Override
    @Bean
    public FixedBackOffPolicy backOffPolicy() {
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(retryInterval);
        return backOffPolicy;
    }

    /**
     * Retry template retry template.
     *
     * @return the retry template
     */
    @Override
    @Bean(name = "retryTemplate")
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy());
        retryTemplate.setBackOffPolicy(backOffPolicy());
        return retryTemplate;
    }

    /**
     * Kafka listener container factory concurrent kafka listener container factory.
     *
     * @param consumerFactory the consumer factory
     * @param retryTemplate   the retry template
     * @return the concurrent kafka listener container factory
     */
    @Override
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Email> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Email> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setRetryTemplate(retryTemplate());
        return factory;
    }
}
