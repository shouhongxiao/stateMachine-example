package com.workstatemachine.example3;

import com.workstatemachine.example1.OrderEvent;
import com.workstatemachine.example1.OrderState;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/08/02
 */
@Configuration
@EnableStateMachine(contextEvents = false)
public class WorkOrderConfig {


    @Autowired
    LaterService laterService;

    @Autowired
    OrderService orderService;

    @Autowired
    FailService failService;

    public StateMachine<WorkOrderState, WorkOrderEvent> buildMachine
            (BeanFactory beanFactory) throws Exception {
        StateMachineBuilder.Builder<WorkOrderState, WorkOrderEvent> builder =
                StateMachineBuilder.builder();


        builder.configureConfiguration()
                .withConfiguration()
                 .machineId("WorkOrderMachine")
                .beanFactory(beanFactory);


        builder.configureStates()
                .withStates()
                .initial(WorkOrderState.CCTel)
                .choice(WorkOrderState.ChooiceStateOn)
                .states(EnumSet.allOf(WorkOrderState.class));


        builder.configureTransitions()
                .withExternal()
                .source(WorkOrderState.CCTel).target(WorkOrderState.ChooiceStateOn)
                .event(WorkOrderEvent.ChooiceStateEvent)
                .and()

                .withChoice()
                .source(WorkOrderState.ChooiceStateOn)
                .first(WorkOrderState.Later, laterService.laterGuard(),laterService.execute())
                .then(WorkOrderState.Fail,failService.failGuard(),failService.execute())
                .last(WorkOrderState.Order,orderService.execute());

        StateMachine<WorkOrderState, WorkOrderEvent> stateMachine = builder.build();
        return stateMachine;


    }
}
