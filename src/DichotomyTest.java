import java.util.ArrayList;
import java.util.List;

/**
 * @author SmileLiu
 * @createDate 2020/06/08 10:13
 * @Description 二分法（算法图解 1.2）
 * @time O(log n)
 */
public class DichotomyTest {
    // 二分法查询次数统计
    private static Integer dichotomyCount = 0;

    // 简单查找次数统计
    private static Integer simpleCount = 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(10);
        list.add(15);
        list.add(28);

        // 输出指定数字在数组中对应的位置
        System.out.println("二分法=====================================");
        System.out.println("所在位置:" + binarySearch(list,28));
        System.out.println("查询次数:" + dichotomyCount);
        System.out.println("简单查找=====================================");
        System.out.println("所在位置:" + simpleSearch(list,28));
        System.out.println("查询次数:" + simpleCount);
    }

    /**
     * 二分法
     * @param list
     * @param item
     * @return
     */
    static Integer binarySearch(List<Integer> list,Integer item){
        // low和high用来跟踪列表中的查找范围
        Integer low = 0; // 最小边界
        Integer high = list.size()-1; // 最大边界

        // 只要最小边界不大于最大边界就继续使用二分法查找
        while (low <= high) {
            dichotomyCount++;
            // 猜测值在数组中的位置
            Integer mid = (low + high) / 2;

            // 猜测值
            Integer guess = list.get(mid);

            // 猜测值和元素相等则找到指定数字
            if (guess.equals(item)) {
                return mid;
            }

            //猜测值大了，将最大边界缩小一半
            if (guess > item) {
                high = mid - 1;
            } else {
                // 猜测值小了，将最小边界缩小一半
                low = mid + 1;
            }
        }

        // 没有则返回空
        return null;
    }

    /**
     * 简单查询
     * @param list
     * @param item
     * @return
     */
    static Integer simpleSearch(List<Integer> list,Integer item){
        for (Integer integer : list) {
            simpleCount++;
            if (integer.equals(item)) {
                return simpleCount - 1;
            }
        }

        return null;
    }

}
