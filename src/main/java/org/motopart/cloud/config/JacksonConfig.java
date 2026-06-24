package org.motopart.cloud.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    /**
     * Several admin endpoints accept EITHER a single object OR an array. Enabling
     * ACCEPT_SINGLE_VALUE_AS_ARRAY lets the same List<T> controller signature handle both.
     */
    @Bean
    public com.fasterxml.jackson.databind.Module singleValueAsArrayModule() {
        return new com.fasterxml.jackson.databind.module.SimpleModule();
    }

    @Bean
    public org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder.featuresToEnable(
                DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
