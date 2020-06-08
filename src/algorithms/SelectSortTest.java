package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SmileLiu
 * @createDate 2020/06/08 17:29
 * @Description 选择排序测试类
 * @time O(n²)
 */
public class SelectSortTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(6);
        list.add(10);
        list.add(15);
        list.add(28);
        System.out.println("排序后数组:" + selectSort(list));
    }

    static int getSmallIndex(List<Integer> list){
        // 假设最小数下标为0
        int smallIndex = 0;

        // 假设下标为0的数组为最小数
        Integer small = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            // 如果数组里面的元素小于0号元素则更新最小元素和最小元素坐标
            if (list.get(i) < small) {
                small = list.get(i);
                smallIndex = i;
            }
        }
        return smallIndex;
    }

    static List<Integer> selectSort(List<Integer> list){
        List<Integer> sortList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            // 将找出的最小元素按顺序排入新数组
            sortList.add(list.remove(getSmallIndex(list)));
        }
        return  sortList;
    }

}
