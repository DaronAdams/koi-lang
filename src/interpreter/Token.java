package interpreter;

public class Token {
    final TokenType type;
    final String lexame;
    final Object literal;
    final int line;

    Token(TokenType type, String lexame, Object literal, int line) {
        this.type = type;
        this.lexame = lexame;
        this.literal = literal;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexame + " " + literal;
    }
}
