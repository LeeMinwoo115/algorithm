import java.util.*;

class Solution {
    class Mine {
        int diaCount = 0;
        int ironCount = 0;
        int stoneCount = 0;
        int total = 0;
        
        Mine() {
        }
        
        void increaseDiaCount() {
            this.diaCount += 1;
            this.total += 1;
        }
        
        void increaseIronCount() {
            this.ironCount += 1;
            this.total += 1;
        }
        
        void increaseStoneCount() {
            this.stoneCount += 1;
            this.total += 1;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<Mine> list = new ArrayList<>();
        int totalCount = picks[0] + picks[1] + picks[2];
        
        Mine mine = new Mine();
        
        for (int i=0; i < minerals.length; i++) {
            if ((i!=0 && i%5 == 0)) {
                list.add(mine);
                mine = new Mine();
            }
            
            if (list.size() >= totalCount) {
                break;
            }
            
            if (minerals[i].equals("diamond")) {
                mine.increaseDiaCount();
            } else if (minerals[i].equals("iron")) {
                mine.increaseIronCount();
            } else if (minerals[i].equals("stone")) {
                mine.increaseStoneCount();
            }
            
            if (i == minerals.length - 1) {
                list.add(mine);
            }
        }
        
        list.sort((o1, o2) -> {
            if (o1.diaCount != o2.diaCount) return o2.diaCount - o1.diaCount;
            if (o1.ironCount != o2.ironCount) return o2.ironCount - o1.ironCount;
            return o2.stoneCount - o1.stoneCount;
        });
        
        int diaPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];
        
        for (Mine value: list) {
            int diaCount = value.diaCount;
            int ironCount = value.ironCount;
            int stoneCount = value.stoneCount;
            
            if (diaPick > 0) {
                answer += diaCount * 1 + ironCount * 1 + stoneCount * 1;
                diaPick -= 1;
            } else if (ironPick > 0) {
                answer += diaCount * 5 + ironCount * 1 + stoneCount * 1;
                ironPick -= 1;
            } else {
                answer += diaCount * 25 + ironCount * 5 + stoneCount * 1;
                stonePick -= 1;
            }
        }
        
        return answer;
    }
}