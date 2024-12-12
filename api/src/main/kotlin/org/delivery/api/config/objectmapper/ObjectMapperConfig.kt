package org.delivery.api.config.objectmapper

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig {


    @Bean
    fun objecyMapper(): ObjectMapper{
        // kotlin module
        val kotlinModule = KotlinModule.Builder().apply {
            withReflectionCacheSize(512) // cash size
            configure(KotlinFeature.NullToEmptyCollection, false) // empty list
            configure(KotlinFeature.NullToEmptyMap,false) // map
            configure(KotlinFeature.NullIsSameAsDefault, false) // 자료의 기본형을 쓰는게 아닌 null로 설정
            configure(KotlinFeature.SingletonSupport, false)
            configure(KotlinFeature.StrictNullChecks, false) // null에 대한 허용도 검사도 끄겠다.
        }.build()

        val objectMapper = ObjectMapper().apply {

            registerModules(Jdk8Module()) // jdk 8 버전 이후 클래스
            registerModules(JavaTimeModule()) // local date
            registerModules(kotlinModule)

            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // 예를 들어, name,email이 json으로 들어와야하는데 name,email,date가 들어와도 오류를 터트리지 않는
            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false) // 비어있는거 생성할 때 false로 해준다.

            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // 날짜 관련 직렬화

            propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE // 스네이크 케이스
        }

        return objectMapper
    }
}