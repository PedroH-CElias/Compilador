package codigo;

public class Directories {
    // Se for windows da alt + j em todas as "/" e altera para \\
    // Alterar somente o LOCAL_PATH
    private static final String LOCAL_PATH = "/home/dioneja/workspace/";
    private static final String SIMPLIFIED_PATH = "Pasquase/";
    private static final String DEFAULT_PATH = SIMPLIFIED_PATH + "src/";

    //Inalteráveis
    public static final String LEXER_PATH = LOCAL_PATH + DEFAULT_PATH + "codigo/Lexer.flex";
    public static final String SIMPLIFIED_LEXER_CUP_PATH = LOCAL_PATH + DEFAULT_PATH + "codigo/LexerCup.flex";
    public static final String SYM_PATH = LOCAL_PATH + DEFAULT_PATH + "codigo/sym.java";
    public static final String SIMPLIFIED_SYM_PATH = LOCAL_PATH + SIMPLIFIED_PATH + "sym.java";
    public static final String SYNTAX_PATH = LOCAL_PATH + DEFAULT_PATH + "codigo/Sintax.java";
    public static final String SIMPLIFIED_SYNTAX_PATH = LOCAL_PATH + SIMPLIFIED_PATH + "Sintax.java";
}
