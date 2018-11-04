package org.sweetycode.leetcode;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.sweetycode.leetcode.util.ConvertUtil;
import org.sweetycode.leetcode.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @since <pre>Jul 5, 2018</pre>
 * @version 1.0
 */
public class SolutionTest {

    Solution solution = new Solution();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 1. Two Sum
     * Method: twoSum(int[] nums, int target)
     *
     */
    @Test
    public void testTwoSum() throws Exception {
        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(solution.twoSum(nums,6)));
    }


    public static ListNode arrayToListNode(int[] a) {
        if(a == null) return null;
        ListNode result = new ListNode(a[0]);
        ListNode flag = result;
        for (int i = 1 ; i < a.length; i ++) {
            flag.next = new ListNode(a[i]);
            flag = flag.next;
        }
        return result;
    }

    /**
     * 2. Add Two Numbers
     * Method: addTwoNumbers(ListNode l1, ListNode l2)
     *
     */
    @Test
    public void testAddTwoNumbers() throws Exception {
        int[] a2 = new int[]{2, 4};
        int[] a1 = new int []{5, 6, 4};

        ListNode l1 = arrayToListNode(a1);
        ListNode l2 = arrayToListNode(a2);
        ListNode result = solution.addTwoNumbers(l1,l2);

        String  l= "" + result.val;
        while(result.next != null) {
            result = result.next;
            l = l + "," + result.val;
        }
        System.out.println(l);

    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * Method: lengthOfLongestSubstring(String s)
     *
     */
    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        //System.out.println(solution.lengthOfLongestSubstring("qufmtrybowpuqogwczuqxisjyryjpyxiucuovu"));
    }

    /**
     * 4. Median of Two Sorted Arrays
     * Method: findMedianSortedArrays(int[] nums1, int[] nums2)
     *
     */
    @Test
    public void testFindMedianSortedArrays() throws Exception {

    }

    /**
     * 7. Reverse Integer
     */
    @Test
    public void testReverse() throws Exception {
        System.out.println(solution.reverse(-463847412));
        System.out.println(solution.reverse(463847412));
    }

    /**
     * 9. Palindrome Number
     */
    @Test
    public void testIsPalindrome() throws Exception {
        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(1111));
        System.out.println(solution.isPalindrome(121));
    }

    /**
     * 14. Longest Common Prefix
     */
    @Test
    public void testLongestCommonPrefix() throws Exception {
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"aa","a"}));
    }

    /**
     * 20. Valid Parentheses
     */
    @Test
    public void testIsValid() throws Exception {
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }

    /**
     * 21. Merge Two Sorted Lists
     */
    @Test
    public void testMergeTwoLists() throws Exception {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        listNode1.next = listNode2; listNode2.next = listNode4;
        l1.next = l3; l3.next = l4;
        PrintUtil.printListNode(solution.mergeTwoListsNew(listNode1,l1));
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     */
    @Test
    public void testRemoveDuplicates() throws Exception {
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(solution.removeDuplicates(new int[]{1,1,2}));
    }

    /**
     * 27. Remove Element
     */
    @Test
    public void testRemoveElement() throws Exception {
        System.out.println(solution.removeElement(new int[]{4,5}, 4)); // 1
        System.out.println(solution.removeElement(new int[]{4,5}, 5)); // 1
        System.out.println(solution.removeElement(new int[]{3,2,2,3}, 3)); // 2
        System.out.println(solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2)); // 5
    }
    @Test
    public void testRemoveElement2() throws Exception {
        System.out.println(solution.removeElement2(new int[]{}, 4)); // 1
        System.out.println(solution.removeElement2(new int[]{4,5}, 4)); // 1
        System.out.println(solution.removeElement2(new int[]{4,5}, 5)); // 1
        System.out.println(solution.removeElement2(new int[]{3,2,2,3}, 3)); // 2
        System.out.println(solution.removeElement2(new int[]{0,1,2,2,3,0,4,2}, 2)); // 5
    }

    /**
     * 28. Implement strStr()
     */
    @Test
    public void testStrStr() throws Exception {
        System.out.println(solution.strStr("Hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("aaaaa", ""));
    }

    /**
     * 35. Search Insert Position
     */
    @Test
    public void testSearchInsert() throws Exception {
        assertEquals (solution.searchInsert(new int[]{1,3,5,6}, 5), 2);
        assertEquals (solution.searchInsert(new int[]{1,3,5,6}, 2), 1);
        assertEquals (solution.searchInsert(new int[]{1,3,5,6}, 7), 4);
        // assertEquals (solution.searchInsert(new int[]{1,3,5,6}, 0), 0);

    }

    /**
     * 38. Count and Say
     */
    @Test
    public void testCountAndSay() throws Exception {
        assertEquals(solution.countAndSay(1), "1");
        assertEquals(solution.countAndSay(2), "11");
        assertEquals(solution.countAndSay(3), "21");
        assertEquals(solution.countAndSay(4), "1211");
        assertEquals(solution.countAndSay(5), "111221");
        assertEquals(solution.countAndSay(6), "312211");
    }

    /**
     * 53. Maximum Subarray
     */
    @Test
    public void testMaxSubArray() throws Exception {
        assertEquals(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
        assertEquals(solution.maxSubArray(new int[]{8,-19,5,-4,20}), 21);
    }

    @Test
    public void testMaxSubArray2() throws Exception {
        assertEquals(solution.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
        assertEquals(solution.maxSubArray2(new int[]{8,-19,5,-4,20}), 21);
    }

    /**
     * 58. Length of Last Word
     */
    @Test
    public void testLengthOfLastWord() throws Exception {
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord("hello test "));
    }

    /**
     * 66. Plus One
     */
    @Test
    public void testPlusOne() throws Exception {
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9,9})));
    }

    /**
     * 67. Add Binary
     */
    @Test
    public void testAddBinary() throws Exception {
        assertEquals("100", solution.addBinary("11", "1"));
        assertEquals("10101", solution.addBinary("1010", "1011"));
        assertEquals("1000", solution.addBinary("1", "111"));
    }

    /**
     * 69. Sqrt(x)
     */
    @Test
    public void testMySqrt() throws Exception {
        assertEquals(2 , solution.mySqrt(4));
        assertEquals(2, solution.mySqrt(8));
        assertEquals(1, solution.mySqrt(1));
        assertEquals(0, solution.mySqrt(0));
        assertEquals(46339, solution.mySqrt(2147395599));
    }

    /**
     * 70. Climbing Stairs
     */
    @Test
    public void testClimbStairs() throws Exception {
        assertEquals(3, solution.climbStairs(3));
    }
    
    /**
     * 83. Remove Duplicates from Sorted List
     */
    @Test
    public void testDeleteDuplicates() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        assertEquals("1->2", PrintUtil.printListNode(solution.deleteDuplicates(n1)));

        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(1);
        ListNode v3 = new ListNode(2);
        ListNode v4 = new ListNode(3);
        ListNode v5 = new ListNode(3);
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        assertEquals("1->2->3", PrintUtil.printListNode(solution.deleteDuplicates(v1)));
    }

    /**
     * 88. Merge Sorted Array
     */
    @Test
    public void testMerge() throws Exception {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        solution.merge(nums1, 3, new int[]{2,5,6}, 3);
        assertEquals(true, Arrays.equals(new int[]{1,2,2,3,5,6},nums1));

        nums1 = new int[]{5,9,10,0,0,0,0};
        solution.merge(nums1, 3, new int[]{2,4,8,11}, 4);
        assertEquals(true, Arrays.equals(new int[]{2,4,5,8,9,10,11},nums1));
    }

    /**
     * 100. Same Tree
     */
    @Test
    public void testIsSameTree() throws Exception {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);

        assertEquals(false, solution.isSameTree(t1, t2));


        TreeNode s1 = new TreeNode(1);
        s1.left = new TreeNode(2);
        s1.right = new TreeNode(1);

        TreeNode s2 = new TreeNode(1);
        s2.left = new TreeNode(1);
        s2.right = new TreeNode(2);

        assertEquals(false, solution.isSameTree(s1, s2));
    }

    /**
     * 101. Symmetric Tree
     */
    @Test
    public void testIsSymmetric() throws Exception {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);
        assertEquals(true, solution.isSymmetric(t1));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(3);
        t2.right.left = new TreeNode(2);
        assertEquals(false, solution.isSymmetric(t2));

    }

    /**
     * 104. Maximum Depth of Binary Tree
     */
    @Test
    public void testMaxDepth() throws Exception {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        System.out.println(solution.maxDepth(treeNode));
    }

    /**
     * 107. Binary Tree Level Order Traversal II
     */
    @Test
    public void testLevelOrderBottom() throws Exception {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        System.out.println(solution.levelOrderBottom(treeNode3));

    }

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     */
    @Test
    public void testSortedArrayToBST() throws Exception {
        TreeNode treeNode =  solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    /**
     * 110. Balanced Binary Tree
     */
    @Test
    public void testIsBalanced() throws Exception {
        TreeNode t1 = ConvertUtil.stringToTreeNode("[3,9,20,null,null,15,7]");
        assertEquals(true, solution.isBalanced(t1));

        TreeNode t2 = ConvertUtil.stringToTreeNode("[1,2,2,3,3,null,null,4,4]");
        assertEquals(false, solution.isBalanced(t2));

        TreeNode t3 = ConvertUtil.stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]");
        assertEquals(false, solution.isBalanced(t3));
    }

    /**
     * 111. Minimum Depth of Binary Tree
     */
    @Test
    public void testMinDepth() throws Exception {
        TreeNode t1 = ConvertUtil.stringToTreeNode("[3,9,20,null,null,15,7]");
        assertEquals(2, solution.minDepth(t1));

        TreeNode t3 = ConvertUtil.stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]");
        assertEquals(4, solution.minDepth(t3));
    }

    /**
     * 112. Path Sum
     */
    @Test
    public void testHasPathSum() throws Exception {
        TreeNode t1 = ConvertUtil.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        assertEquals(false, solution.hasPathSum(t1, 17));
        assertEquals(true, solution.hasPathSum(t1, 18));
    }

    /**
     * 118. Pascal's Triangle
     */
    @Test
    public void testGenerate() throws Exception {
        System.out.println(solution.generate(4));
    }

    /**
     * 119. Pascal's Triangle II
     */
    @Test
    public void testGetRow() throws Exception {
        System.out.println(solution.getRow(4));
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     */
    @Test
    public void testMaxProfit() throws Exception {
        assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(14, solution.maxProfit(new int[]{7,9,14,2,1,15}));
    }

    /**
     * 122. Best Time to Buy and Sell Stock II
     */
    @Test
    public void testMaxProfitII() throws Exception {
        assertEquals(7, solution.maxProfitII(new int[]{7,1,5,3,6,4}));
        assertEquals(4, solution.maxProfitII(new int[]{1,2,3,4,5}));
        assertEquals(0, solution.maxProfitII(new int[]{7,6,4,3,1}));
    }
    @Test
    public void testMaxProfitII2() throws Exception {
        assertEquals(7, solution.maxProfitII2(new int[]{7,1,5,3,6,4}));
        assertEquals(4, solution.maxProfitII2(new int[]{1,2,3,4,5}));
        assertEquals(0, solution.maxProfitII2(new int[]{7,6,4,3,1}));
    }

    /**
     * 125. Valid Palindrome
     */
    @Test
    public void testIsPalindromeString() throws Exception {
        assertEquals(true, solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(false, solution.isPalindrome("race a car"));
        assertEquals(true, solution.isPalindrome(" "));
    }

    /**
     * 136. Single Number
     */
    @Test
    public void testSingleNumber() throws Exception {
        System.out.println(solution.singleNumber(new int[]{4,4,1,2,1,2,0}));
    }

    /**
     * 141. Linked List Cycle
     */
    @Test
    public void testHasCycle2() throws Exception {
        assertEquals(false, solution.hasCycle2(ConvertUtil.stringToListNode("[1,2,3,4]")));
    }

    /**
     * 155. Min Stack
     */
    @Test
    public void testMinStack() throws Exception {
        Solution.MinStack minStack = solution.new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());

        Solution.MinStack minStack2 = solution.new MinStack();
        minStack2.push(512);
        minStack2.push(-1024);
        minStack2.push(-1024);
        minStack2.push(512);
        minStack2.pop();
        assertEquals(-1024, minStack2.getMin());
        minStack2.pop();
        assertEquals(-1024, minStack2.getMin());
        minStack2.pop();
        assertEquals(512, minStack2.getMin());
    }

    /**
     * 160. Intersection of Two Linked Lists
     */
    @Test
    public void testGetIntersectionNode() throws Exception {
        ListNode l3 = ConvertUtil.stringToListNode("[6,7,8]");
        ListNode l1 = ConvertUtil.stringToListNode("[1,2]");
        ListNode l2 = ConvertUtil.stringToListNode("[3,4,5]");
        l1.next.next = l3;
        l2.next.next.next = l3;
        assertEquals(6, solution.getIntersectionNode(l1,l2).val);
    }
    
    /**
     * 167. Two Sum II - Input array is sorted
     */
    @Test
    public void testTwoSumII() throws Exception {
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(solution.twoSumII(new int[]{2,7,11,15}, 9)));
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(solution.twoSumII(new int[]{-1,0,-1}, -1)));
    }
    @Test
    public void testTwoSumII2() throws Exception {
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(solution.twoSumII2(new int[]{2,7,11,15}, 9)));

    }

    /**
     * 168. Excel Sheet Column Title
     */
    @Test
    public void testConvertToTitle() throws Exception {
        assertEquals("AAA", solution.convertToTitle(703));
        assertEquals("ZY", solution.convertToTitle(701));
        assertEquals("AB", solution.convertToTitle(28));
        assertEquals("A", solution.convertToTitle(1));
    }

    /**
     * p169. Majority Element
     */
    @Test
    public void testMajorityElement() throws Exception {
        System.out.println(solution.majorityElement(new int[]{0,0,2,2,2,0,0}));
        System.out.println(solution.majorityElement(new int[]{3,2,3}));
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    /**
     * 171. Excel Sheet Column Number
     */
    @Test
    public void testTitleToNumber() throws Exception {
        System.out.println(solution.titleToNumber("ZY"));
        System.out.println(solution.titleToNumber("A"));
    }


    /**
     * 172. Factorial Trailing Zeroes
     */
    @Test
    public void testTrailingZeroes() throws Exception {
        assertEquals(0, solution.trailingZeroes(3));
        assertEquals(1, solution.trailingZeroes(5));
        assertEquals(3, solution.trailingZeroes(16));
        assertEquals(249, solution.trailingZeroes(1000));
    }

    /**
     * 189. Rotate Array
     */
    @Test
    public void testRotate() throws Exception {
        int[] a1 = new int[]{1,2,3,4,5,6,7};
        solution.rotate(a1,3);
        assertEquals(Arrays.toString(new int[]{5,6,7,1,2,3,4}), Arrays.toString(a1));

        int [] a2 = new int[]{-1,-100,3,99};
        solution.rotate(a2,2);
        assertEquals(Arrays.toString(new int[]{3,99,-1,-100}), Arrays.toString(a2));
    }

    /**
     * 202. Happy Number
     */
    @Test
    public void testIsHappy() throws Exception {
        System.out.println(solution.isHappy(12));
    }

    /**
     * 206. Reverse Linked List
     */
    @Test
    public void testReverseList() throws Exception {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        PrintUtil.printListNode(solution.reverseList(listNode1));
    }

    /**
     * 226. Invert Binary Tree
     */
    @Test
    public void testInvertTree() throws Exception {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
    }

    /**
     * 237. Delete Node in a Linked List
     */
    @Test
    public void testDeleteNode() throws Exception {
    }

    /**
     * 257. Binary Tree Paths
     */
    @Test
    public void testBinaryTreePaths() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;

        System.out.println(solution.binaryTreePaths(treeNode1));
    }

    /**
     * 258. Add Digits
     */
    @Test
    public void testAddDigits() throws Exception {
        System.out.println(solution.addDigits(65434));
    }

    /**
     * 283. Move Zeroes
     */
    @Test
    public void testMoveZeroes() throws Exception {
        int nums[] = new int[]{0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 292. Nim Game
     */
    @Test
    public void testCanWinNim() throws Exception {
        System.out.println(solution.canWinNim(4));
    }

    /**
     * 344. Reverse String
     */
    @Test
    public void testReverseString() throws Exception {
        System.out.println(solution.reverseString("Hello Tian !"));
    }

    /**
     * 349. Intersection of Two Arrays
     */
    @Test
    public void testIntersection() throws Exception {
        PrintUtil.printArray(solution.intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        PrintUtil.printArray(solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
        PrintUtil.printArray(solution.intersection(new int[]{}, new int[]{}));
    }

    /**
     * 371. Sum of Two Integers
     */
    @Test
    public void testGetSum() throws Exception {
        System.out.println(solution.getSum(100,2000));
    }

    /**
     * 389. Find the Difference
     */
    @Test
    public void testFindTheDifference() throws Exception {
        System.out.println(solution.findTheDifference("afbcfd","ffabcd"));
    }

    /**
     * 412. Fizz Buzz
     */
    @Test
    public void testFizzBuzz() throws Exception {
        System.out.println(solution.fizzBuzz(16));
    }

    /**
     * 429. N-ary Tree Level Order Traversal
     */
    @Test
    public void testLevelOrder() throws Exception {
    }

    /**
     * 461. Hamming Distance
     */
    @Test
    public void testHammingDistance() throws Exception {
        System.out.println(solution.hammingDistance(1,4));
    }

    /**
     * 463. Island Perimeter
     */
    @Test
    public void testIslandPerimeter() throws Exception {
        System.out.println(solution.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));


    }

    /**
     * 476. Number Complement
     */
    @Test
    public void testFindComplement() throws Exception {
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));

    }

    /**
     * 496. Next Greater Element I
     */
    @Test
    public void testNextGreaterElement() throws Exception {
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7}))); // [7,7,7,7,7]
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); // [-1, 3, -1]
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}))); //[3, -1]
    }

    /**
     * 500. Keyboard Row
     */
    @Test
    public void testFindWords() throws Exception {
        System.out.println(Arrays.toString(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    /**
     * 520. Detect Capital
     */
    @Test
    public void testDetectCapitalUse() throws Exception {
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
        System.out.println(solution.detectCapitalUse("Flag"));
        System.out.println(solution.detectCapitalUse("I"));
        System.out.println(solution.detectCapitalUse("i"));
        System.out.println(solution.detectCapitalUse("leetcode"));
    }

    /**
     * 521. Longest Uncommon Subsequence I
     */
    @Test
    public void testFindLUSlength() throws Exception {
        System.out.println(solution.findLUSlength("aba", "cdc"));
    }

    /**
     * 557. Reverse Words in a String III
     */
    @Test
    public void testReverseWords() throws Exception {
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    /**
     * 559. Maximum Depth of N-ary Tree
     */
    @Test
    public void testMaxDepthNT() throws Exception {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node3 = new Node(3, new ArrayList<>(Arrays.asList(node5,node6)));
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node1 = new Node(1, new ArrayList<>(Arrays.asList(node3,node2,node4)));

        System.out.println(solution.maxDepthNT(node1));
    }

    /**
     * 561. Array Partition I
     */
    @Test
    public void testArrayPairSum() throws Exception {
        System.out.println(solution.arrayPairSum(new int[]{1,4,3,2,6,7}));
    }

    /**
     * 566. Reshape the Matrix
     */
    @Test
    public void testMatrixReshape() throws Exception {
        PrintUtil.printArray(solution.matrixReshape(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}},6,2));
    }

    /**
     * 575. Distribute Candies
     */
    @Test
    public void testDistributeCandies() throws Exception {
        System.out.println(solution.distributeCandies(new int[]{1,1,2,2,3,3,4,5}));
    }

    /**
     * 589. N-ary Tree Preorder Traversal
     */
    @Test
    public void testPreorder() throws Exception {
    }

    /**
     * 590. N-ary Tree Postorder Traversal
     */
    @Test
    public void testPostorder() throws Exception {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node3 = new Node(3, new ArrayList<>(Arrays.asList(node5,node6)));
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node1 = new Node(1, new ArrayList<>(Arrays.asList(node3,node2,node4)));

        System.out.println(solution.postorder(node1));
    }

    /**
     * 605. Can Place Flowers
     */
    @Test
    public void testCanPlaceFlowers() throws Exception {
        System.out.println(solution.canPlaceFlowers(new int[]{0,1,1,0,0,0,0,0,1,0,0}, 3));
    }

    /**
     * 617. Merge Two Binary Trees
     */
    @Test
    public void testMergeTrees() throws Exception {

    }

    /**
     * 637. Average of Levels in Binary Tree
     */
    @Test
    public void testAverageOfLevels() throws Exception {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        System.out.println(solution.averageOfLevels(treeNode3));
    }

    /**
     * 657. Judge Route Circle
     */
    @Test
    public void testJudgeCircle() throws Exception {
        System.out.println(solution.judgeCircle("LL"));
        System.out.println(solution.judgeCircle("UD"));
        System.out.println(solution.judgeCircle("UDLR"));
    }

    /**
     * 665. Non-decreasing Array
     */
    @Test
    public void testCheckPossibility() throws Exception {
        System.out.println(solution.checkPossibility(new int[]{1,2,5,7,4,5})); //false
        System.out.println(solution.checkPossibility(new int[]{2,3,3,2,4})); // true
    }

    /**
     * 669. Trim a Binary Search Tree
     */
    @Test
    public void testTrimBST() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode3.left = treeNode0;
        treeNode3.right = treeNode4;
        System.out.println(solution.trimBST(treeNode3,1,3));
        System.out.println("pause");
    }

    /**
     * 682. Baseball Game
     */
    @Test
    public void testCalPoints() throws Exception {
        System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    /**
     * 693. Binary Number with Alternating Bits
     */
    @Test
    public void testHasAlternatingBits() throws Exception {
        System.out.println(solution.hasAlternatingBits(10));
    }

    /**
     * 695. Max Area of Island
     */
    @Test
    public void testMaxAreaOfIsland() throws Exception {
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));

        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
    }

    /**
     * 705. Design HashSet
     */
    @Test
    public void testMyHashSet() throws Exception {
        Solution.MyHashSet hashSet = solution.new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));;    // returns true
        System.out.println(hashSet.contains(3));;    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));;    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));;    // returns false (already removed)

    }

    /**
     * 709. To Lower Case
     */
    @Test
    public void testToLowerCase() throws Exception {
        System.out.println(solution.toLowerCase("Good or Bad?"));
    }

    /**
     * 728. Self Dividing Numbers
     */
    @Test
    public void testSelfDividingNumbers() throws Exception {
        System.out.println(solution.selfDividingNumbers(100,222));
    }

    /**
     * 762. Prime Number of Set Bits in Binary Representation
     */
    @Test
    public void testCountPrimeSetBits() throws Exception {
        System.out.println(solution.countPrimeSetBits(10,15));;
    }

    /**
     * 766. Toeplitz Matrix
     */
    @Test
    public void testIsToeplitzMatrix() throws Exception {
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));// true
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1,2},{2,2}})); // false
        System.out.println(solution.isToeplitzMatrix(new int[][]{{36,59,71,15,26,82,87},{56,36,59,71,15,26,82},{15,0,36,59,71,15,26}})); // false
        System.out.println(solution.isToeplitzMatrix(new int[][]{{18},{66}})); //true
        System.out.println(solution.isToeplitzMatrix(new int[][]{{18},{66},{57}})); //true
        System.out.println(solution.isToeplitzMatrix(new int[][]{{44,35,39},{15,44,35},{17,15,44},{80,17,15},{43,80,0},{77,43,80}})); //false
    }

    /**
     * 804. Unique Morse Code Words
     */
    @Test
    public void testUniqueMorseRepresentations() throws Exception {
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));

    }

    /**
     * 806. Number of Lines To Write String
     */
    @Test
    public void testNumberOfLines() throws Exception {
        System.out.println(Arrays.toString(solution.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
    }

    /**
     * 807. Max Increase to Keep City Skyline
     */
    @Test
    public void testMaxIncreaseKeepingSkyline() throws Exception {
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{1,0,0,0}}));
    }

    /**
     * 811. Subdomain Visit Count
     */
    @Test
    public void testSubdomainVisits() throws Exception {
        System.out.println(solution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println(solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    /**
     * 812. Largest Triangle Area
     */
    @Test
    public void testLargestTriangleArea() throws Exception {
        System.out.println(solution.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }

    /**
     * 821. Shortest Distance to a Character
     */
    @Test
    public void testShortestToChar() throws Exception {
        System.out.println(Arrays.toString(solution.shortestToChar("aaba",'b')));
    }

    /**
     * 824. Goat Latin
     */
    @Test
    public void testToGoatLatin() throws Exception {
        System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
    }

    /**
     * 832. Flipping an Image
     */
    @Test
    public void testFlipAndInvertImage() throws Exception {
        PrintUtil.printArray(solution.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
        PrintUtil.printArray(solution.flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
    }

    /**
     * 852. Peak Index in a Mountain Array
     */
    @Test
    public void testPeakIndexInMountainArray() throws Exception {
        System.out.println(solution.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0,2,5,8,9,100,0}));
    }
    
    /**
     * 860. Lemonade Change
     */
    @Test
    public void testLemonadeChange() throws Exception {
        System.out.println(solution.lemonadeChange(new int[]{5,5,10,10,20}));
    }

    /**
     * 867. Transpose Matrix
     */
    @Test
    public void testTranspose() throws Exception {
        PrintUtil.printArray(solution.transpose(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
        PrintUtil.printArray(solution.transpose(new int[][]{{1,2,3},{4,5,6}}));
    }

    /**
     * 868. Binary Gap
     */
    @Test
    public void testBinaryGap() throws Exception {
        System.out.println(solution.binaryGap(129));
    }

    /**
     * 872. Leaf-Similar Trees
     */
    @Test
    public void testLeafSimilar() throws Exception {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode1.left = treeNode9;
        treeNode1.right = treeNode8;

        System.out.println(solution.leafSimilar(treeNode3,treeNode3));
    }

    /**
     * 874. Walking Robot Simulation
     */
    @Test
    public void testRobotSim() throws Exception {
        //System.out.println(solution.robotSim(new int[]{4,-1,3}, new int[][]{{}}));
        //System.out.println(solution.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));



        int[] commands = new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7};

        int[][] obstacles = new int[][]{{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22},{14,-25},{-11,69},{63,36},{35,-99},{-24,82},{-29,-98},{-50,-70},{72,95},{80,80},{-68,-40},{65,70},{-92,78},{-45,-63},{1,34},{81,50},{14,91},{-77,-54},{13,-88},{24,37},{-12,59},{-48,-62},{57,-22},{-8,85},{48,71},{12,1},{-20,36},{-32,-14},{39,46},{-41,75},{13,-23},{98,10},{-88,64},{50,37},{-95,-32},{46,-91},{10,79},{-11,43},{-94,98},{79,42},{51,71},{4,-30},{2,74},{4,10},{61,98},{57,98},{46,43},{-16,72},{53,-69},{54,-96},{22,0},{-7,92},{-69,80},{68,-73},{-24,-92},{-21,82},{32,-1},{-6,16},{15,-29},{70,-66},{-85,80},{50,-3},{6,13},{-30,-98},{-30,59},{-67,40},{17,72},{79,82},{89,-100},{2,79},{-95,-46},{17,68},{-46,81},{-5,-57},{7,58},{-42,68},{19,-95},{-17,-76},{81,-86},{79,78},{-82,-67},{6,0},{35,-16},{98,83},{-81,100},{-11,46},{-21,-38},{-30,-41},{86,18},{-68,6},{80,75},{-96,-44},{-19,66},{21,84},{-56,-64},{39,-15},{0,45},{-81,-54},{-66,-93},{-4,2},{-42,-67},{-15,-33},{1,-32},{-74,-24},{7,18},{-62,84},{19,61},{39,79},{60,-98},{-76,45},{58,-98},{33,26},{-74,-95},{22,30},{-68,-62},{-59,4},{-62,35},{-78,80},{-82,54},{-42,81},{56,-15},{32,-19},{34,93},{57,-100},{-1,-87},{68,-26},{18,86},{-55,-19},{-68,-99},{-9,47},{24,94},{92,97},{5,67},{97,-71},{63,-57},{-52,-14},{-86,-78},{-17,92},{-61,-83},{-84,-10},{20,13},{-68,-47},{7,28},{66,89},{-41,-17},{-14,-46},{-72,-91},{4,52},{-17,-59},{-85,-46},{-94,-23},{-48,-3},{-64,-37},{2,26},{76,88},{-8,-46},{-19,-68}};
        System.out.println(solution.robotSim(commands,obstacles)); //5140

        System.out.println(solution.robotSim1(commands,obstacles));


    }

    /**
     * 876. Middle of the Linked List
     */
    @Test
    public void testMiddleNode() throws Exception {
        System.out.println(solution.middleNode(arrayToListNode(new int[]{1,2,3,4,5,6})));
    }

    /**
     * 883. Projection Area of 3D Shapes
     */
    @Test
    public void testProjectionArea() throws Exception {
        System.out.println(solution.projectionArea(new int[][]{{2}}));
        System.out.println(solution.projectionArea(new int[][]{{1,2},{3,4}}));
        System.out.println(solution.projectionArea(new int[][]{{1,0},{0,2}}));
        System.out.println(solution.projectionArea(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        System.out.println(solution.projectionArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}}));
    }

    /**
     * 884. Uncommon Words from Two Sentences
     */
    @Test
    public void testUncommonFromSentences() throws Exception {
        PrintUtil.printArray(solution.uncommonFromSentences("this apple is sweet", "this apple is sour"));
        PrintUtil.printArray(solution.uncommonFromSentences("apple apple", "banana"));
    }

    /**
     * 888. Fair Candy Swap
     */
    @Test
    public void testFairCandySwap() throws Exception {
        PrintUtil.printArray(solution.fairCandySwap(new int[]{1,1}, new int[]{2,2}));
        PrintUtil.printArray(solution.fairCandySwap(new int[]{1,2}, new int[]{2,3}));
        PrintUtil.printArray(solution.fairCandySwap(new int[]{2}, new int[]{1,3}));
        PrintUtil.printArray(solution.fairCandySwap(new int[]{1,2,5}, new int[]{2,4}));
    }

    /**
     * 892. Surface Area of 3D Shapes
     */
    @Test
    public void testSurfaceArea() throws Exception {
        System.out.println(solution.surfaceArea(new int[][]{{2}}));
        System.out.println(solution.surfaceArea(new int[][]{{1,2},{3,4}}));
        System.out.println(solution.surfaceArea(new int[][]{{1,0},{0,2}}));
        System.out.println(solution.surfaceArea(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
    }
}

