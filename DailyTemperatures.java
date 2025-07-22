// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Monotonic stack. Iterate through array and elements to stack if stack's peek is greater than current element
/// If st.peek is less than current element, the current element is the next greater temp for all elements in stack that are lesser than current element

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIdx = st.pop();
                res[poppedIdx] = i- poppedIdx;
            }
            st.push(i);
        }
        return res;
    }
}