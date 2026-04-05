import java.util.*;

class Solution {

    class Word {
        String word;
        int startIdx;
        int endIdx;

        Word(String word, int startIdx, int endIdx) {
            this.word = word;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = parseWords(message);

        int len = message.length();
        boolean[] covered = new boolean[len];
        int[] revealAt = new int[len]; // 0이면 스포 아님

        // 각 문자별 스포 여부 / 몇 번째 클릭에 공개되는지 기록
        for (int i = 0; i < spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for (int idx = start; idx <= end; idx++) {
                covered[idx] = true;
                revealAt[idx] = i + 1;
            }
        }

        // 공개 구간에서 "완전한 단어"로 등장한 단어들
        Set<String> publicWords = new HashSet<>();

        // step별로 완전히 공개되는 스포 단어들을 저장
        List<List<String>> revealBuckets = new ArrayList<>();
        for (int i = 0; i <= spoiler_ranges.length; i++) {
            revealBuckets.add(new ArrayList<>());
        }

        for (Word w : words) {
            boolean hasSpoiler = false;
            int fullRevealStep = 0;

            for (int idx = w.startIdx; idx <= w.endIdx; idx++) {
                if (covered[idx]) {
                    hasSpoiler = true;
                    fullRevealStep = Math.max(fullRevealStep, revealAt[idx]);
                }
            }

            // 스포가 전혀 없는 occurrence만 공개 구간의 단어로 간주
            if (!hasSpoiler) {
                publicWords.add(w.word);
            } else {
                // 스포 단어는 "완전히 공개되는 시점"에 등록
                revealBuckets.get(fullRevealStep).add(w.word);
            }
        }

        int answer = 0;
        Set<String> alreadyCounted = new HashSet<>();

        for (int step = 1; step <= spoiler_ranges.length; step++) {
            for (String word : revealBuckets.get(step)) {
                if (publicWords.contains(word)) continue;
                if (alreadyCounted.contains(word)) continue;

                alreadyCounted.add(word);
                answer++;
            }
        }

        return answer;
    }

    private List<Word> parseWords(String message) {
        List<Word> words = new ArrayList<>();

        int start = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                words.add(new Word(message.substring(start, i), start, i - 1));
                start = i + 1;
            }
        }

        words.add(new Word(message.substring(start), start, message.length() - 1));
        return words;
    }
}