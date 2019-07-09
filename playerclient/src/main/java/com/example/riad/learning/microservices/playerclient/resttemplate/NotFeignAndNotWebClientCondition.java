package com.example.riad.learning.microservices.playerclient.resttemplate;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NotFeignAndNotWebClientCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return !conditionContext.getEnvironment().acceptsProfiles("feign")
                && !conditionContext.getEnvironment().acceptsProfiles("webclient");
    }
}
