package com.sutpc.push.table;

import com.bin.david.form.annotation.ColumnType;
import com.bin.david.form.annotation.SmartColumn;

/**
 * Created by asus on 2019/2/27.
 */
public class TableRoad {

    @SmartColumn(id = 1, name = "进口", autoMerge = true, maxMergeCount = 4)
    private String entrance;

    @SmartColumn(type = ColumnType.ArrayChild)
    private TableFlow[] tableFlows;

    @SmartColumn(id = 5, name = "小计", autoMerge = true, maxMergeCount = 4)
    private Integer subTotal;

    public TableRoad(String entrance, TableFlow[] tableFlows, Integer subTotal) {
        this.entrance = entrance;
        this.tableFlows = tableFlows;
        this.subTotal = subTotal;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public TableFlow[] getTableFlows() {
        return tableFlows;
    }

    public void setTableFlows(TableFlow[] tableFlows) {
        this.tableFlows = tableFlows;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }


}
