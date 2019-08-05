package com.workstatemachine.example3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/08/05
 */
@Component
public class LaterService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public Guard<WorkOrderState, WorkOrderEvent> laterGuard() {
        return stateContext -> {

        return true;
    };

}


    @Bean
    public Action<WorkOrderState, WorkOrderEvent> execute() {
        return stateContext -> {
            logger.info("再约 业务逻辑");

        };
    }
}
