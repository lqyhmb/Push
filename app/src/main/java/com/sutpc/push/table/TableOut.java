package com.sutpc.push.table;

import com.bin.david.form.annotation.ColumnType;
import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.util.List;

/**
 * Created by asus on 2019/2/27.
 */
@SmartTable(name="学生信息列表")
public class TableOut {

    @SmartColumn(id = 6, name = "总计", autoMerge = true, maxMergeCount = 16)
    private Integer total;

    @SmartColumn(type = ColumnType.ArrayChild)
    private TableRoad[] tableRoads;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public TableRoad[] getTableRoads() {
        return tableRoads;
    }

    public void setTableRoads(TableRoad[] tableRoads) {
        this.tableRoads = tableRoads;
    }
}
