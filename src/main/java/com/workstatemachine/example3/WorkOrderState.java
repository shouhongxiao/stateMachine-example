package com.workstatemachine.example3;


public enum WorkOrderState {

    //cc接电
    CCTel("CCTel"),

    //选择状态大黑竖线
    ChooiceStateOn("ChooiceStateOn"),

    //再约
    Later("Later"),

    //失败
    Fail("Fail"),

    //下订单
    Order("Order"),

    //签约
    Signed("Signed");

    private final String key;

    WorkOrderState(String key) {

        this.key = key;

    }


}
