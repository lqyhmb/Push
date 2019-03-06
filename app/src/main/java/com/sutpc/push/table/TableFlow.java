package com.sutpc.push.table;

import com.bin.david.form.annotation.SmartColumn;

/**
 * Created by asus on 2019/2/27.
 */

public class TableFlow {

    @SmartColumn(id = 2, name = "流向")
    private String flow;

    @SmartColumn(id = 3, name = "流量")
    private Integer traffic;

    @SmartColumn(id = 4, name = "大车率")
    private String cart;

    public TableFlow(String flow, Integer traffic, String cart) {
        this.flow = flow;
        this.traffic = traffic;
        this.cart = cart;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
}
