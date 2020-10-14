package swordoffer;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class SwordOffer {


    /**
     * 第一题
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) return true;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        String tmp = new String();
        for (int i = 0; i < str.length(); i++) {
            //当前字符
            char c = str.charAt(i);
            //判断
            if (' ' == c) {//替换
                tmp += "%20";
            } else {
                tmp += c;
            }
        }
        return tmp;
    }



    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //链尾
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0) {
            return null;
        }

        int rootIndex = 0;
        //前序:根->左->右
        //中序:左->根->右

        TreeNode node = new TreeNode(pre[0]);//当前节点

        //左子树
        //右子树:中序数组之前(以根节点为分界)

        for (int i = 0; i < in.length; i++) {

            if (in[i] == node.val && i != 0) {

                rootIndex = i;
            }

        }

        //i为根节点在中序的下标地址  左边为左子树，右边为右子树,同样可以找出根节点再次根据中序进行划分出左右子树

        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));//左节点

        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));//左节点

        return node;
    }

    /**
     * & 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            return 0;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {

        if (array.length == 0 || array == null) return 0;

        //二分查找
        int low = 0;
        int height = array.length - 1;

        while (low <= height) {

            int mid = (low + height) / 2;

            if (array[mid] > array[height]) {
                low = mid + 1;
            } else if (array[mid] < array[height]) {
                height = mid;
            } else {
                height = height - 1;
            }
        }

        return array[low];

    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * <p>
     * 0,1,1,2,3,5,8,13,21,34,55...........F(N) = F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
     * <p>
     * n<=39
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        //递归
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @param target
     * @return １->1
     * 2->2
     * 3->(1,1,1)(1,2)(2,1)　3种
     * 4->(1,1,1,1)(1,1,2)(1,2,1)(2,1,1)(2,2) ５种
     * 5->(1,1,1,1,1)(1,1,1,2)(1,1,2,1)(1,2,1,1)(2,1,1,1)(1,2,2)(2,1,2)(2,2,1) ８种
     * 6->(1,1,1,1,1,1)(1,1,1,1,1,2)(1,1,1,1,2,1)(1,1,1,2,1,1)(1,1,2,1,1,1)(1,2,1,1,1,1)(2,1,1,1,1,1) （1122）(1221),2211,2112,2121,1212,222  14种
     * <p>
     * 1,2,3,5,8,14
     * 裴波拉切
     * F(n) = F(n-1)+F(n-2)
     */
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 贪心算法
     *
     * @param target
     * @return 1-1
     * 2-2
     * 3-4
     * 4-8
     * 5-16
     * <p>
     * F(n)=2^(n-1)
     */
    public static int JumpFloorII(int target) {
//        if(target == 1)return 1;
//        return 2 * JumpFloorII(target-1);
        if (target == 1) return 1;
        if (target == 2) return 2;
        return 2 << (target - 2);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * <p>
     * 比如n=3时，2*3的矩形块有3种覆盖方法：
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {

        if (target == 1) return 1;

        return RectCover(target - 1) + RectCover(target - 2);

    }


    /**
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     * 题解 讨论 通过的代码笔记 纠错 收藏
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;

        //递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
//        int n=Math.abs(exponent);
//        if(n==0)
//            return 1;
//        if(n==1)
//            return base;
//        double  result=Power(base,n>>1);
//        result*=result;
//        if((n&1)==1)
//            result*=base;
//        if(exponent<0)
//            result=1/result;
//        return result;

    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void reOrderArray(int[] array) {

        //冒泡
//        for (int i = 0; i < array.length; i++) {
//            for (int j = array.length -1;j>i; j--) {
//                if (array[j]%2==0&&array[j-1]%2==1){
//                    int tmp = array[j];
//                    array[j] = array[j-1];
//                    array[j-1] = tmp;
//                }
//            }
//        }
        //插入
        //相对位置不变--->保持稳定性；奇数位于前面，偶数位于后面 --->存在判断，挪动元素位置；

        for (int i = 0; i < array.length-1; i++) {
            //
            int j = i;
            while (j>0){
                if (array[j]%2==0&&array[j+1]%2==1){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    j--;
                }else {
                    break;
                }
            }
        }

    }


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode p, q;
        for (p = q = head; p != null; p = p.next, k--)
            if (k <= 0)
                q = q.next;
        return k <= 0 ? q : null;

    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        System.out.println(head.val);
        if (head.next == null) return head;
        ListNode node = ReverseList(head.next);
        node.next = head;
        return head;
    }


    /**
     * 合并链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null)return list2;
        if (list2==null)return list1;
        //判断大小
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     *
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)  return false;
        return doesTree1HasTree2(root1, root2)|| HasSubtree(root1.left, root2) ||HasSubtree(root1.right, root2);
    }

    private boolean doesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2==null)  return true;
        if(root1==null)  return false;
        return root1.val==root2.val && doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }


    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     *二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     *
     * @param root
     */
    public void Mirror(TreeNode root) {

        if (root == null)return;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);

    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     *
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     *
     * 则依次打印出数字
     *
     * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }

        //下标
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        int left = 0;
        int up = 0;

        //遍历

        while (true){
            //上
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;//下移动一行
            if (up>down)break;//判断是否越界
            //右
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right<left)break;
            //下
            for (int i = right; i >= left ; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (down<up)break;
            //左
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left>right)break;
        }


        return list;
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * @param
     */
    class Solution {
        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> min = new Stack<Integer>();
        Integer temp = null;
        public void push(int node) {
            if(temp != null){
                if(node <= temp ){
                    temp = node;
                    min.push(node);
                }
                data.push(node);
            }else{
                temp = node;
                data.push(node);
                min.push(node);
            }
        }

        public void pop() {
            int num = data.pop();
            int num2 = min.pop();
            if(num != num2){
                min.push(num2);
            }
        }

        public int top() {
            int num = data.pop();
            data.push(num);
            return num;
        }

        public int min() {
            int num = min.pop();
            min.push(num);
            return num;
        }
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        //1,2,3,4,5
        //4,5,3,2,1

        //+1,+2,+3,+4,-4,+5,-5,-3,-2,-1

        Stack<Integer> stack = new Stack<>();
        //
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            if (popA[j] == pushA[i]){
                stack.pop();
                j++;
            }
        }
        for (int i = j; i < popA.length; i++) {
            Integer pop = stack.pop();
            if (pop != popA[i]){
                stack.push(pop);
            }
        }

        return stack.empty();
    }




    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     *
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *
     *    8-6-10-5-7-9-11
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null)queue.offer(poll.left);
            if (poll.right!=null)queue.offer(poll.right);
        }

        return list;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     *
     * 后序遍历 的序列中，最后一个数字是树的根节点 ，数组中前面的数字可以分为两部分：
     * 第一部分是左子树节点 的值，都比根节点的值小；第二部分 是右子树 节点的值，都比 根 节点 的值大，后面用递归分别判断前后两部分 是否 符合以上原则
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {

        int root = sequence[sequence.length-1];//根节点

        int index = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (root<=sequence[i]){
                index = i;
            }
        }

       return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,index));
    }


    public static void main(String[] args) {

        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};

        boolean isPopOrder = IsPopOrder(push, pop);
    }





























}

