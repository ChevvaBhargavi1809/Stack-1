// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Monotonic stack. Iterate through array. If current element is > st.peek(), current element is the next greater element
/// for all elements in stack until st.peek()>curr. If at the end there are still elements in stack, iterate through array again, this time look for elements greater than st.peek only
/// don't add to stack in 2nd pass

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                res[popped] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return res;
    }
}