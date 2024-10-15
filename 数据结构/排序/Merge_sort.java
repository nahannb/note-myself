package 排序;

import java.util.ArrayList;

public class Merge_sort {
    public void merge_sort(int L, int R) {
        if (L < R) {
            int center = (L + R) / 2;
            merge_sort(L, center);
            merge_sort(center + 1, R);
            merge(L, center, R);
        }
    }

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
