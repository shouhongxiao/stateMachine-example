package example1;

import com.workstatemachine.App;
import com.workstatemachine.example1.OrderEvent;
import com.workstatemachine.example1.OrderState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/07/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Config4Test {

    @Autowired
    private StateMachine<OrderState, OrderEvent>  config4EventConfig;

    @Test
    public void s1Tos2() {
        config4EventConfig.start();
        config4EventConfig.sendEvent(OrderEvent.E1);

    }

    @Test
    public void s2Tos3() {
        config4EventConfig.start();
        config4EventConfig.sendEvent(OrderEvent.E2);

    }

}
