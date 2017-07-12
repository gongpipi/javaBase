package com.pipi.improve.collections.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pipi on 2017/7/5.
 */
public class ArrayListTest {

    public static void main(String args []){
        ArrayList<Course> courses = new ArrayList<Course>();
        Course course = new Course("sd",1,1);
        courses.add(new Course("sd",1,1));

        // 1.包含
        courses.contains(course);
        // 2. 指定位置插入
        courses.add(1,course);
        // 3. 指定位置插入多个
        courses.addAll(1,null);
        // 4. 清空
        courses.clear();
        // 5.确定容量
        courses.ensureCapacity(100);
        // 6. 获取
        courses.get(1);
        // 7. 获取位置
        int i= courses.indexOf(course);
        // 8. 使list的容量缩小到现在的大小
        courses.trimToSize();
        // 9. 获取list的迭代
        courses.iterator();
        // 10. remove元素
        courses.remove(1);
        courses.remove(course);
        // 11. 设置某个位置
        courses.set(i,null);
        // 12. 保留传进去的集合的元素，其他的都移除。
        courses.retainAll(new ArrayList<Object>());
        System.out.println(courses);
    }
}
