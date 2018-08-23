package org.sweetycode.leetcode;

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
     * 237. Delete Node in a Linked List
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

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
     * 292. Nim Game
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
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
     * 887. 三维形体投影面积
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
}
