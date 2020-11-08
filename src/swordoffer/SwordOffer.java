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

        for (int i = 0; i < array.length - 1; i++) {
            //
            int j = i;
            while (j > 0) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    j--;
                } else {
                    break;
                }
            }
        }

    }


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode p, q;
        for (p = q = head; p != null; p = p.next, k--)
            if (k <= 0)
                q = q.next;
        return k <= 0 ? q : null;

    }

    /**
     * 链表反转
     *
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
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //判断大小
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return doesTree1HasTree2(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return root1.val == root2.val && doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }


    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * <p>
     * 二叉树的镜像定义：源二叉树
     * 8
     * /  \
     * 6   10
     * / \  / \
     * 5  7 9 11
     * <p>
     * 镜像二叉树
     * 8
     * /  \
     * 10   6
     * / \  / \
     * 11 9 7  5
     *
     * @param root
     */
    public void Mirror(TreeNode root) {

        if (root == null) return;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);

    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     * <p>
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     * <p>
     * 则依次打印出数字
     * <p>
     * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        //下标
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        int up = 0;

        //遍历

        while (true) {
            //上
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;//下移动一行
            if (up > down) break;//判断是否越界
            //右
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            //下
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;
            //左
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }


        return list;
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     *
     * @param
     */
    class Solution {
        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> min = new Stack<Integer>();
        Integer temp = null;

        public void push(int node) {
            if (temp != null) {
                if (node <= temp) {
                    temp = node;
                    min.push(node);
                }
                data.push(node);
            } else {
                temp = node;
                data.push(node);
                min.push(node);
            }
        }

        public void pop() {
            int num = data.pop();
            int num2 = min.pop();
            if (num != num2) {
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
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        //1,2,3,4,5
        //4,5,3,2,1

        //+1,+2,+3,+4,-4,+5,-5,-3,-2,-1

        Stack<Integer> stack = new Stack<>();
        //
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            if (popA[j] == pushA[i]) {
                stack.pop();
                j++;
            }
        }
        for (int i = j; i < popA.length; i++) {
            Integer pop = stack.pop();
            if (pop != popA[i]) {
                stack.push(pop);
            }
        }

        return stack.empty();
    }


    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * @param root
     * @return 8
     * /  \
     * 6   10
     * / \  / \
     * 5  7 9 11
     * <p>
     * 8-6-10-5-7-9-11
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }

        return list;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence 后序遍历 的序列中，最后一个数字是树的根节点 ，数组中前面的数字可以分为两部分：
     *                 第一部分是左子树节点 的值，都比根节点的值小；第二部分 是右子树 节点的值，都比 根 节点 的值大，后面用递归分别判断前后两部分 是否 符合以上原则
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence.length == 0) return false;

        int root = sequence[sequence.length - 1];//根节点

        int index = 0;

        //取得分水岭
        for (int i = 0; i < sequence.length; i++) {
            if (root <= sequence[i]) {
                index = i;
                break;
            }
        }
        //
        for (int i = index; i < sequence.length; i++) {
            if (sequence[i] < root) return false;
        }

        boolean left = true, right = true;

        if (index > 0) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
        }

        if (index < sequence.length - 1 && left && index != 0) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length - 1));
        }

        //递归判断
        return left && right;
    }

    /**
     * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * @param root
     * @param target
     * @return 前置知识：
     * <p>
     * 首先清楚叶子的表示：如果节点为root, 那么当前节点为叶子节点的必要条件为!root->left && !root->right
     * <p>
     * 找出路径，当然需要遍历整棵树，这里采用先序遍历，即：根节点，左子树，右子树
     * 代码如下：
     * <p>
     * void preOrder(TreeNode *root) {
     * // process root
     * <p>
     * if (root->left) preOrder(root->left);
     * if (root->right) preOrder(root->right);
     * }
     * 具备了上面两个前置知识后，这里无非增加了路径和sum 和 叶子节点的判断。
     * 递归算法三部曲：
     * <p>
     * 明白递归函数的功能：FindPath(TreeNode* root,int sum)，从root节点出发，找和为sum的路径
     * 递归终止条件：当root节点为叶子节点并且sum==root->val, 表示找到了一条符合条件的路径
     * 下一次递归：如果左子树不空，递归左子树FindPath(root->left, sum - root->val),如果右子树不空，递归右子树，FindPath(root->right, sum - root->val)
     * 但是，你可能会问，这里没有保存路径啊？是的，可以用两个全局变量vector<int> path, vector<vector<int>> ret来保存
     * 代码中用了引用，将全局变量作为函数参数来进行全局传递。
     */
    public ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList tmp = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) return result;

        tmp.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) result.add(new ArrayList<Integer>(tmp));

        FindPath(root.left, target);
        FindPath(root.right, target);

        tmp.remove(tmp.size() - 1);

        return result;

    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * @param pHead
     * @return 第一步，在每个节点的后面插入复制的节点。
     * <p>
     * 第二步，对复制节点的 random 链接进行赋值。
     * <p>
     * 第三步，拆分。
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {

        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {

        if (node==null)return;//递归结束条件
        inOrder(node.left);//左子树
        node.left = pre;//当前节点左边指向
        if (pre != null)pre.right = node;//如果前一个节点不为空则指向当前节点(判断是为了第一个元素)
        pre = node;//指针下移
        if (head == null)head = node;//表头(只执行一次)
        inOrder(node.right);//右子树

    }


    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     *
     * 基于回朔算法
     * 时间复杂度：O(n!),比如3个字符的全排列有6种
     * 空间复杂度：O(1),原地交换
     */
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();

        if (str != null && str.length() >0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }

        return res;
    }

    /**
     * 对其进行
     * @param cs
     * @param i
     * @param list
     *
     * //这一段就是回溯法，这里以"abc"为例
     *
     *             //递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行
     *
     *             //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
     *             //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
     *             //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
     *             /////////////-------》此时结果集为["abc"]
     *
     *             //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
     *             //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
     *             /////////////-------》此时结果集为["abc","acb"]
     *             //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A
     *
     *             //             a|b|c(状态A)
     *             //               |
     *             //               |swap(0,0)
     *             //               |
     *             //             a|b|c(状态B)
     *             //             /  \
     *             //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
     *             //           /      \
     *             //         a|b|c   a|c|b
     *
     *             //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
     *             /////////////-------》此时结果集为["abc","acb","bac","bca"]
     *
     *             //             a|b|c(状态A)
     *             //               |
     *             //               |swap(0,1)
     *             //               |
     *             //             b|a|c(状态B)
     *             //             /  \
     *             //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
     *             //           /      \
     *             //         b|a|c   b|c|a
     *
     *             //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
     *             /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]
     *
     *             //             a|b|c(状态A)
     *             //               |
     *             //               |swap(0,2)
     *             //               |
     *             //             c|b|a(状态B)
     *             //             /  \
     *             //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
     *             //           /      \
     *             //         c|b|a   c|a|b
     *
     *             //5.最后退出for循环，结束。
     */
    private void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length -1){
            String value = String.valueOf(cs);
            if (!list.contains(value)){
                list.add(value);
            }
        }else {
            for (int j = i; j < cs.length; j++) {
                swap(cs,i,j);
                PermutationHelper(cs,i+1,list);
                swap(cs,i,j);
            }
        }
    }

    /**
     * 交换位置
     * @param cs
     * @param i
     * @param j
     */
    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }


    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer integer = hashMap.get(array[i]);
            hashMap.put(array[i],integer==null?1:++integer);
        }
        for (Integer key:hashMap.keySet()) {
            if (hashMap.get(key)>array.length/2){
                return key;
            }
        }
        return 0;
    }

    /**
     * 快速排序
     * @param input
     * @param start
     * @param end
     */
    public static void quickSort(int[] input,int start,int end){

        if (start>=end)return;
        //采用快速排序
        int left=start,right = end,key = input[start];

        while (left<right){
            //从右向左查找小于key的值
            while (left<right && input[right]>=key)right--;
            if (left<right){
                input[left] = input[right];
                left++;
            }
            //从左向右查找大于key的值
            while (left<right && input[left]<=key)left++;
            if (left<right){
                input[right] = input[left];
                right--;
            }
        }
        //left=right
        input[left] = key;

        quickSort(input,start,left-1);
        quickSort(input,right+1,end);

    }
    /**
     *输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        quickSort(input,0,input.length-1);

        System.out.println(Arrays.toString(input));

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }


    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        int res = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i],array[i]);
            res=Math.max(max,res);
        }
        return res;
    }

    //求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
    // ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

    /**
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution1(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {

            String tmp = String.valueOf(i);
            while (tmp.indexOf("1")!=-1){
                count++;
                tmp = tmp.replaceFirst("1","");
            }
        }
        return count;
    }

    /**
     *像类似这样的问题，我们可以通过归纳总结来获取相关的东西。
     *
     * 首先可以先分类：
     *
     * 个位
     * 我们知道在个位数上，1会每隔10出现一次，例如1、11、21等等，我们发现以10为一个阶梯的话，每一个完整的阶梯里面都有一个1，例如数字22，按照10为间隔来分三个阶梯，在完整阶梯0-9，10-19之中都有一个1，但是19之后有一个不完整的阶梯，我们需要去判断这个阶梯中会不会出现1，易推断知，如果最后这个露出来的部分小于1，则不可能出现1（这个归纳换做其它数字也成立）。
     *
     * 我们可以归纳个位上1出现的个数为：
     *
     * n/10 * 1+(n%10!=0 ? 1 : 0)
     *
     * 十位
     * 现在说十位数，十位数上出现1的情况应该是10-19，依然沿用分析个位数时候的阶梯理论，我们知道10-19这组数，每隔100出现一次，这次我们的阶梯是100，例如数字317，分析有阶梯0-99，100-199，200-299三段完整阶梯，每一段阶梯里面都会出现10次1（从10-19），最后分析露出来的那段不完整的阶梯。我们考虑如果露出来的数大于19，那么直接算10个1就行了，因为10-19肯定会出现；如果小于10，那么肯定不会出现十位数的1；如果在10-19之间的，我们计算结果应该是k - 10 + 1。例如我们分析300-317，17个数字，1出现的个数应该是17-10+1=8个。
     *
     * 那么现在可以归纳：十位上1出现的个数为：
     *
     * 设k = n % 100，即为不完整阶梯段的数字
     * 归纳式为：(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)
     * 百位
     * 现在说百位1，我们知道在百位，100-199都会出现百位1，一共出现100次，阶梯间隔为1000，100-199这组数，每隔1000就会出现一次。这次假设我们的数为2139。跟上述思想一致，先算阶梯数 * 完整阶梯中1在百位出现的个数，即n/1000 * 100得到前两个阶梯中1的个数，那么再算漏出来的部分139，沿用上述思想，不完整阶梯数k199，得到100个百位1，100<=k<=199则得到k - 100 + 1个百位1。
     *
     * 那么继续归纳百位上出现1的个数：
     *
     * 设k = n % 1000
     * 归纳式为：(n / 1000) * 100 + (if(k >199) 100 else if(k < 100) 0 else k - 100 + 1)
     * 后面的依次类推....
     *
     * 再次回顾个位
     * 我们把个位数上算1的个数的式子也纳入归纳式中
     *
     * k = n % 10
     * 个位数上1的个数为：n / 10 * 1 + (if(k > 1) 1 else if(k < 1) 0 else k - 1 + 1)
     * 完美！归纳式看起来已经很规整了。 来一个更抽象的归纳，设i为计算1所在的位数，i=1表示计算个位数的1的个数，10表示计算十位数的1的个数等等。
     *
     * k = n % (i * 10)
     * count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
     * 好了，这样从10到10的n次方的归纳就完成了。
     *
     * sum1 = sum(count(i))，i = Math.pow(10, j), 0<=j<=log10(n)
     * 但是有一个地方值得我们注意的，就是代码的简洁性来看，有多个ifelse不太好，能不能进一步简化呢？ 我们可以把后半段简化成这样，我们不去计算i * 2 - 1了，我们只需保证k - i + 1在[0, i]区间内就行了，最后后半段可以写成这样
     *
     * min(max((n mod (i*10))−i+1,0),i)
     *
     * 下面是代码
     *
     * public class Solution {
     *      public int NumberOf1Between1AndN_Solution(int n) {
     *          if(n <= 0)
     *              return 0;
     *          int count = 0;
     *          for(long i = 1; i <= n; i *= 10){
     *              long diviver = i * 10;
     *              count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
     *         }
     *          return count;
     *      }
     *  }
     * 补充一下，测试自己的和别人的代码，输入为Integer.MAX_VALUE的时候，1的个数已经超过Integer.MAX_VALUE，但是函数返回值只能规定为int，所以也很无奈
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;//
            int b = n % m;//取余数
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    /**
     * 题目描述
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     *
     * 数据范围：
     *
     * 	对于%50的数据,size<=10^4
     *
     * 	对于%75的数据,size<=10^5
     *
     * 	对于%100的数据,size<=2*10^5
     *
     * 示例1
     *
     * 输入
     * 1,2,3,4,5,6,7,0
     * 输出
     * 7
     * @param array
     * @return
     *
     * 采用归并排序
     */
    public static int InversePairs(int [] array) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for(int j=i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    count+=1;
                    count%=1000000007;
                }
            }
        }

        return count;
    }

    /**
     * 归并排序
     * @param a　有序数组
     * @param a
     * @param first
     * @param middle
     * @param end
     * @param tmp
     * @return
     */
    public static int[] memeryArray(int[] a,int first,int middle,int end, int[] tmp){

        int i=first,m = middle,j=middle+1,n=end,k = 0;

        while (i<n&&j<m){
            if (a[i]<a[j]){
                tmp[k++]=a[i++];
            }else {
                tmp[k++]=a[j++];
            }
        }


        while (i<=m){
            tmp[k++]=a[i++];
        }
        while (j<=n){
            tmp[k++]=a[j++];
        }

        for (int l = 0; l < k; l++) {
            a[first+l]=tmp[l];
        }

        return tmp;
    }


    public static void mergeSort(int[] a,int first,int last ,int[] temp) {

        if (first<last){
            int middle = (first+last)/2;
            //左边排序好
            mergeSort(a,first,middle,temp);
            //右边排序好
            mergeSort(a,middle+1,last,temp);
            //对两边合并
            memeryArray(a,first,middle,last,temp);
        }

    }


    /**
     * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1==null||pHead2==null)return null;

        ListNode ta = pHead1,tb = pHead2;

        while (ta!=tb){
            ta = ta.next;
            tb = tb.next;
            if (ta!=tb){
                if (ta==null)ta=pHead2;
                if (tb==null)tb=pHead1;
            }
        }
        return ta;
    }


    /**
     * 统计一个数字在升序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int [] array , int k) {

        int count = 0;

        /**
         * 暴利破解
         */
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]==k){
//                count++;
//            }
//        }
        /**
         * 二分查找
         */
        int left = 0,right = array.length-1;

        int leftTmp,rightTmp;

        while (left<right){
            int middle = (left+right)/2;
            //左边查找
            if (array[middle]>k){
                right = middle;
            }else {
                left = middle+1;
            }
        }
        leftTmp = left;
        while (left<right){
            int middle = (left+right)/2;
            if (array[middle]<=k){
                left = middle+1;
            }{
                right = middle;
            }
        }
        rightTmp = right;

        return rightTmp-leftTmp;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,9,9,10,11,12,13,14};

        System.out.println(GetNumberOfK(arr,9));
    }


}

