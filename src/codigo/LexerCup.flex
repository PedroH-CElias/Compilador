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
NUMERO=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* bibIO  */
( "bibIO" ) {return new Symbol(sym.bibIO, yychar, yyline, yytext());}

/* Ponto e virgula  */
( ";" ) {return new Symbol(sym.pv, yychar, yyline, yytext());}

/* utilize  */
( "utilize" ) {return new Symbol(sym.utilize, yychar, yyline, yytext());}

/* ini  */
( "inicio" ) {return new Symbol(sym.ini, yychar, yyline, yytext());}


/* fim  */
( "fim" ) {return new Symbol(sym.fim, yychar, yyline, yytext());}

/* .  */
( "." ) {return new Symbol(sym.pf, yychar, yyline, yytext());}

/* programa  */
( "programa" ) {return new Symbol(sym.programa, yychar, yyline, yytext());}

/* inteiro */
("(-"{NUMERO}+")")|{NUMERO}+ {return new Symbol(sym.inteiro, yychar, yyline, yytext());}

/* real */
[-]?|{NUMERO}+"."{NUMERO}+ {return new Symbol(sym.real, yychar, yyline, yytext());}

/* Constante */
("constante") {return new Symbol(sym.constante, yychar, yyline, yytext());}

/* Real */
( "Real" ) {return new Symbol(sym.Real, yychar, yyline, yytext());}

/* Inteiro */
( "Inteiro" ) {return new Symbol(sym.Inteiro, yychar, yyline, yytext());}

/* Variavel */
( "var" ) {return new Symbol(sym.var, yychar, yyline, yytext());}

/* Virgula */
( "," ) {return new Symbol(sym.virgula, yychar, yyline, yytext());}

/* Dois pontos */
( ":" ) {return new Symbol(sym.dois_pontos, yychar, yyline, yytext());}

/* Funcao */
( "funcao" ) {return new Symbol(sym.funcao, yychar, yyline, yytext());}

/* Procedimento */
( "procedimento" ) {return new Symbol(sym.procedimento, yychar, yyline, yytext());}



/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}


/* Identificador */
{L}({L}|{NUMERO})* {return new Symbol(sym.id, yychar, yyline, yytext());}

/**********************************************************************************************/


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
/*( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Tipos de datos */
( byte | char | long | float | double ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

/* Tipo de dato Int (Para el main) */
( "int" ) {return new Symbol(sym.Int, yychar, yyline, yytext());}

/* Tipo de dato String */
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.While, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}



/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}*/



/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
