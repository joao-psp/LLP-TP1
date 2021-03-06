package lexical;

public enum TokenType {
    // special tokens
    INVALID_TOKEN,
    UNEXPECTED_EOF,
    END_OF_FILE,

    VAR,
    ASSIGN,
    INPUT,
    PAR_OPEN,
    PAR_CLOSE,
    STRING,
    DOT_COMMA,
    BRA_OPEN,
    BRA_CLOSE,
    DOT,
    RAND,
    COMMA,
    SHOW,
    NUMBER,
    FOR,
    SEQ,
    MINUS,
    PLUS,
    TIMES,
    DIV,
    MOD,
    VALUE,
    END,
    ISEQ,
    EQUAL,
    DIFF,
    LOWER,
    LOWER_EQUAL,
    GREATER,
    GREATER_EQUAL,
    AND,
    OR,
    IF,
    ELSE,
    WHILE,
    OPPOSED,
    TRASNPOSED,
    SUM,
    MUL,
    NULL,
    FILL,
    ID,
    SIZE,
    ROWS,
    COLS;
}
