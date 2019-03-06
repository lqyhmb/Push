package com.sutpc.push.bean;

import com.bin.david.form.annotation.ColumnType;
import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.util.List;

/**
 * Created by huang on 2017/11/1.
 */
@SmartTable(name = "合并信息列表")
public class MergeInfo {

    @SmartColumn(id = 1, name = "进口", autoMerge = true, maxMergeCount = 4,parent = "测试赛")
    private String name;

    @SmartColumn(id = 5, name = "小计", autoMerge = true, maxMergeCount = 4)
    private int subtotal;

    @SmartColumn(id = 6, name = "总计", autoMerge = true, maxMergeCount = 16)
    private int total;

    @SmartColumn(id = 2, name = "流向")
    private int age;

    @SmartColumn(id = 3, name = "流量")
    private long time;

    @SmartColumn(id = 4, name = "大车率")
    private boolean isCheck;

    public MergeInfo(String name, int age, long time, boolean isCheck, int subtotal, int total) {
        this.name = name;
        this.age = age;
        this.time = time;
        this.isCheck = isCheck;
        this.subtotal = subtotal;
        this.total = total;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
