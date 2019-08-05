package example2;

import com.workstatemachine.App;
import com.workstatemachine.example1.OrderEvent;
import com.workstatemachine.example1.OrderState;
import com.workstatemachine.example2.Config5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/07/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Config5EventTest {

    @Autowired
    private Config5 config5;
    @Autowired
    private BeanFactory beanFactory;


    @Test
    public void s1Tos2() throws Exception {

        StateMachine<OrderState, OrderEvent> stateMachine =
                config5.buildMachine(beanFactory);
        stateMachine.start();
        stateMachine.sendEvent(OrderEvent.E1);


    }

}
