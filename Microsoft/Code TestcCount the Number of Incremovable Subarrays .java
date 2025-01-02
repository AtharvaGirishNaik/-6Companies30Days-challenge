class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count  = 0 ;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(is_incremovable(nums , i , j , n)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean is_incremovable(int a [], int x , int y , int n ){
        int prv = 0;
        for(int i = 0 ; i < n ; i++){
            if(i >= x && i <= y){
                continue;
            }else if(a[i] <= prv){
                return false;
            }
            prv = a[i];
        }
        return true;
    }
}
