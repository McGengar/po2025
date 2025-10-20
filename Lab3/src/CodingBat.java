public  class CodingBat {
    public int sumDouble(int a, int b) {
        return (a+b) * (1 +((a!=b) ? 0 : 1 ));
    }
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return !aSmile^bSmile;
    }
    public int countEvens(int[] nums) {
        int evens = 0;
        for(int i=0; nums.length>i;i++) {
            if(nums[i]%2==0) {
                evens++;
            }
        }
        return evens;
    }
    public String helloName(String name) {
        return "Hello ".concat(name).concat("!");
    }

}