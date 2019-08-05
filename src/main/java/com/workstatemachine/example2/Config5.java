package com.workstatemachine.example2;

import com.workstatemachine.example1.OrderEvent;
import com.workstatemachine.example1.OrderState;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(contextEvents = false)
public class Config5 {

    public static StateMachine<OrderState, OrderEvent> buildMachine
            (BeanFactory beanFactory) throws Exception {
        StateMachineBuilder.Builder<OrderState, OrderEvent> builder =
                StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .machineId("config5StateMachine")
                .beanFactory(beanFactory);

        builder.configureStates()
                .withStates()
                .initial(OrderState.S1)
                .states(EnumSet.allOf(OrderState.class));

        builder.configureTransitions()
                .withExternal()
                .source(OrderState.S1)
                .target(OrderState.S2)
                .event(OrderEvent.E1);

        return builder.build();
    }

}
