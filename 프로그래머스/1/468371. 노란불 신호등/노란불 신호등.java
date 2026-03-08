class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int[] period = new int[n];
        int oneCycleValue = 1;
        
        for (int i = 0; i<n; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            period[i] = g + y + r;
            oneCycleValue = oneCycle(oneCycleValue, period[i]);
        }
        
        for (int t=1; t<= oneCycleValue; t++) {
            boolean allYellow = true;
            
            for (int i=0; i<n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int p = period[i];
                
                int pos = (t - 1) % p;
                
                if (!(g<=pos && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
        }
        
        return -1;
    }
    
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    private int oneCycle(int a, int b) {
        return a / gcd(a, b) * b;
    }
}