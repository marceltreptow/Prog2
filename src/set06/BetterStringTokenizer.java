package set06;

import java.util.StringTokenizer;

class BetterStringTokenizer extends StringTokenizer {
    public BetterStringTokenizer(String str) {
        super(str);
    }

    @Override
    public String nextToken() {
        String word = super.nextToken();
        for (int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 46 || word.charAt(i) == 44){
                word = word.replace(word.charAt(i),' ');

            }
        }
        return word;

    }

    @Override
    public boolean hasMoreElements() {
        return super.hasMoreElements();

    }
}