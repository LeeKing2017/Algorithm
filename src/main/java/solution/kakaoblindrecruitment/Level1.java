package solution.kakaoblindrecruitment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * 코딩테스트 연습 -> 2023 KAKAO BLIND RECRUITMENT -> 개인정보 수집 유효기간
 */
public class Level1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<String> termsType = new ArrayList<>();
        ArrayList<String> termsMonth = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayTime = LocalDate.parse(today, formatter);
        int answerIndex = 1;
        ArrayList<Integer> answerList = new ArrayList<>();

        for (String term : terms) {
            String[] s = term.split(" ");
            termsType.add(s[0]);
            termsMonth.add(s[1]);
        }

        for (String privacy : privacies) {
            String[] privacySplit = privacy.split(" ");
            LocalDate privacyDate = LocalDate.parse(privacySplit[0], formatter);
            int i = termsType.indexOf(privacySplit[1]);
            long privacyType = Long.parseLong(termsMonth.get(i));

            if (privacyDate.plusMonths(privacyType).compareTo(todayTime) <= 0){
                answerList.add(answerIndex);
            }
            answerIndex++;
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
