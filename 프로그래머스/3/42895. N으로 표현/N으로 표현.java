import java.util.*;

class Solution {
    
    String[] operations = {"plus", "minus", "mul", "divide", "concat"};
    
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i<8; i++) {
            Set<Integer> set = new HashSet<>();
            
            if (i == 0) {
                set.add(N);
            }else {
                addSetValue(list, set, i, N);
            }
            
            list.add(set);
        }
        
        for (int i = 0; i<8; i++) {
            Set<Integer> values = list.get(i);
            
            for (int value: values) {
                if (value == number) {
                    return i+1;
                }
            }
        }
        
        return -1;
    }
    
    private void addSetValue(List<Set<Integer>> list, Set<Integer> set, int index, int N) {
        for (int i=0; i<index; i++) {
            int i0 = i;
            int i1 = index - i - 1;
            
            Set<Integer> set0 = list.get(i0);
            Set<Integer> set1 = list.get(i1);
            
            for (Integer a0: set0) {
                for (Integer a1: set1) {
                    for (String operation: operations) {
                        if (operation.equals("plus")) {
                            set.add(a0 + a1);
                        }

                        if (operation.equals("minus")) {
                            set.add(a0 - a1);
                            set.add(a1 - a0);
                        }

                        if (operation.equals("mul")) {
                            set.add(a0*a1);
                        }

                        if (operation.equals("divide")) {
                            if (a1 != 0) {
                                set.add(a0 / a1);
                            }

                            if (a0 != 0) {
                                set.add(a1 / a0);   
                            }
                        }

                        if (operation.equals("concat")) {
                            int value = N;
                            for (int j=0; j<index; j++) {
                                value = value * 10 + N;
                            }

                            set.add(value);
                        }
                    }
                }
            } 
        }
    }
}