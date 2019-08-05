package com.workstatemachine.example3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnStateMachineStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/08/05
 */
@WithStateMachine(id = "WorkOrderMachine")
public class WorkOrderMachine {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @OnStateMachineStart
    public void stateMachineStart() {
        logger.info("状态机启动");
    }
}
