package comfirm;

import java.util.Scanner;

public class comfirm {
    static int[] pre, in, post;

    static void creat(int n) {
        Scanner san2 = new Scanner(System.in);

        pre = new int[n]; // 用大小为 n 初始化数组
        in = new int[n];
        post = new int[n];

        for (int i = 0; i < n; ++i) { // 从索引 0 开始
            pre[i] = san2.nextInt();
        }

        System.out.println("---接下来是中序---");

        for (int i = 0; i < n; ++i) {
            in[i] = san2.nextInt();
        }
    }

    static void slove(int prel, int inl, int postl, int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            post[postl] = pre[prel];
            return;
        }
        int root = pre[prel];
        post[postl + n - 1] = root;
        int i;
        for (i = 0; i < n; ++i) { // 正确的循环条件
            if (pre[prel] == in[i + inl]) {
                break;
            }
        }

        int L = i; // 左子树中的元素数量
        int R = n - L - 1; // 右子树中的元素数量
        slove(prel + 1, inl, postl, L); // 构建左子树
        slove(prel + L + 1, inl + L + 1, postl + L, R); // 构建右子树
    }

    static void print(int n) {
        for (int i = 0; i < n; ++i) { // 从索引 0 开始
            System.out.println(post[i]);
        }
    }

    public static void main(String[] args) {
        Scanner san1 = new Scanner(System.in);
        int n = san1.nextInt();
        creat(n);
        slove(0, 0, 0, n); // 从索引 0 开始
        print(n);
    }
}
