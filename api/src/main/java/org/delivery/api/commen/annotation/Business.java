package org.delivery.api.commen.annotation;

import org.hibernate.annotations.Comment;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service    // 스프링에서 자동적으로 감지를할 것이고,
// Business는 been으로 될것이다.
public @interface Business {

    @AliasFor(annotation = Service.class)
    String value() default "";

}
