class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int remain = n % w;
        int xLength = remain == 0 ? n/w : n/w + 1;
        
        int[][] arr = new int[xLength][w];
        
        for (int i = 0; i<xLength; i++) {
            for (int j=1; j<= w; j++) {
                int number = 0;
                
                if (i % 2 == 0) {
                    number = w * i + j;
                } else {
                    number = w * (i + 1) - (j - 1);
                }
                
                if (number > n) {
                    number = 0;
                }
                
                arr[i][j - 1] = number;
            }
        }
        
        for (int i=0; i<xLength; i++) {
            for (int j=0; j<w; j++) {
                if (arr[i][j] == num) {
                    if (arr[xLength - 1][j] == 0) {
                        answer = xLength - 1 - i;
                    } else {
                        answer = xLength - i;
                    }
                }
            }
        }
        
        return answer;
    }
}