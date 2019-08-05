package com.workstatemachine.example2;

import com.workstatemachine.example1.OrderEvent;
import com.workstatemachine.example1.OrderState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateMachineStart;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/07/25
 */
@WithStateMachine(id = "config5StateMachine")
public class Config5StateMachine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnStateMachineStart
    public void stateMachineStart() {
        logger.info("状态机启动");
    }

    @OnTransition
    public void transtion(StateContext<OrderState, OrderEvent> stateContext) {

        if (stateContext.getEvent() != null)
            logger.info(stateContext.getEvent().name());
    }
}
