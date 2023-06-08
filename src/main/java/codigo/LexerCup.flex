package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espaco=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espaco} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Aspas duplas */
( "\"" ) {return new Symbol(sym.ASPAS_DUPLAS, yychar, yyline, yytext());}

/* Tipos de dados */
( inteiro | caractere | real | palavra ) {return new Symbol(sym.TIPO_DADO, yychar, yyline, yytext());}

/* Tipo de dado Inteiro (Para el main) */
( "inteiro" ) {return new Symbol(sym.INTEIRO, yychar, yyline, yytext());}

/* Tipo de dado String */
( palavra ) {return new Symbol(sym.PALAVRA, yychar, yyline, yytext());}

/* palavra reservada se */
( se ) {return new Symbol(sym.SE, yychar, yyline, yytext());}

/* palavra reservada senao */
( senao ) {return new Symbol(sym.SENAO, yychar, yyline, yytext());}

/* Palabra reservada While */
( enquanto ) {return new Symbol(sym.ENQUANTO, yychar, yyline, yytext());}

/* Palabra reservada repita */
( repita ) {return new Symbol(sym.REPITA, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.ATRIBUICAO, yychar, yyline, yytext());}

/* Operador soma */
( "+" ) {return new Symbol(sym.SOMA, yychar, yyline, yytext());}

/* Operador Subtracao */
( "-" ) {return new Symbol(sym.SUBTRACAO, yychar, yyline, yytext());}

/* Operador Multiplicacao */
( "*" ) {return new Symbol(sym.MULTIPLICACAO, yychar, yyline, yytext());}

/* Operador Divisao */
( "/" ) {return new Symbol(sym.DIVISAO, yychar, yyline, yytext());}

/* Operadores logicos */
( "ou" | "e" | "nao" ) {return new Symbol(sym.OPERADORES_LOGICOS, yychar, yyline, yytext());}

/*Operadores Relacionales */
( "<>" | "<" | ">" | "==" | ">=" | "<=" ) {return new Symbol(sym.OPERADORES_RELACIONAIS, yychar, yyline, yytext());}

/* Operadores Atribuicao */
( "=" ) {return new Symbol(sym.OPERADORES_ATRIBUICAO, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( verdadeiro | falso ) {return new Symbol(sym.LOGICO, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.ABRE_PARENTESES, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.FECHA_PARENTESES, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.ABRE_CHAVES, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.FECHA_CHAVES, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.ABRE_COLCHETES, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.FECHA_COLCHETES, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "programa" ) {return new Symbol(sym.PROGRAMA, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.PONTO_VIRGULA, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.ID, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.NUMERO, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERRO, yychar, yyline, yytext());}
