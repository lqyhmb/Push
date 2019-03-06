package com.sutpc.push;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.utils.DensityUtils;
import com.sutpc.push.bean.ChildData;
import com.sutpc.push.bean.Lesson;
import com.sutpc.push.bean.LessonPoint;
import com.sutpc.push.bean.MergeInfo;
import com.sutpc.push.bean.Student;
import com.sutpc.push.bean.TanBean;
import com.sutpc.push.table.TableFlow;
import com.sutpc.push.table.TableOut;
import com.sutpc.push.table.TableRoad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TableActivity extends AppCompatActivity {

    private SmartTable table;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        // test1();

        // test2();

        test3();
    }

    public void test3() {
        List<TableRoad> tableRoads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tableRoads.add(new TableRoad(
                    getEntranceName(i),
                    new TableFlow[]{
                            new TableFlow("掉头", 10 * (i + 1), "10%"),
                            new TableFlow("左转", 10 * (i + 1), "10%"),
                            new TableFlow("直行", 10 * (i + 1), "10%"),
                            new TableFlow("右转", 10 * (i + 1), "10%")
                    },
                    40 * (i + 1)));
        }

        TableOut tableOut = new TableOut();
        TableRoad[] tableRoadArray = new TableRoad[tableRoads.size()];
        int total = 0;
        for (int i = 0; i < tableRoads.size(); i++) {
            total += tableRoads.get(i).getSubTotal();
            tableRoadArray[i] = tableRoads.get(i);
        }


        tableOut.setTableRoads(tableRoadArray);
        tableOut.setTotal(total);

        List<TableOut> tableOuts = new ArrayList<>();
        tableOuts.add(tableOut);


        table = (SmartTable<TableOut>) findViewById(R.id.at_table);
        table.setData(tableOuts);
        table.getConfig().setShowTableTitle(false); // 不显示标题
        table.getConfig().setShowXSequence(false); // 不显示X轴数字
        table.getConfig().setShowYSequence(false); // 不显示Y轴数字
        // table.setZoom(true, 1, 1f); // 设置是否缩放
    }

    public String getEntranceName(int i) {
        if (i == 0) {
            return "东进口";
        } else if (i == 1) {
            return "西进口";
        } else if (i == 2) {
            return "南进口";
        } else if (i == 3) {
            return "北进口";
        }
        return "";
    }

    public void test2() {
        FontStyle.setDefaultTextSize(DensityUtils.sp2px(this, 15));

        List<MergeInfo> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new MergeInfo("a", 18, System.currentTimeMillis(), true, 1, 100));
        }

        table = (SmartTable<MergeInfo>) findViewById(R.id.at_table);
        table.setData(list);
        table.getConfig().setShowTableTitle(true);
        table.getConfig().setShowXSequence(false);
        table.getConfig().setShowYSequence(false);
        table.setZoom(true, 2, 0.2f);
    }

    // 注解
    public void test1() {
        FontStyle.setDefaultTextSize(DensityUtils.sp2px(this, 15));

         /*   List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson("语文",true));
        lessons.add(new Lesson("数学",true));
        lessons.add(new Lesson("英语",false));
        lessons.add(new Lesson("物理",false));
        lessons.add(new Lesson("化学",true));*/
        List<String> texts = new ArrayList<>();
        texts.add("测试哈1");
        texts.add("测试哈2");
        texts.add("测试哈3");
        List<Lesson> lessons2 = new ArrayList<>();
        Lesson lesson1 = new Lesson("软件", true);

        lesson1.setTest(texts);
        lesson1.setLessonPoints(new LessonPoint[]{new LessonPoint("软件工程"), new LessonPoint("离散数学")});
        Lesson lesson2 = new Lesson("生物", true);
        lesson2.setLessonPoints(new LessonPoint[]{new LessonPoint("医学构造"), new LessonPoint("生物科技")});
        //lesson2.setTest(texts);
        lessons2.add(lesson1);
        lessons2.add(lesson2);
        lessons2.add(new Lesson("微积分", false));
        Random random = new Random();
        //  Lesson[] lessonArray = new Lesson[]{new Lesson("政治",false),new Lesson("法学",false)};
        List<TanBean> tanBeans = TanBean.initDatas();
        final List<Student> students = new ArrayList<>();
        //测试 从其他地方获取url
        int urlSize = tanBeans.size();
        for (int i = 0; i < 30; i++) {
            Student student = new Student("用户" + i, random.nextInt(70), System.currentTimeMillis()
                    - random.nextInt(70) * 3600 * 1000 * 24, true, new ChildData("测试" + i));
            student.setUrl(tanBeans.get(i % urlSize).getUrl());
            //student.setLessons(i%3 ==0?lessons2:lessons);
            student.setLessons(lessons2);
            // student.setLessonsArray(lessonArray);
            students.add(student);
        }


        table = (SmartTable<Student>) findViewById(R.id.at_table);
        table.setData(students);
        table.getConfig().setShowTableTitle(true);
        table.getConfig().setShowXSequence(true);
        table.getConfig().setShowYSequence(true);
        table.setZoom(true, 2, 0.2f);
       /* //设置单个格子背景颜色
        table.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if("name".equals(cellInfo.column.getFieldName())
                        && cellInfo.row%2 ==1) {
                    return ContextCompat.getColor(AnnotationModeActivity.this, R.color.selectColor);
                }else{
                    return TableConfig.INVALID_COLOR;
                }
            }
            //根据背景颜色设置字体颜色
            @Override
            public int getTextColor(CellInfo cellInfo) {
                if("name".equals(cellInfo.column.getFieldName())
                        && cellInfo.row%2 ==1) {
                    return ContextCompat.getColor(AnnotationModeActivity.this, R.color.white);
                }else{
                    return super.getTextColor(cellInfo);
                }
            }
        });*/
    }
}
