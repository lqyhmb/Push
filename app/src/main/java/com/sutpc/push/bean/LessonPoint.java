package com.sutpc.push.bean;

import com.bin.david.form.annotation.SmartColumn;

/**
 * Created by asus on 2019/2/27.
 */

public class LessonPoint {

    @SmartColumn(id = 4, name = "知识点")
    private String name;

    public LessonPoint(String name) {
        this.name = name;
    }

}
