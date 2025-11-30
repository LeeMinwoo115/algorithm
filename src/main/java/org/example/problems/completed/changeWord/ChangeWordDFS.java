package org.example.problems.completed.changeWord;

public class ChangeWordDFS {

	int answer;

	public int solution(String begin, String target, String[] words) {
		boolean[] checked = new boolean[words.length];
		answer = 0;

		dfs(words, begin, target, checked, 0);

		return answer;
	}

	private void dfs(
		String[] words,
		String begin,
		String target,
		boolean[] checked,
		int count
	) {
		for (int i = 0; i < words.length; i++) {
			int compare = 0;

			for (int j = 0; j<words[i].length(); j++) {
				if (begin.charAt(j) != words[i].charAt(j)) {
					compare++;
				}
			}

			if (compare == 1 && !checked[i]) {
				if (target.equals(words[i])) {
					answer = answer == 0 ? count + 1 : Math.min(answer, count + 1);
					return;
				}

				checked[i] = true;
				dfs(words, words[i], target, checked, count + 1);
				checked[i] = false;
			}
		}
	}
}
