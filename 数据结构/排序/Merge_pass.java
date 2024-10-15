package 排序;

import java.util.ArrayList;

public class Merge_pass {

    // 归并排序主方法
    public void merge_sort(int n) {
        int length = 1;
        while (length < n) {
            merge_pass(n, length);
            length *= 2;
        }
    }

    // 归并阶段方法
    public void merge_pass(int n, int length) {
        int i;
        for (i = 0; i <= n - 2 * length; i += 2 * length) {
            merge(i, i + length - 1, i + 2 * length - 1);
        }
        // 处理剩余部分
        if (i + length < n) {
            merge(i, i + length - 1, n - 1);
        }
    }

    // 归并两个子序列
    public void merge(int L, int center, int R) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = L, j = center + 1;
        while (i <= center && j <= R) {
            if (main.numlist.get(i) <= main.numlist.get(j)) {
                temp.add(main.numlist.get(i++));
            } else {
                temp.add(main.numlist.get(j++));
            }
        }
        while (i <= center) {
            temp.add(main.numlist.get(i++));
        }
        while (j <= R) {
            temp.add(main.numlist.get(j++));
        }
        for (i = 0; i < temp.size(); i++) {
            main.numlist.set(L + i, temp.get(i));
        }
    }
}
