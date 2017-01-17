package conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.Constants;


public class Tokenizer {

    private ArrayList<Pattern> patterns;
    private ArrayList<Token> tokens;

    public Tokenizer(List<String> variables) {
        patterns = new ArrayList<Pattern>();
        tokens = new ArrayList<Token>();

        this.add(Constants.FUNCTIONS); // function
        this.add("\\("); // open bracket
        this.add("\\)"); // close bracket
        this.add("[+-]"); // plus or minus
        this.add("[*/]"); // mult or divide
        this.add("\\^"); // raised
        this.add(Constants.NUMBERS); // integer number
        StringBuilder vars = new StringBuilder();
        for (String variable : variables) {
            vars.append(variable);
        }
        this.add("[" + vars.toString() + "]"); // variables
    }

    public void add(String regex) {
        patterns.add(Pattern.compile("^(" + regex + ")"));
    }

    public void tokenize(String str) {
        String s = str.trim();
        tokens.clear();
        while (!s.equals("")) {
            boolean match = false;
            for (int i = 0; i < patterns.size(); i++) {
                Matcher m = patterns.get(i).matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    s = m.replaceFirst("").trim();
                    tokens.add(new Token(tok, i));
                    break;
                }
            }
            if (!match)
                throw new IllegalArgumentException("Unexpected character in input: " + s);
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}