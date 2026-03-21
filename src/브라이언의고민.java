public class 브라이언의고민 {
    class Solution {
        class Pair {
            StringBuilder newCurrentWord;
            StringBuilder currentWord;
            int index;
            boolean isPossible;

            char inner = '\0';
            Pair(StringBuilder newCurrentWord, StringBuilder currentWord, int index, boolean isPossible) {
                this.newCurrentWord = newCurrentWord;
                this.currentWord = currentWord;
                this.index = index;
                this.isPossible = isPossible;
            }

            void setInner(char inner) {
                this.inner = inner;
            }
        }
        private boolean isSmallLetter(char x) {
            return (x >= 'a' && x <= 'z');
        }

        private boolean isCapitalLetter(char x) {
            return (x >= 'A' && x <= 'Z');
        }

        private Pair rule1Check(String sentence, int index, StringBuilder currentWord) {
            if (currentWord.length() == 0) {
                return new Pair(null, null,  index,false);
            }

            char last = currentWord.charAt(currentWord.length() - 1);

            StringBuilder newCurrentWord = new StringBuilder();

            if (isSmallLetter(last)) {
                return new Pair(null, null, index,false);
            }

            if (index == sentence.length() -1 || isSmallLetter(sentence.charAt(index + 1))) {
                return new Pair(null, null, index,false);
            }

            newCurrentWord.append(last);
            newCurrentWord.append(sentence.charAt(index + 1));

            for (int i=index + 2; i <sentence.length(); i+=2) {
                if (sentence.charAt(index) == sentence.charAt(i)) {
                    if (i + 1 == sentence.length() || isSmallLetter(sentence.charAt(i + 1))) {
                        return new Pair(null, null, index,false);
                    }
                    else if (isCapitalLetter(sentence.charAt(i + 1))) {
                        newCurrentWord.append(sentence.charAt(i + 1));
                    }
                    else {
                        return new Pair(null, null, index, false);
                    }
                } else {
                    return new Pair(newCurrentWord, new StringBuilder(currentWord.substring(0, currentWord.length() - 1)), i,true);
                }
            }
            return new Pair(newCurrentWord, new StringBuilder(currentWord.substring(0, currentWord.length() - 1)), sentence.length(),true);
        }

        private Pair rule2Check(String sentence, int index, StringBuilder currentWord) {
            StringBuilder newCurrentWord = new StringBuilder();

            boolean flag = false;

            for (int i=index + 1; i<sentence.length(); i++) {
                if (sentence.charAt(i) == sentence.charAt(index)) {
                    if (newCurrentWord.length() == 0) {
                        return new Pair(null, null, index, false);
                    }
                    if (flag) {
                        Pair rule1Pair = rule1Check(sentence.substring(index + 2, i), 0, new StringBuilder().append(newCurrentWord.charAt(0)));
                        if (rule1Pair.isPossible && rule1Pair.index == (i - (index + 2))) {
                            Pair pair = new Pair(newCurrentWord, currentWord, i + 1, true);
                            pair.setInner(sentence.charAt(index + 2));
                            return pair;
                        }
                        return new Pair(null, null, index, false);
                    }
                    return new Pair(newCurrentWord, currentWord, i + 1, true);
                }

                if (isCapitalLetter(sentence.charAt(i))) {
                    newCurrentWord.append(sentence.charAt(i));
                }
                else if (isSmallLetter(sentence.charAt(i))) {
                    flag = true;
                }
            }

            return new Pair(null, null, index, false);
        }

        private void rulePop(String sentence, int index, boolean[] ruleUsed, StringBuilder answer, StringBuilder currentWord, Pair rulePair) {
            ruleUsed[sentence.charAt(index) - 'a'] = true;
            if (rulePair.currentWord.length() != 0) {
                answer.append(rulePair.currentWord);
                answer.append(" ");
            }
            if (isSmallLetter(rulePair.inner)) {
                ruleUsed[rulePair.inner - 'a'] = true;
            }

            answer.append(rulePair.newCurrentWord);
            answer.append(" ");
            currentWord.delete(0, currentWord.length());
        }

        private void rule2Pop() {

        }
        public String solution(String sentence) {
            StringBuilder answer = new StringBuilder();
            StringBuilder currentWord = new StringBuilder();

            boolean[] ruleUsed = new boolean[26];

            int index = 0;

            while (index < sentence.length()) {
                if (isSmallLetter(sentence.charAt(index))) {
                    Pair rule1Pair = rule1Check(sentence, index, currentWord);
                    Pair rule2Pair = rule2Check(sentence, index, currentWord);

                    Pair currentPair = null;

                    if (ruleUsed[sentence.charAt(index) - 'a']) {
                        return "invalid";
                    }

                    if (rule1Pair.isPossible && rule2Pair.isPossible) {
                        if (rule1Pair.index - index == 3 || rule1Pair.index - index > 5) {
                            currentPair = rule1Pair;
                        }
                        else {
                            currentPair = rule2Pair;
                        }
                    }

                    else if (rule1Pair.isPossible) {
                        currentPair = rule1Pair;
                    }

                    else if (rule2Pair.isPossible) {
                        currentPair = rule2Pair;
                    }
                    else {
                        return "invalid";
                    }

                    rulePop(sentence, index, ruleUsed, answer, currentWord, currentPair);
                    index = currentPair.index;
                }
                else if (isCapitalLetter(sentence.charAt(index))) {
                    currentWord.append(sentence.charAt(index));
                    index++;
                }
                else {
                    return "invalid";
                }
            }

            answer.append(currentWord);

            return answer.toString().trim();
        }
    }
    public static void main(String[] args) {
        브라이언의고민 outer = new 브라이언의고민();
        브라이언의고민.Solution solution = outer.new Solution();
        System.out.println(solution.solution("AbAaAbAaCa"));
    }
}
