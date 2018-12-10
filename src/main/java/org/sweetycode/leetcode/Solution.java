package org.sweetycode.leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by tiantian on 2017/9/21.
 */
public class Solution {

    /**
     * 1. Two Sum
     * s1.空间换时间: 𝝷(n)
     * TODO: s2.排序后两端逼近: 𝝷(nlgn)
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return null ;
    }


    /**
     * 2. Add Two Numbers
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode flag = l1 ;
        int carry = 0 ;
        int temp = (flag.val + l2.val + carry)/10 ;
        flag.val = (flag.val + l2.val + carry)%10 ;
        carry = temp;

        while (l2.next != null) {
            if (flag.next == null) {
                flag.next = new ListNode(0);
            }

            flag = flag.next;
            l2 = l2.next;

            temp = (flag.val + l2.val + carry)/10 ;
            flag.val = (flag.val + l2.val + carry)%10 ;
            carry = temp;

        }

        while (carry>0) {
            if (flag.next == null) {
                flag.next = new ListNode(0);
            }
            flag = flag.next;
            temp = (flag.val + carry)/10 ;
            flag.val = (flag.val + carry)%10 ;
            carry = temp ;
        }

        return l1;

    }

    /**
     * 3. Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring(String s) {
        int head = 0 ;
        int result = 0 ;
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i ++) {
            if (hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) >= head) {
                head = hashMap.get(s.charAt(i)) + 1;
            }
            hashMap.put(s.charAt(i),i);
            result = Math.max((i - head + 1), result);
        }
        return result;
    }

    /**
     * 4. Median of Two Sorted Arrays
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }


    /**
     * 7. Reverse Integer
     */

