package lexical;

import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class Lexical implements AutoCloseable {

    private int line;
    private PushbackInputStream input;

    public Lexical(String filename) throws LexicalException {
        try {
            input = new PushbackInputStream(new FileInputStream(filename));
        } catch (Exception e) {
            throw new LexicalException("Unable to open file");
        }

        line = 1;
    }

    public void close() {
        try {
            input.close();
        } catch (Exception e) {
            // ignore
        }
    }

    public int line() {
        return this.line;
    }

    public Lexeme nextToken() {
         Lexeme lex = new Lexeme("", TokenType.END_OF_FILE);

         // TODO: implement me.

         // HINT: read a char.
         // int c = input.read();

         // HINT: unread a char.
         // if (c != -1)
         //     input.unread(c);

         return lex;
    }
}
