// 23/08
package lexical;

public class SyntaticalAnalysis {

    private Lexical la;
    private Lexeme current;

    public SyntaticalAnalysis(Lexical la) {
        this.la = la;
        this.current = la.nextToken();
    }

    public void matchToken(TokenType type) {
        if (type == current.type) {
            current = la.nextToken();
        } else {
            showError();
        }
    }

    public void showError() {
        if (current.type == TokenType.UNEXPECTED_EOF) {
            //unexpetedEofError();
            //imprime erro 1
        } else {
            //imprime erro2;
        }
        System.exit(1);
    }

    void procVar() {
        matchToken(TokenType.VAR);
    }

    void procNumber() {
        matchToken(TokenType.NUMBER);
    }

    void procString() {
        matchToken(TokenType.STRING);
    }

    // <input> :: 'c' <text> ')' ')'
    void procInput() {
        matchToken(TokenType.INPUT);
        matchToken(TokenType.PAR_OPEN);
        procText();
        matchToken(TokenType.PAR_CLOSE);
        matchToken(TokenType.DOT_COMMA);
    }

    //<if> ::= if boolean>
    void procIf() {
        matchToken(TokenType.IF);
        procBoolExpr();
        procStatement();
        if (current.type == TokenType.ELSE) {
            matchToken(TokenType.ELSE);
            procStatements();
        }
        matchToken(TokenType.END);
    }

    //<matrixexpr> ::= (<var>|<gen>){'.'(|<csum>|<cmul>|)}
    void procMatrixExpr() {
        if (current.type == TokenType.VAR) {
            procVar();
        } else if (current.type == TokenType.BRA_OPEN) {
            procGen();
        } else {
            //Erro lexema inválido
            //abortar
        }
        while (current.type == TokenType.DOT) {
            matchToken(TokenType.DOT);
            if (current.type == TokenType.TRASNPOSED) {
                procTrasnposed();
            } else if (current.type == TokenType.MUL) {
                procMul();
            } else {
                //Erro
                //Abortar
            }
        }
    }

    void start() {
        procStatements();
        matchToken(TokenType.END_OF_FILE);
    }

    void procValue() {
        if (current.type == TokenType.VAR) {
            procVar();
        } else if (current.type == TokenType.BRA_OPEN) {
            procGen();
        } else {
            showError();
        }
        while (current.type == TokenType.DOT) {
            matchToken(TokenType.DOT);
            if (current.type == TokenType.OPPOSED) {
                procOpposed();
                // ...
            } else if (current.type == TokenType.SIZE) {
                procSize();
                break;
                // ...
            } else {
                showError();
            }
        }
    }
    // ------------------------------

    private void procText() {
        matchToken(TokenType.BRA_OPEN);
        if (current.type == TokenType.STRING) {
            procString();
        } else if (current.type == TokenType.VALUE) {
            procValue();
        }else{
            showError();
        }
    }

    void procIntExpr() {

    }
// ----------------------------

    private void procBoolExpr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procGen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procMul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procTrasnposed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void procStatements() {
        procStatement();
        while (current.type == TokenType.INPUT
                || current.type == TokenType.SHOW
                || current.type == TokenType.VAR
                || current.type == TokenType.IF
                || current.type == TokenType.WHILE
                || current.type == TokenType.FOR) {
            procStatement();
        }
    }

    private void unexpetedEofError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void unexpectedLexeme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procOpposed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void procSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