    public int reverse(int x) {


        int result = 0 ;
        int pop ;

        while (x != 0) {
            pop = x % 10 ;
            x = x / 10 ;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop != 1) ) return 0 ;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop != -1) ) return 0 ;
            result = result * 10 + pop ;
        }
        return result;
    }

    /**
     *  9. Palindrome Number
     */
    public boolean isPalindrome(int x) {
        if(x == 0 ) return true;

        if(x > 0 && x % 10 != 0) {
            int rvt = 0 ;
            while (x > rvt ) {
                rvt = rvt * 10 + x % 10 ;
                if (rvt == x || rvt == (x = x/10)) return true;
            }
        }
        return false;
    }

    /**
     * 14. Longest Common Prefix
     * TODO: 二分法, startsWith
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String common = strs[0];
        for(int i = 1; i < strs.length; i ++) {
            common = common.substring(0, Math.min(common.length(),strs[i].length()));
            for(int j = 0; j < common.length(); j ++) {
                if(common.charAt(j) != strs[i].charAt(j)) {
                    common = common.substring(0, j);
                    break;
                }
            }

            if(common.length() == 0) return "";
        }

        return common;
    }

    /**
     * 20. Valid Parentheses
     */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        int i = 0;
        char[] stack = new char[s.length()];
        for (char c: s.toCharArray()) {
            if(c == ')') {
                i --;
                if(i < 0 || stack[i] != '(') return false;
            } else if(c == '}') {
                i --;
                if(i < 0 || stack[i] != '{') return false;
            } else if(c == ']') {
                i --;
                if(i < 0 || stack[i] != '[') return false;
            } else {
                stack[i] = c;
                i ++;
            }

        }

        return i == 0;
    }

    /**
     * 21. Merge Two Sorted Lists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head ;
        ListNode l;
        if(l1.val <= l2.val) {
            head = l1;
            l = l2;
        } else {
            head = l2;
            l = l1;
        }
        ListNode cur = head;
        ListNode tmp;
        while (l != null) {
            if(cur.next == null) {
                cur.next = l;
                return head;
            }

            if(cur.next.val <= l.val) {
                cur = cur.next;
            } else {
                tmp = cur.next;
                cur.next = l;
                l = l.next;
                cur = cur.next;
                cur.next = tmp;
            }
        }
        return head;
    }

    public ListNode mergeTwoListsNew(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head;
        if(l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoListsNew(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoListsNew(l1, l2.next);
        }

        return head;
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j ++) {
            if(nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 27. Remove Element
     */
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        int i = 0;
        int j = l - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i ++;
            }
            while (i < j && nums[j] == val) {
                j --;
            }
            if(i < l && j >= 0 && i < j) {
                nums[i] = nums[j];
                i ++;
                j --;
            }
        }
        if (i < l && i <= j && nums[i] != val) i ++;
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int l = nums.length;
        int i = 0;
        int j = l - 1;
        while (i <= j) {
            if(nums[i] == val) {
                nums[i] = nums[j] ;
                // reduce array size by one
                j --;
            } else {
                i ++;
            }
        }
        return j + 1;
    }

    /**
     * 28. Implement strStr()
     */
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        int i = 0;
        int l1 = haystack.length();
        int l2 = needle.length();
        if (needle.length() == 0) return 0;
        while (l1 - i >= l2) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
            i ++;
        }
        return -1;
    }

    /**
     * 35. Search Insert Position
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while ( i <= j ) {
            int middle = (int) Math.floor((i + j) / 2);
            int var = nums[middle];
            if (var == target) return middle;
            if (var < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }

        }

        return i;
    }

    /**
     * 38. Count and Say
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "";    // StringBuilder
        char[] nums = countAndSay( n - 1 ).toCharArray();
        char front = nums[0];
        int count = 0;
        for (char num: nums) {
            if (num == front) {
                count ++;
            } else {
                result = result + count + front;
                front = num;
                count = 1;
            }
        }
        result = result + count + front;
        return result;
    }

    /**
     * 53. Maximum Subarray
     */
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        if (l == 1) return nums[0];
        return maxSubArraySubproblem(nums, 0, nums.length - 1)[0] ;
    }
    private int[] maxSubArraySubproblem(int[] nums, int left, int right) {
        // Divide and Conquer method
        if (left == right) return new int[]{nums[left], left, right};
        int middle = (left + right) / 2 ;
        int[] part1 = maxSubArraySubproblem(nums, left, middle);
        int[] part2 = maxSubArraySubproblem(nums, middle + 1, right);

        int tmpSum = part1[0];
        int var = part1[2];
        for (int m1 = part1[2] + 1; m1 <= right; m1 ++) {
            tmpSum = tmpSum + nums[m1];
            if (tmpSum >= part1[0]) {
                part1[0] = tmpSum;
                part1[2] = m1;
            }
        }

        tmpSum = part2[0];
        for (int m2 = part2[1] - 1; m2 > var; m2 --) {
            tmpSum = tmpSum + nums[m2];
            if (tmpSum >= part2[0]) {
                part2[0] = tmpSum;
                part2[1] = m2;
            }
        }

        if(part1[0] >= part2[0]) return part1;
        return part2;
    }

    // method 2:
    public int maxSubArray2(int[] nums) {
        // this method will change the original nums.
        int result = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            nums[i] = nums[i - 1] > 0 ? nums[i - 1] + nums[i] : nums[i] ;
            if (nums[i] > result) result = nums[i];
        }
        return result;
    }


    /**
     * 58. Length of Last Word
     */
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0) return 0;
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    /**
     * 66. Plus One
     */
    public int[] plusOne(int[] digits) {
        int c = 1;
        int tmp;
        for (int i = digits.length - 1; i >= 0; i --) {
            tmp = digits[i] + c ;
            digits[i] = tmp % 10;
            c = tmp / 10 ;
        }

        if (c > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = c ;
            System.arraycopy(digits,0,result,1,digits.length);
            return result;
        }
        return digits;
    }

    public int[] plusOneNew(int[] digits) {
        boolean add = true;
        int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }

    /**
     * 67. Add Binary
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int c = 0;
        int tmp ;
        int al = a.length();
        int bl = b.length();
        for (int i = al - 1; i >= 0; i --) {
            if (al - i <= bl) {
                tmp = aChar[i] + bChar[i - al + bl] + c - 96;
            } else {
                tmp = aChar[i] + c - 48;
            }
            sb.append((char)(tmp % 2 + 48));
            c = tmp / 2;
        }

        for (int i = bl - al - 1; i >= 0; i --) {
            tmp = bChar[i]  + c - 48;
            sb.append((char)(tmp % 2 + 48));
            c = tmp / 2;
        }

        if (c == 1) sb.append('1');

        return sb.reverse().toString();
    }

    /**
     * 69. Sqrt(x)
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0;
        int right = x;
        int mid ;

        while (left < right) {
            mid = ( left + right ) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    /**
     * 70. Climbing Stairs
     */
    public int climbStairs(int n) {
        // Dynamic programming
        // F(n) = F(n-1) + F(n-2)
        int a = 1;
        int b = 2;

        if (n == 1) return a;
        if (n == 2) return b;

        int i = 3;
        int tmp;
        while (i <= n) {
            tmp = a;
            a = b;
            b = tmp + a;
            i ++;
        }
        return b;
    }

    /**
     * 83. Remove Duplicates from Sorted List
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pointer = head.next;
        ListNode preNode = head;

        while (pointer != null) {
            if (preNode.val == pointer.val) {
                preNode.next = pointer.next;
            } else {
                preNode = preNode.next;
            }
            pointer = pointer.next;
        }
        return head;
    }

    /**
     * 88. Merge Sorted Array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n - 1;
        m --;
        n --;
        while (m >= 0 && n >= 0) {
            nums1[pointer --] = nums1[m] > nums2[n] ? nums1[m --] : nums2[n --];
        }
        while (n >= 0) {
            nums1[pointer --] = nums2[n --];
        }
    }

    /**
     * 100. Same Tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null &&  q == null ) {
            return true ;
        }
        if ( p == null || q == null ) {
            return false ;
        }
        if ( p.val == q.val ) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
        }
        return false ;
    }

    /**
     * 101. Symmetric Tree
     */
    // method 1 : recursively
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // method 2 : iteratively (双端队列 Deque)
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);

        TreeNode preNode = null;
        TreeNode postNode = null;
        while (!deque.isEmpty()) {
            preNode = deque.pollFirst();
            postNode = deque.pollLast();

            if (preNode == null && postNode == null) continue;
            if (preNode == null || postNode == null) return false;
            if (preNode.val != postNode.val) return false;

            deque.addFirst(preNode.right);
            deque.addFirst(preNode.left);
            deque.addLast(postNode.left);
            deque.addLast(postNode.right);
        }
        return true;
    }

    /**
     * 104. Maximum Depth of Binary Tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0 ;
        int depth = 1 ;
        if(root.left != null || root.right != null) {
            depth = depth + Math.max(maxDepth(root.left),maxDepth(root.right)) ;
        }
        return depth ;
    }

    /**
     * 107. Binary Tree Level Order Traversal II
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (size > 0) {
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode treeNode = queue.remove(0);
                curLevel.add(treeNode.val);
                if(treeNode.left != null) queue.add(treeNode.left);
                if(treeNode.right != null) queue.add(treeNode.right);
            }
            size = queue.size();
            result.add(0, curLevel);
        }
        return result;
    }


    /**
     * 108. Convert Sorted Array to Binary Search Tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null ;
        TreeNode treeNode = new TreeNode(nums[nums.length/2]);
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2 + 1, nums.length));
        return treeNode;
    }

    /**
     * 110. Balanced Binary Tree
     */
    public boolean isBalanced(TreeNode root) {
        if (getBalancedHeight(root) >=0) return true;
        return false;
    }

    private int getBalancedHeight(TreeNode root) {
        if (root == null) return 0;
        int lefth = getBalancedHeight(root.left);
        int righth = getBalancedHeight(root.right);
        if (lefth < 0 || righth < 0 || Math.abs(lefth - righth) > 1) return -1;
        return Math.max(lefth, righth) + 1;
    }


    /**
     * 111. Minimum Depth of Binary Tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * 112. Path Sum
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 118. Pascal's Triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        Integer[] line = new Integer[]{1};
        result.add(Arrays.asList(line));
        for(int i = 2; i <= numRows; i ++){
            Integer[] tmp = new Integer[i];
            for(int j = 1; j < i - 1; j ++) {
                tmp[j] = line[j - 1] + line[j];
            }
            tmp[0] = 1;
            tmp[i - 1] = 1;
            line = tmp;
            result.add(Arrays.asList(line));
        }
        return result;
    }

    /**
     * 119. Pascal's Triangle II
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[]{1};

        if(rowIndex == 0) return Arrays.asList(result);

        for(int i = 1; i <= rowIndex; i++){
            Integer[] row = new Integer[i + 1];
            for(int j = 1; j < i; j ++){
                row[j] = result[j - 1] + result[j];
            }
            row[0] = 1;
            row[i] = 1;
            result = row;
        }

        return Arrays.asList(result);
    }
    //TODO
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> ret = new LinkedList<Integer>();
//        long nk = 1;
//        for (int i = 0; i <= rowIndex; i++) {
//            ret.add((int)nk);
//            nk = nk * (rowIndex - i) / (i + 1);
//        }
//        return ret;
//    }


    /**
     * 121. Best Time to Buy and Sell Stock
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        int premin = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] <= premin) {
                premin = prices[i];
            } else {
                profit = Math.max(prices[i] - premin, profit);
            }
        }
        return profit;
    }

    /**
     * 122. Best Time to Buy and Sell Stock II
     */
    // sell before depreciation. buy before revaluation
    public int maxProfitII(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        int premin = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] <= premin) {
                premin = prices[i];
            } else if (i == prices.length - 1 || prices[i + 1] < prices[i]) {
                profit += prices[i] -premin;
                premin = prices[i];
            }
        }
        return profit;
    }
    // better method :
    public int maxProfitII2(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i -1];
            }
        }
        return profit;
    }

    /**
     * 125. Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        // regex is slow.
        String a = s.toLowerCase().replaceAll("[^a-z0-9]+","");
        if (a.length() == 0) return true;
        for (int i = 0; i <= (a.length() - 1) / 2; i ++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 136. Single Number
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result = result ^ num;
        }

        return result;
    }

    /**
     * 141. Linked List Cycle
     */
    // method 1 :
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }
    // method 2 :
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 155. Min Stack
     */
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
            // method 2 : use LinkedList instead of Stack, and initial stack and minStack here.
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.empty() || minStack.lastElement() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.lastElement().equals(minStack.lastElement())) {
                minStack.pop();
            }
            stack.pop();

        }

        public int top() {
            return stack.lastElement();
        }

        public int getMin() {
            return minStack.lastElement();
        }

    }

    /**
     * 160. Intersection of Two Linked Lists
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null) {
            l1 ++;
            p1 = p1.next;
        }

        while (p2 != null) {
            l2 ++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;
        for (int i = Math.abs(l1-l2); i > 0; i --) {
            if (l1 > l2) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    /**
     * 167. Two Sum II - Input array is sorted
     */
    public int[] twoSumII(int[] numbers, int target) {
        int l = numbers.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < l; i ++) {
            numMap.put(numbers[i], i);
        }

        for (int i = 0; i < l; i ++) {
            if (numbers[i] > target) return null;
            if (numMap.containsKey(target - numbers[i])) {
                return new int[]{i + 1, numMap.get(target - numbers[i]) + 1};
            }
        }
        return null;
    }

    // method 2 :
    public int[] twoSumII2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] > target) {
                j --;
            } else if (numbers[i] + numbers[j] < target) {
                i ++;
            }
        }
        return null;
    }

    /**
     * 168. Excel Sheet Column Title
     */
    public String convertToTitle(int n) {
        n = n - 1;
        String result = "";
        while (n >= 0) {
            result = (char)(n % 26 + 65) + result;
            n = n / 26 -1;
        }
        return result;
    }

    /**
     * p169. Majority Element
     */
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0 ;
        for (int num: nums) {
            if (num == majority) {
                count ++ ;
            } else {
                if (count == 0) {
                    majority = num ;
                    count = 1 ;
                } else {
                    count -- ;
                }
            }

        }
        return majority;
    }

    /**
     * 171. Excel Sheet Column Number
     */
    public int titleToNumber(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i ++) {
            result = result + (c[i]-64)*(int)Math.pow(26,c.length - i - 1);
        }
        return result;
    }

    /**
     * 172. Factorial Trailing Zeroes
     * be careful of overflow problem.
     f(5!) = 1 + f(1!) = 1
     f(10!) = 2 + f(2!) = 2
     f(20!) = 4 + f(4!) = 4
     f(100!) = 20 + f(20!) = 20 + 4 + f(4!) = 24
     f(1000!) = 200 + f(200!) = 200 + 40 + f(40!) = 240 + 8 + f(8!) = 248 + 1 + f(1) =249
     *
     */

    public int trailingZeroes(int n) {
        int zeroNum = 0;
        while (n > 0) {
            zeroNum += n/5;
            n /= 5;
        }
        return zeroNum;
    }

    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }

    /**
     * 189. Rotate Array
     */
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1) return;
        while (k >= l) {
            k = k % l;
        }
        if (k == 0) return;

        reverse(nums, 0, l - k - 1);
        reverse(nums, l - k, l - 1);
        reverse(nums,0, l - 1);
    }
    // reverse array nums[i...j]
    private void reverse(int[] nums, int i, int j) {
        int tmp;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
    }

    /**
     * 190. Reverse Bits
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int times = 32;
        while (times > 0) {
//            result <<= 1;
//            result += (n & 1);
            result = (result << 1) | (n & 1);
            n >>>= 1;
            times --;
        }
        return result;
    }


    /**
     * 191. Number of 1 Bits
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(Integer n) {
        int result = 0;
        while (n != 0) {    // > 0 change to != 0, for input test: 2147483648
            if ((n & 1) == 1) {
                result ++;
            }
            n >>>= 1;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);    // 将最右边的一个1置0后返回给n
            res++;
        }
        return res;
    }

    /**
     * 198. House Robber
     * Dynamic Programming
     * F(n) = max( nums[i] + F(n-2), F(n-1) )
     * F(0) = nums[0]
     * F(1) = max( nums[1], nums[0] )
     */
    public int rob(int[] nums) {
        int l = nums.length;
        int f0 = 0;
        if (l == 0) return f0;
        int f1 = nums[0];
        int tmp;
        int i = 1;
        while ( i < l ) {
            tmp = f1;
            f1 = Math.max(nums[i] + f0, f1);
            f0 = tmp;
            i ++;
        }
        return f1;
    }


    /**
     * 202. Happy Number
     */
    public boolean isHappy(int n) {
        HashSet<Integer> varSet = new HashSet<>();
        int tmp ;
        while (varSet.add(n)) {
            if(n == 1) return true;
            tmp = 0;
            while (n > 0) {
                tmp += Math.pow(n % 10, 2) ;
                n = n / 10;
            }
            n = tmp;
        }
        return false;
    }

    /**
     * 203. Remove Linked List Elements
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(val);
        pre.next = head;
        ListNode pointer = pre;
        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return pre.next;
    }
    // method2: recursion
    public ListNode removeElements2(ListNode head, int val) {
        if (null == head)
            return null;
        ListNode ret = removeElements(head.next, val);
        head.next = ret;
        if (head.val == val)
            return ret;
        else
            return head;
    }

    /**
     * 204. Count Primes
     */
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isComposite = new boolean[n];
        isComposite[0] = true;
        isComposite[1] = true;
        for (int i = 2; i < n; i ++) {
            if (!isComposite[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        int rst = 0;
        for (boolean x: isComposite) {
            if (!x) {
                rst ++;
            }
        }
        return rst;
    }

    /**
     * 205. Isomorphic Strings
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i)+256]) {
                return false;
            }
            m[s.charAt(i)] = i + 1;
            m[t.charAt(i)+256] = i + 1;
        }
        return true;
    }

    /**
     * 206. Reverse Linked List
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = head.next;
        cur.next = null;
        while (pre != null) {
            head = pre;
            pre = pre.next;
            head.next = cur;
            cur = head;
        }
        return head;
    }

    /**
     * 217. Contains Duplicate
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }

    /**
     * 219. Contains Duplicate II
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i ++) {
            if (numMap.containsKey(nums[i])) {
                if (i - numMap.get(nums[i]) <= k){
                    return true;
                }
            }
            numMap.put(nums[i], i);
        }
        return false;
    }

    /**
     * 225. Implement Stack using Queues
     */
    class MyStack {

        LinkedList<Integer> queue ;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.removeLast();
        }

        /** Get the top element. */
        public int top() {
            return queue.getLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 226. Invert Binary Tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp ;
        if(root.left != null || root.right != null) {
            tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }
        return root;
    }

    /**
     * 231. Power of Two
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n >>>= 1;
        }
        return true;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if ((n & (n-1)) == 0){
            return true;
        }
        return false;
    }

    /**
     * 232. Implement Queue using Stacks
     */
    class MyQueue {
        LinkedList<Integer> stacks;
        /** Initialize your data structure here. */
        public MyQueue() {
            stacks = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stacks.addFirst(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stacks.removeLast();
        }

        /** Get the front element. */
        public int peek() {
            return stacks.getLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stacks.isEmpty();
        }
    }

    /**
     * 234. Palindrome Linked List
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        stack.push(slow.val);
        if (fast.next != null) {
            // odd num
            slow = slow.next;
        }
        while (!stack.isEmpty() && slow.next != null) {
            if (stack.pop() != slow.next.val) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode tmp;
        ListNode bck = null;

        while (fast.next != null && fast.next.next != null) {
            tmp = slow.next;
            slow.next = bck;
            bck = slow;
            slow = tmp;
            fast = fast.next.next;
        }
        tmp = slow.next;
        slow.next = bck;
        bck = slow;
        slow = tmp;
        if (fast.next != null) {
            // odd num
            slow = slow.next;
        }
        while (bck != null && slow != null) {
            if (bck.val != slow.val) {
                return false;
            }
            slow = slow.next;
            bck = bck.next;
        }
        return true;
    }

    // TODO: efficiency?
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * 237. Delete Node in a Linked List
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 242. Valid Anagram
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<String, Integer> map = new HashMap<>();
        for (char s0: s.toCharArray()) {
            // TODO: map.compute
            map.computeIfPresent(String.valueOf(s0), (key, val) -> val + 1);
            map.putIfAbsent(String.valueOf(s0), 1);
        }

        for (char t0: t.toCharArray()) {
            if (!map.containsKey(String.valueOf(t0)) || map.get(String.valueOf(t0)) == 0) return false;
            map.computeIfPresent(String.valueOf(t0), (key, val) -> val - 1);
        }
        return true;
    }

    // only english alphabet supported.
    public boolean isAnagram2(String s, String t) {
        int l = s.length();
        if (l != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < l; i ++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }

        for (int i: counter) {
            if (i != 0) return false;
        }
        return true;
    }

    /**
     * 257. Binary Tree Paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if(root == null) return result;
        getBinaryTreePaths(root, result, String.valueOf(root.val));
        return result;
    }

    private void getBinaryTreePaths(TreeNode root, List<String> pathList, String tmpPath) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            pathList.add(tmpPath);
        } else {
            if(root.left != null) {
                getBinaryTreePaths(root.left, pathList, tmpPath + "->" + root.left.val);
            }
            if(root.right != null) {
                getBinaryTreePaths(root.right, pathList, tmpPath + "->" + root.right.val);
            }
        }
    }

    /**
     * 258. Add Digits
     */
    public int addDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            if(result >= 10) result = result/10 + result % 10;
            num = num / 10;
        }
        return result;
    }

    /**
     * 263. Ugly Number
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;  // Ugly numbers are positive numbers !!!
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    /**
     * 268. Missing Number
     */
    public int missingNumber(int[] nums) {
        boolean missingZero = true;
        int max = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            max = Math.max(max, num);
            if (missingZero && num == 0) missingZero = false;
        }
        if (missingZero) return 0;
        int tmp = (1 + max) * max / 2 - sum;
        return tmp == 0 ? max + 1: tmp;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int num :nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber3(int[] nums) {
        // prevent overflow
        int l = nums.length;
        int sum = 0;
        for (int i = 0; i < l; i ++) {
            sum = sum + i - nums[i];
        }
        return sum + l;
    }

    /**
     * 278. First Bad Version
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle ;
        while (left < right) {
            // becareful of overflow
            middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle ;
            } else {
                left = middle + 1;
            }
        }
        return right ;
    }

    int FIRST_BAD_VERSION;
    public void setFIRST_BAD_VERSION(int FIRST_BAD_VERSION) {
        this.FIRST_BAD_VERSION = FIRST_BAD_VERSION;
    }
    boolean isBadVersion(int version) {
        return version >= FIRST_BAD_VERSION;
    }

    /**
     * 283. Move Zeroes
     */
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int index = 0;
        for (int num: nums) {
            if(num != 0) {
                nums[index ++] = num;
            }
        }

        while (index < nums.length){
            nums[index ++] = 0;
        }
    }

    /**
     * 290. Word Pattern
     * bijection: 既是单射又是满射的映射称为双射，亦称“一一映射”。
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<String, String> v1 = new HashMap<>();
        HashMap<String, String> v2 = new HashMap<>();

        String p0;
        for (int i = 0; i < words.length; i ++) {
            p0 = String.valueOf(pattern.charAt(i));
            if (v1.containsKey(p0) && !v1.get(p0).equals(words[i])) {
                return false;
            }
            if (v2.containsKey(words[i]) && !v2.get(words[i]).equals(p0)) {
                return false;
            }

            v1.put(p0, words[i]);
            v2.put(words[i], p0);
        }
        return true;
    }

    // good method.
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; i ++)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    /**
     * 292. Nim Game
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * 303. Range Sum Query - Immutable
     */
    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            // Immutable
            if (nums.length == 0) return;
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                this.nums[i] = this.nums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0? nums[j] : nums[j] - nums[i - 1];
        }
    }

    /**
     * 326. Power of Three
     */
    public boolean isPowerOfThree(int n) {
        // 3^((int)log3(MAXINT)) =  1162261467
        return n > 0 && 1162261467 % n == 0 ;
    }

    /**
     * 342. Power of Four
     */
    public boolean isPowerOfFour(int num) {
        // 4的幂数开根号就是2的幂数。
        return num > 0 && (Math.sqrt(num) - (int)Math.sqrt(num)) < 1e-9 && 32768 % (int)Math.sqrt(num) == 0 ;
    }

    /**
     * 344. Reverse String
     */
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i --) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    /**
     * 345. Reverse Vowels of a String
     */
    public String reverseVowels(String s) {
        char[] s0 = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char tmp;
        while (i < j) {
            if (s0[i] != 'a' && s0[i] != 'e' && s0[i] != 'i' && s0[i] != 'o' && s0[i] != 'u' && s0[i] != 'A' && s0[i] != 'E' && s0[i] != 'I' && s0[i] != 'O' && s0[i] != 'U') {
                i ++;
                continue;
            }
            if (s0[j] != 'a' && s0[j] != 'e' && s0[j] != 'i' && s0[j] != 'o' && s0[j] != 'u' && s0[j] != 'A' && s0[j] != 'E' && s0[j] != 'I' && s0[j] != 'O' && s0[j] != 'U') {
                j --;
                continue;
            }
            tmp = s0[i];
            s0[i] = s0[j];
            s0[j] = tmp;
            i ++;
            j --;
        }
        return new String(s0);
    }

    /**
     * 349. Intersection of Two Arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> eleSet = new HashSet<>();
        for (int num1: nums1) {
            eleSet.add(num1);
        }
        int i = 0;
        for (int num2: nums2) {
            if(eleSet.remove(num2)) {
                nums1[i] = num2;
                i ++;
            }
        }
        return Arrays.copyOf(nums1, i);
    }

    /**
     * 350. Intersection of Two Arrays II
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        int[] rst = new int[nums1.length];
        int l = 0;
        for (int num1: nums1) {
            map1.compute(num1, (k, v) -> (v == null) ? 1 : v + 1);
        }
        for (int num2: nums2) {
            if(map1.size()>0 && null != map1.compute(num2, (k, v) -> (v == null || v == 0)? null : v - 1)){
                rst[l] = num2;
                l ++;
            }
        }
        return Arrays.copyOfRange(rst, 0, l);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int len = 0;
        int pointer = 0;
        int tmp;
        for (int i = 0 ; i < nums2.length && len < nums1.length ; i ++) {
            if ((pointer = find(nums1, nums2[i], pointer)) != -1) {
                tmp = nums1[pointer];
                nums1[pointer] = nums1[len];
                nums1[len ++] = tmp;
            }
            pointer = len;
        }
        return Arrays.copyOfRange(nums1, 0, len);
    }

    private int find(int[] nums, int val, int start) {
        for (; start < nums.length; start ++) {
            if (nums[start] == val) {
                return start;
            }
        }
        return -1;
    }

    // top answer.
    public int[] intersect3(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)   {
            return new int[0];
        }
        int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
        int len1 = 0;
        boolean[] bl1 = new boolean[ret1.length];
        for (int i=0; i < nums2.length; i++) {
            int start = 0;
            while( (start = find(nums1, nums2[i], start)) != -1 ) {
                if(bl1[start] == false) {
                    ret1[len1++] = nums2[i];
                    bl1[start] = true;
                    break;
                }
                start++;
            }
        }
        return Arrays.copyOfRange(ret1, 0, len1);
    }

    /**
     * 367. Valid Perfect Square
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 0;
        int right = num;
        double middle;
        while (right - left >=1) {
            middle = (left + right)/2;
            if (myAbs(middle - num/middle) < 1e-9) {
                return true;
            } else if (middle < num/middle) {
                left = (int)middle + 1;
            } else {
                right = (int)middle;
            }
        }
        return false;
    }
    private double myAbs(double num) {
        return num < 0 ? - num : num;
    }

    /**
     * 371. Sum of Two Integers
     */
    // >>>1(不带符号右移)、>>1(带符号右移)
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int x = a ^ b;
        int c = 2 * ( a & b );
        return getSum(x, c);
    }

    /**
     * 374. Guess Number Higher or Lower
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int middle;
        int tmp;
        while (left <= right) {
            middle = left - (left - right)/2;
            tmp = guess(middle);
            if (tmp == 0) {
                return middle;
            } else if (tmp > 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    int MY_NUMBER;
    public void setMY_NUMBER(int MY_NUMBER) {
        this.MY_NUMBER = MY_NUMBER;
        System.out.println("My number is : " + MY_NUMBER);
    }

    int guess(int num) {
        return MY_NUMBER == num ? 0 : (MY_NUMBER - num)/Math.abs(MY_NUMBER - num);
    }

    /**
     * 383. Ransom Note
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        char[] ransomArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();

        int pointer ;
        char tmp;
        for (int i = 0 ; i < ransomArr.length ; i ++) {
            pointer = i;
            if ((pointer = find(magazineArr, ransomArr[i], pointer)) != -1) {
                tmp = magazineArr[pointer];
                magazineArr[pointer] = magazineArr[i];
                magazineArr[i] = tmp;
            } else {
                return false;
            }
        }
        return true;
    }
    private int find(char[] chars, int val, int start) {
        for (; start < chars.length; start ++) {
            if (chars[start] == val) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 387. First Unique Character in a String
     * Note: You may assume the string contain only lowercase letters.
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] alphabet = new int[26];  // record times of each letter
        char[] index = new char[Math.min(26, s.length())]; // record letter order.
        int[] position = new int[index.length];

        int counter = 0;
        for (int i = 0; i < chars.length; i ++) {
            alphabet[chars[i]-97] += 1;
            if (alphabet[chars[i]-97] == 1) {
                index[counter] = chars[i];
                position[counter] = i;
                counter ++;
            }
        }
        for (int i = 0; i < counter; i ++) {
            if (alphabet[index[i] - 97] == 1) return position[i];
        }
        return -1;
    }

    // top answer
    public int firstUniqChar1(String s) {
        int res = -1;
        int index;
        for (int i = 'a'; i <= 'z'; i ++) {
            index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                res = (res == -1 || index < res) ? index : res;
            }
        }
        return res;
    }

    /**
     * 389. Find the Difference
     */
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c: s.toCharArray()) {
            result -= c;
        }

        for(char c: t.toCharArray()) {
            result += c;
        }
        return result;
    }

    /**
     * 400. Nth Digit
     */
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        int b = 2;
        int counter = 9;
        while ((n - counter) / (9.0 * b) > Math.pow(10, b - 1)) {
            counter += 9 * b * Math.pow(10, b - 1);
            b++;
        }
        double tmp = (n - counter - 1) / b + Math.pow(10, b - 1);
        return (int) tmp / (int) Math.pow(10, b - (n - counter - 1) % b - 1) % 10;
    }

    // top answer
    public int findNthDigit2(int n) {
        int len = 1;
        int base = 1;
        while (n > 9L * base * len) {
            n -= 9 * base * len;
            len ++;
            base *= 10;
        }
        int curNum = (n - 1)/len + base;
        int digit = 0;
        for( int i = (n - 1) % len; i < len; ++ i) {
            digit = curNum % 10;
            curNum /= 10;
        }
        return digit;
    }

    /**
     * 401. Binary Watch
     */
    public List<String> readBinaryWatch(int num) {
        List<String> timeList = new ArrayList<>();

        int[][] hour = new int[4][];
        hour[0] = new int[]{0};
        hour[1] = new int[]{1, 2, 4, 8};
        hour[2] = new int[]{3, 5, 6, 9, 10};
        hour[3] = new int[]{7, 11};

        int[][] minute = new int[6][];
        minute[0] = new int[]{0};
        minute[1] = new int[]{1, 2, 4, 8, 16, 32};
        minute[2] = new int[]{3, 5, 6, 9, 10, 12, 17, 18, 20, 24, 33, 34, 36, 40, 48};
        minute[3] = new int[]{7, 11, 19, 35, 13, 21, 37, 25, 41, 49, 14, 22, 38, 26, 42, 50, 28, 44, 52, 56};
        minute[4] = new int[]{58, 57, 54, 53, 51, 46, 45, 43, 39, 30, 29, 27, 23, 15};
        minute[5] = new int[]{31, 47, 55, 59};

        int m;
        for (int h = Math.max(0, num - 5); h <= Math.min(num, 3); h ++) {
            m = num - h;
            for (int i = 0; i < hour[h].length; i ++) {
                for (int j = 0; j < minute[m].length; j ++) {
                    if (minute[m][j] < 10) {
                        timeList.add(hour[h][i] + ":0" + minute[m][j]);
                    } else {
                        timeList.add(hour[h][i] + ":" + minute[m][j]);
                    }
                }
            }
        }
        return timeList;
    }

    /**
     * 412. Fizz Buzz
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String tmp;
        for(int i = 1; i <= n; i ++) {
            tmp = "" ;
            if(i % 3 == 0) tmp += "Fizz";
            if(i % 5 == 0) tmp += "Buzz";
            if(tmp.equals("")) tmp = String.valueOf(i);
            result.add(tmp);
        }
        return result;
    }

    /**
     * 429. N-ary Tree Level Order Traversal
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (size > 0) {
            List curLevel = new ArrayList();
            for(int i = 0; i < size; i ++) {
                Node node = queue.remove(0);
                curLevel.add(node.val);
                if(node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(curLevel);
            size = queue.size();
        }
        return result;
    }

    /**
     * 461. Hamming Distance
     */
    public int hammingDistance(int x, int y) {
        int i = x^y;
        int cnt = 0;
        while(i > 0) {
            if((i&1) == 1) {
                cnt ++;
            }
            i >>>= 1;
            // >>>1(不带符号右移)、>>1(带符号右移)
        }
        return cnt;
    }

    /**
     * 463. Island Perimeter
     */
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int h = -2;
        for(int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == 1) {
                    result += 4;
                    if(h + 1 == j) result -= 2;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) result -=2;
                    h = j;
                }
            }
        }
        return result;
    }

    /**
     * 476. Number Complement
     TODO: https://www.cnblogs.com/liujinhong/p/6279855.html
     */
    public int findComplement(int num) {
        int mask = 1;
        int tmp = num;
        while(tmp > 0) {
            tmp >>>= 1;
            mask <<= 1;
        }
        return (mask-1)^num;
    }

    /**
     * 496. Next Greater Element I
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer,Integer> hashMap = new HashMap();

        for (int ele: nums2) {
            for (Integer key: hashMap.keySet()) {
                if(ele > key && hashMap.get(key) == -1) {
                    hashMap.put(key, ele);
                }
            }
            hashMap.putIfAbsent(ele, -1);
        }

        int i = 0;
        for(int ele: nums1){
            result[i] = hashMap.get(ele);
            i ++;
        }

        return result;
    }

    /**
     * 500. Keyboard Row
     * TODO: optimize
     */
    public String[] findWords(String[] words) {
        List<String> resultList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>(){
            {
                put("Q",1);put("W",1);put("E",1);put("R",1);put("T",1);put("Y",1);put("U",1);put("I",1);put("O",1);put("P",1);
                put("A",2);put("S",2);put("D",2);put("F",2);put("G",2);put("H",2);put("J",2);put("K",2);put("L",2);
                put("Z",3);put("X",3);put("C",3);put("V",3);put("B",3);put("N",3);put("M",3);
                put("q",1);put("w",1);put("e",1);put("r",1);put("t",1);put("y",1);put("u",1);put("i",1);put("o",1);put("p",1);
                put("a",2);put("s",2);put("d",2);put("f",2);put("g",2);put("h",2);put("j",2);put("k",2);put("l",2);
                put("z",3);put("x",3);put("c",3);put("v",3);put("b",3);put("n",3);put("m",3);

            }
        };
        int flag;
        int i;
        for (String word: words) {
            char[] c = word.toCharArray();
            flag = hashMap.get(String.valueOf(c[0]));
            for (i = 1; i < c.length; i ++) {
                if (flag != hashMap.get(String.valueOf(c[i]))) break;
            }
            if (i == c.length) resultList.add(word);

        }

        return resultList.toArray(new String[resultList.size()]);
    }

    /**
     * 520. Detect Capital
     */
    public boolean detectCapitalUse(String word) {
        if(word == null) return true;
        int l = word.length();
        int result = 0;
        for (char c: word.toCharArray()) {
            if(c - 91 < 0) result += 1;
        }
        if(result == l || result == 0 || (result == 1 && word.charAt(0) - 91 < 0)) return true;
        return false;
    }

    /**
     * 521. Longest Uncommon Subsequence I
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(),b.length());
    }


    /**
     * 557. Reverse Words in a String III
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word: words) {
            char[] c = word.toCharArray();
            for(int i = c.length - 1; i >= 0; i --) {
                sb.append(c[i]);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 559. Maximum Depth of N-ary Tree
     */
    public int maxDepthNT(Node root) {
        if(root == null) return 0;
        int result = 0;
        if(root.children != null){
            for (Node node:root.children) {
                result = Math.max(result,maxDepthNT(node));
            }
        }
        return result + 1;
    }

    /**
     * 561. Array Partition I
     */
    public int arrayPairSum(int[] nums) {
        int result = 0;
        int[] newArray = new int[20001];
        for (int i = 0; i < nums.length; i ++) {
            newArray[nums[i] + 10000] += 1;
        }

        boolean odd= true;
        for (int i = 0; i < 20001; i ++) {
            while (newArray[i] > 0) {
                if(odd) {
                    result += i - 10000;
                }
                odd = !odd;
                newArray[i] -= 1;
            }
        }
        return result;
    }

    public int arrayPairSum1(int[] nums) {
        int result = 0;
        nums = quickSort(nums,0,nums.length);
        for(int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
    // q exclusive
    private int[] quickSort(int[] nums, int p, int q) {
        int r;
        if(p < q) {
            r = partition(nums, p, q);
            nums = quickSort(nums, p, r);
            nums = quickSort(nums, r + 1, q);
        }
        return nums;
    }
    // q exclusive
    private int partition(int[] nums, int p, int q) {
        int pivot = nums[p] ;
        int j = p ;
        int tmp;
        for (int i = p + 1; i < q; i ++) {
            if(nums[i] <= pivot) {
                j ++;
                tmp = nums[j] ;
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        nums[p] = nums[j];
        nums[j] = pivot;
        return j;
    }

    /**
     * 566. Reshape the Matrix
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r * c) return nums;
        int[][] result = new int[r][c];
        int p;
        for(int i = 0; i < nums.length; i ++) {
            for(int j = 0; j < nums[0].length; j ++){
                p = nums[0].length * i + j ;
                result[p / c][p % c] = nums[i][j];
            }
        }
        return result;
    }

    /**
     * 575. Distribute Candies
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> hashSet = new HashSet<>();
        int num = candies.length;
        int counter = 0;
        for (int candy: candies) {
            if(hashSet.add(candy)){
                counter ++ ;
                if(counter >= num/2) return counter;
            }
        }
        return counter;
    }

    /**
     * 589. N-ary Tree Preorder Traversal
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        for (Node node: root.children) {
            result.addAll(preorder(node));
        }
        return result;
    }

    /**
     * 590. N-ary Tree Postorder Traversal
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        if(root.children != null) {
            for (Node n: root.children) {
                result.addAll(postorder(n));
            }
        }
        result.add(root.val);
        return result;
    }

    /**
     * 605. Can Place Flowers
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int l = flowerbed.length;
        if(l == 1 && flowerbed[0] == 0) return true;
        if(l > 1 && flowerbed[0] == 0 && flowerbed[1] == 0){
            n--;
            flowerbed[0] = 1;
        }

        if(n <= 0) return true;

        for(int i = 1; i < l - 1; i++){
            if(flowerbed[i] == 0 && flowerbed[i-1]== 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n --;
            }
            if(n <= 0) return true;
        }

        if(flowerbed[l-1] == 0 && flowerbed[l-2] == 0) {
            n --;
            if(n <=0 ) return true;
        }
        return false;
    }

    /**
     * 617. Merge Two Binary Trees
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null ;
        if (t1 == null && t2 != null) return t2;
        if (t1 != null && t2 == null) return t1;
        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left,t2.left) ;
            t1.right = mergeTrees(t1.right,t2.right);
        }

        return t1;
    }

    /**
     * 637. Average of Levels in Binary Tree
     * TODO:DFS
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 1;
        Double  acc = 0.0;
        TreeNode tmpNode;
        while (queueSize > 0) {
            for(int i = 0; i < queueSize; i ++) {
                tmpNode = queue.remove(0);
                if(tmpNode.left != null) queue.add(tmpNode.left);
                if(tmpNode.right != null) queue.add(tmpNode.right);
                acc += tmpNode.val;
            }
            result.add(acc/queueSize);
            queueSize = queue.size();
            acc = 0.0;
        }

        return result;
    }

    /**
     * 657. Judge Route Circle
     */
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        for(int i = 0; i < moves.length(); i ++) {
            switch (moves.charAt(i)){
                case 'L' : h --; break;
                case 'R' : h ++; break;
                case 'D' : v --; break;
                case 'U' : v ++; break;
            }
        }
        return h == 0 && v ==0;
    }

    /**
     * 665. Non-decreasing Array
     */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i - 1] > nums[i]){
                cnt += 1;
                if(cnt > 1) return false;
                if((i >= 2 && nums[i - 2] > nums[i]) && (i < nums.length - 1 && nums[i - 1] > nums[i +1])) return false;
            }
        }
        return true;
    }

    /**
     * 669. Trim a Binary Search Tree
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val < L ) {
            return trimBST(root.right, L, R);
        } else if(root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    /**
     * 682. Baseball Game
     */
    public int calPoints(String[] ops) {

        int result = 0;
        List<Integer> scoreList = new LinkedList<>();
        int size;
        for (String op: ops) {
            size = scoreList.size();
            if(op.equals("+")) {
                if (size >= 2 ) {
                    scoreList.add(scoreList.get(size - 1) + scoreList.get(size - 2));
                }
            } else if (op.equals("D")) {
                if (size >= 1) {
                    scoreList.add(2 * scoreList.get(size - 1));
                }
            } else if (op.equals("C")) {
                scoreList.remove(size - 1);
            } else {
                scoreList.add(Integer.parseInt(op));
            }
        }

        for (Integer score: scoreList) {
            result += score;
        }
        return result;
    }


    /**
     * 693. Binary Number with Alternating Bits
     */
    public boolean hasAlternatingBits(int n) {
        int p = -1;
        while (n > 0) {
            if(n % 2 == p) return false;
            p = n % 2;
            n = n / 2;
        }
        return true;
    }

    /**
     * 695. Max Area of Island
     */
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] ==1 ) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid,i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
    }

    /**
     * 705. Design HashSet
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    class MyHashSet {
        private int[] setArray ;
        private int maxNum = 1000000;

        /** Initialize your data structure here. */
        public MyHashSet() {
            setArray = new int[maxNum];
        }

        public void add(int key) {
            setArray[key] = 1;
        }

        public void remove(int key) {
            setArray[key] = 0;
        }

        /** Returns true if this set did not already contain the specified element */
        public boolean contains(int key) {
            return 1 == setArray[key];
        }
    }

    /**
     * 709. To Lower Case
     */
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 728. Self Dividing Numbers
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int number ;
        int digit ;
        for ( int i = left; i <= right; i ++ ) {
            number = i ;
            while(number > 0) {
                digit = number % 10 ;
                if (digit == 0 || i % digit != 0) {
                    number = - 10;
                    break;
                }
                number = number / 10 ;
            }
            if(number == 0) result.add(i) ;
        }
        return result;
    }

    /**
     * 762. Prime Number of Set Bits in Binary Representation
     */
    public int countPrimeSetBits(int L, int R) {
        ArrayList result = new ArrayList();
        Integer[] prime = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        HashSet primeSet = new HashSet(Arrays.asList(prime));
        // Collections.addAll(primeSet, prime);
        int tmp;
        int count = 0;
        for(int i = L; i <= R; i ++){
            tmp = i;
            while (tmp > 0) {
                if((tmp & 1) == 1) count ++;
                tmp >>>= 1;
            }
            if(primeSet.contains(count)) result.add(i);
            count = 0;
        }
        return result.size();
    }

    /**
     * 766. Toeplitz Matrix
     * TODO: 遍历，与右下角元素比较
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int v = matrix.length;
        int h = matrix[0].length;
        int pivot;
        for (int i = -v + 1; i < h; i ++) {
            if(i < 0) {
                pivot = matrix[-i][0];
            } else {
                pivot = matrix[0][i];
            }
            for(int j = 1; j < v; j ++) {
                if(i + j < h && i + j >= 0 && matrix[j][i + j] != pivot) return false;
            }
        }
        return true;
    }

    /**
     * 784. Letter Case Permutation
     * TODO : rank 1 method.
     */
    public List<String> letterCasePermutation(String S) {
        int l = S.length();
        S = S.toLowerCase();
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        int queueSize;
        String tmp;
        char s;
        for (int i = 0; i < l; i ++) {
            queueSize = queue.size();
            s = (char)(S.charAt(i) - 32);
            if (s >= 'A' && s <= 'Z' ) {
                while (queueSize > 0) {
                    tmp = queue.poll();
                    queue.offer(tmp);
                    queue.offer(tmp.substring(0,i) + s + tmp.substring(i + 1));
                    queueSize --;
                }
            }
        }
        return new ArrayList<>(queue);
    }

    // method 2 :
    public static  List<String> letterCasePermutation2(String S) {
        int count = 0;
        char[] str = S.toLowerCase().toCharArray();
        for (int i=0; i<str.length; i++) {
            if (Character.isLetter(str[i])) {
                count++;
            }
        }

        int size = 1 << count;
        return new java.util.AbstractList<String>() {
            char[] temp = Arrays.copyOf(str,str.length);
            @Override
            public String get(int index) {
                for (int i=0; i<str.length; i++) {
                    temp[i] = str[i];
                    if (Character.isLetter(str[i])) {
                        if ( (index & 1) > 0) {
                            temp[i] = Character.toUpperCase(str[i]);
                        }
                        index >>>= 1;
                    }
                }
                return new String(temp);
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    /**
     * 804. Unique Morse Code Words
     */
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> uniqueCode = new HashSet<>();
        int i;
        String tmp ;
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word: words) {
            tmp = "";
            for(i = 0; i < word.length(); i ++) {
                tmp = tmp + morse[(int)word.charAt(i)-97];
            }
            uniqueCode.add(tmp);
        }
        return uniqueCode.size();
    }

    /**
     * 806. Number of Lines To Write String
     */
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[]{1,0};
        for (char c: S.toCharArray()) {
            if ( result[1] + widths[c - 97] > 100) {
                result[0] ++;
                result[1] = 0;
            }
            result[1] += widths[c - 97];
        }
        return result;
    }

    /**
     * 807. Max Increase to Keep City Skyline
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0 ;
        int[] horizon = new int[grid.length] ;
        int[] vertical = new int[grid[0].length] ;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] > vertical[j]) vertical[j] = grid[i][j] ;
                if(grid[i][j] > horizon[i]) horizon[i] = grid[i][j] ;
            }
        }

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                result = result + Math.min(horizon[i],vertical[j]) - grid[i][j];
            }
        }

        return result;
    }

    /**
     * 811. Subdomain Visit Count
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String cpdomain: cpdomains) {
            Integer times = Integer.parseInt(cpdomain.split(" ")[0]);
            String domain = cpdomain.split(" ")[1];
            map.computeIfPresent(domain, (num,val) -> val + times);
            map.putIfAbsent(domain,times);
//            map.put(domain, map.getOrDefault(domain, 0) + times);
            for(int i = 0; i < domain.length(); i ++) {
                if(domain.charAt(i) == '.') {
                    map.computeIfPresent(domain.substring(i + 1), (num,val) -> val + times);
                    map.putIfAbsent(domain.substring(i + 1),times);
//                    map.put(domain.substring(i + 1), map.getOrDefault(domain.substring(i + 1), 0) + times);
                }
            }

        }
        List<String> result = new LinkedList<>();
        map.forEach((id,val) -> result.add(val + " " + id));
        return result;
    }

    /**
     * 812. Largest Triangle Area
     */
    public double largestTriangleArea(int[][] points) {
        double result = 0;
        int pointNum = points.length;
        for (int i = 0; i < pointNum; i ++){
            for (int j = i + 1; j < pointNum; j ++){
                for(int k = j + 1; k < pointNum; k ++){
                    result = Math.max(result, 0.5 * Math.abs(points[i][0] * points[j][1] + points[j][0] * points[k][1] + points[k][0] * points[i][1] - points[i][0] * points[k][1] - points[j][0] * points[i][1] - points[k][0] * points[j][1] ) );
                }
            }
        }
        return result;
    }

    /**
     * 821. Shortest Distance to a Character
     */
    public int[] shortestToChar(String S, char C) {
        int l = S.length() ;
        int[] result = new int[l] ;
        int p = -l ;
        for(int i = 0; i < l; i ++) {
            if (S.charAt(i) == C) p = i ;
            result[i] = i - p ;
        }

        for(int j = l - 1; j >= 0; j --) {
            if (S.charAt(j) == C) p = j ;
            result[j] = Math.min(result[j],Math.abs(p - j));
        }

        return result;
    }

    /**
     * 824. Goat Latin
     */
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String a = "a";

        for (String word: words) {
            if(word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u'
                    || word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U') {
                sb.append(word).append("ma").append(a);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma").append(a);
            }
            sb.append(" ");
            a += "a";
        }
        return sb.toString().trim();
    }

    /**
     * 832. Flipping an Image
     */
    public int[][] flipAndInvertImage(int[][] A) {

        int tmp;
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j <= ( A[0].length - 1 ) / 2; j ++) {
                if (A[i][j] == A[i][A[0].length - j - 1]) {
                    tmp = 1 - A[i][j];
                    A[i][A[0].length - j - 1] = tmp;
                    A[i][j] = tmp;
                }
            }
        }
        return A;
    }

    /**
     * 852. Peak Index in a Mountain Array
     */
    public int peakIndexInMountainArray(int[] A) {
        int i =(A.length-1)/2;
        if(A[i] > A[i-1] && A[i] > A[i+1]) {
            return i ;
        } else {
            if(A[i] > A[i-1]) {
                return i + peakIndexInMountainArray(Arrays.copyOfRange(A,i,A.length));
            } else {
                return peakIndexInMountainArray(Arrays.copyOfRange(A,0,i+1));
            }
        }
    }

    /**
     * 860. Lemonade Change
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill: bills) {
            if(bill == 5) {
                five ++;
            } else if(bill == 10) {
                if(five <= 0) {
                    return false;
                } else {
                    five --;
                    ten ++;
                }
            } else if(bill == 20) {
                if(ten >= 1 && five >= 1) {
                    ten --;
                    five --;
                } else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 867. Transpose Matrix
     */
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for(int i = 0; i < A.length ; i ++) {
            for(int j = 0; j < A[0].length; j ++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    /**
     * 868. Binary Gap
     */
    public int binaryGap(int N) {
        int result = 0;
        while(N > 0 && (N & 1) == 0){
            N >>>= 1;
        }
        int tmp = 0;
        while (N > 0) {
            N >>>= 1;
            tmp ++ ;
            if((N & 1) == 1){
                if(tmp > result) result = tmp;
                tmp = 0;
            }
        }
        return result;
    }

    /**
     * 872. Leaf-Similar Trees
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getBinaryTreeLeaves(root1).equals(getBinaryTreeLeaves(root2));
    }

    private List<Integer> getBinaryTreeLeaves(TreeNode root){
        List<Integer> leaves = new ArrayList<>();
        if(root == null) return leaves;
        if(root.left == null  && root.right == null) {
            leaves.add(root.val);
        } else {
            leaves.addAll(getBinaryTreeLeaves(root.left));
            leaves.addAll(getBinaryTreeLeaves(root.right));
        }
        return leaves;
    }

    /**
     * 874. Walking Robot Simulation
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        HashSet<String> obs = new HashSet<>();
        for(int i = 0; i < obstacles.length; i ++){
            obs.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        int direction = 0;
        int[][] axis = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int[] position = new int[]{0,0};
        for (int command: commands) {
            if(command == -2) {
                direction = (direction + 1) % 4;
            } else if(command == -1) {
                direction = (direction + 3) % 4;
            } else {
                while (command > 0) {
                    if(obs.contains((position[0] + axis[direction][0]) + "," + (position[1] + axis[direction][1]))){
                        break;
                    }
                    position[0] = position[0] + axis[direction][0];
                    position[1] = position[1] + axis[direction][1];
                    command --;
                }
                result = Math.max(result,position[0]*position[0]+position[1]*position[1]);
            }
        }
        return result;
    }

    public int robotSim1(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 876. Middle of the Linked List
     */
    public ListNode middleNode(ListNode head) {
        int i = 1;
        ListNode result = head;
        while (head != null) {
            if(i == 0) {
                result = result.next;
                i = 2;
            }
            head = head.next;
            i --;
        }
        return result;
    }

    /**
     * 883. Projection Area of 3D Shapes
     */
    public int projectionArea(int[][] grid) {
        // like 807
        int result = 0 ;
        int[] horizon = new int[grid.length] ;
        int[] vertical = new int[grid[0].length] ;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] > vertical[j]) vertical[j] = grid[i][j] ;
                if(grid[i][j] > horizon[i]) horizon[i] = grid[i][j] ;
                if(grid[i][j] > 0) result += 1;
            }
        }

        for (int e: horizon) {
            result += e;
        }

        for (int e: vertical) {
            result += e;
        }

        return result;
    }

    /**
     * 884. Uncommon Words from Two Sentences
     */
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> dic = new HashMap<>();
        for (String word: A.split(" ")) {
            dic.put(word, dic.getOrDefault(word, 0) + 1);
        }

        for (String word: B.split(" ")) {
            dic.put(word, dic.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String word: dic.keySet()) {
            if(dic.get(word) == 1) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * 888. Fair Candy Swap
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int avg = 0;
        HashSet<Integer> bSet = new HashSet<>();
        for (int a: A) {
            avg += a;
        }

        int aSum = avg;

        for (int b: B) {
            avg += b;
            bSet.add(b);

        }
        avg >>>=1;

        for (int a: A) {
            if(bSet.contains(avg - aSum + a)){
                return new int[]{a, avg - aSum + a};
            }
        }

        return new int[]{0,0};
    }

    /**
     * 892. Surface Area of 3D Shapes
     */
    public int surfaceArea(int[][] grid) {
        int result = 0 ;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] > 0) {
                    result = result + 4 * grid[i][j] + 2 ;

                    if(i - 1 >= 0) {
                        result = result - 2 * Math.min(grid[i][j], grid[i - 1][j]);
                    }

                    if(j - 1 >= 0) {
                        result = result - 2 * Math.min(grid[i][j], grid[i][j - 1]);
                    }
                }
            }
        }
        return result;
    }

}

