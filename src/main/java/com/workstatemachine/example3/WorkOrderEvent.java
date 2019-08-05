package com.workstatemachine.example3;

/**
 * describe:
 * 描述那些桔色的线
 * @author hongxiao.shou
 * @date 2019/08/02
 */


//描述那些桔色的线
public enum  WorkOrderEvent {

    ChooiceStateEvent("ChooiceStateEvent"),

    Signed("Signed");

    private final String key;

    WorkOrderEvent(String key) {

        this.key = key;

    }


}
