package com.workstatemachine.example1;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/07/25
 */
@Configuration
@EnableStateMachine
public class Config4 extends
        EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states)
            throws Exception {
        states.withStates().initial(OrderState.S1)
                .states(EnumSet.allOf(OrderState.class));
    }
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(OrderState.S1).target(OrderState.S2)
                .event(OrderEvent.E1)
                .guard((statecontext) -> true)
                .action((statecontext -> {  System.out.println("E1 Event");
                }))
                .and()
                .withExternal()
                .source(OrderState.S2).target(OrderState.S3)
                .event(OrderEvent.E2)
                .guard((statecontext) -> true)
                .action((statecontext -> {
                    System.out.println("E2 Event");
                }));
    }
}
