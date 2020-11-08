package leetcode;

import java.util.*;

class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

public class Solution {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * <p>
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 提示：
     * <p>
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        boolean[][] booleans = new boolean[m][n];

        return dfs(0, 0, m, n, k, booleans);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] booleans) {

        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || booleans[i][j]) {
            return 0;
        }
        booleans[i][j] = true;
        return dfs(i + 1, j, m, n, k, booleans) + dfs(i, j + 1, m, n, k, booleans) + dfs(i - 1, j, m, n, k, booleans) + dfs(i, j - 1, m, n, k, booleans) + 1;
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 示例 1：
     * <p>
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * <p>
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     * <p>
     * 2 <= n <= 58
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;

    }


    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        String[] str = s.split("\\+");

        char[] chars = s.toCharArray();
        //e后面必须包含数字
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'e') {
                if (i >= chars.length - 1 || (chars[i + 1] > 9 || chars[i + 1] < 1)) {
                    return false;
                }
            }
        }

        return false;
    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            //偶数则交换
            if (nums[left] % 2 == 0) {
                //寻找右边奇数
                while (left < right && nums[right] % 2 != 1) {
                    right--;
                }
                //交换
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
            left++;
        }

        return nums;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode target = head;

        while (k > 0) {
            head = head.next;
            k--;
        }
        while (head.next != null) {
            head = head.next;
            target = target.next;
        }
        return target;
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return cur;

    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * <p>
     * 示例1：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 1000
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**请完成一个函数，输入一个二叉树，该函数输出它的镜像。

     例如输入：

          4
        /   \
       2     7
      / \   / \
     1   3 6   9
     镜像输出：

          4
        /   \
       7     2
      / \   / \
     9   6 3   1

     示例 1：

     输入：root = [4,2,7,1,3,6,9]
     输出：[4,7,2,9,6,3,1]

     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {

        return null;
    }

    public TreeNode swap(TreeNode node){
        return null;
    }

        public int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0) {
                return new int[0];
            }
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while(true) {
                // left to right.
                for(int i = l; i <= r; i++) {
                    res[x++] = matrix[t][i];
                }
                if(++t > b) {
                    break;
                }// top to bottom.
                for(int i = t; i <= b; i++) {
                    res[x++] = matrix[i][r];
                }
                if(l > --r) {
                    break;
                }// right to left.
                for(int i = r; i >= l; i--) {
                    res[x++] = matrix[b][i];
                }
                if(t > --b) {
                    break;
                }// bottom to top.
                for(int i = b; i >= t; i--) {
                    res[x++] = matrix[i][l];
                }
                if(++l > r) {
                    break;
                }
            }
            return res;
        }
//    static class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//    }
//    public static Node copyRandomList(Node head) {
//        Node node = head;
//        //在链表后面每个元素插入
//        while (node!=null){
//            Node next = node.next;
//            Node tmp = new Node(node.val);
//            node.next = tmp;
//            tmp.next = next;
//            tmp.random = node.random;
//            node = next;
//        }
//        //random
//        node = head.next;
//        while (node!=null){
//            if (node.random!=null)
//            node.random = node.random.next;
//            if (node.next==null)break;
//            node = node.next.next;
//        }
//        //next
//        Node res;
//        res = node = head.next;
//        Node headTmp = head;
//        while (node!=null){
//            headTmp.next = node.next;
//            if (node.next!=null){
//                node.next=node.next.next;
//            }
//            headTmp=headTmp.next;
//            node=node.next;
//        }
//
//
//        node=res;
//        while (node!=null){
//            System.out.print(node.val+"->");
//            node=node.next;
//        }
//        System.out.println();
//        while (head!=null){
//            System.out.print(head.val+"->");
//            head=head.next;
//        }
//
//        return res;
//    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node pre,head;
    public Node treeToDoublyList(Node root) {

        if (root==null)return null;

        dfsm(root);
        head.left = pre;
        pre.right = head;

        return head;

    }

    private void dfsm(Node cur) {
        if (cur==null) return;
        dfsm(cur.left);
        if (pre!=null)pre.right=cur;
        else head = cur;
        cur.left=pre;
        pre=cur;
        dfsm(cur.right);
    }

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     * n×(n−1)×(n−2)…×2×1
     * @param s
     * @return
     */
        List<String> res = new LinkedList<>();
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c)); // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x); // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1); // 开启固定第 x + 1 位字符
                swap(i, x); // 恢复交换
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }

    public static void main(String[] args) {


    }


}

