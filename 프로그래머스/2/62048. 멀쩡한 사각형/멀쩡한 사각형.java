class Solution {
	public long solution(int w,int h) {
        
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        
		return (wl*hl) - (wl+hl-gcd(wl,hl));
	}
    
    public long gcd(long w, long h){
        long small, big;
        
        big = w>=h? w:h;
        small = w<h? w:h;
        
        while(small!=0){
            long remain = big%small;
            big = small;
            small = remain;
        }
        return big;
    }
    
}