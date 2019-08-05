package example3;

import com.workstatemachine.App;
import com.workstatemachine.example3.WorkOrderConfig;
import com.workstatemachine.example3.WorkOrderEvent;
import com.workstatemachine.example3.WorkOrderState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/08/05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class WorkOrderTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private WorkOrderConfig workOrderConfig;


    @Test
    public void test()
    {
        try {
            StateMachine<WorkOrderState, WorkOrderEvent>
                    stateMachine=  workOrderConfig.buildMachine(beanFactory);
            stateMachine.start();
            stateMachine.sendEvent(WorkOrderEvent.ChooiceStateEvent);

            logger.info("当前状态="+stateMachine.getState().getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
