package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
NUMERO=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Ponto e virgula  */
( ";" ) {lexeme=yytext(); return pv;}

/* Ponto final  */
( "." ) {lexeme=yytext(); return pf;}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Constante */
( "constante" ) {lexeme=yytext(); return constante;}

/* Variável */
( "var" ) {lexeme=yytext(); return var;}

/* Virgula */
( "," ) {lexeme=yytext(); return virgula;}

/* Dois pontos */
( ":" ) {lexeme=yytext(); return dois_pontos;}


/* Real */
( "Real" ) {lexeme=yytext(); return Real;}

/* Inteiro */
( "Inteiro" ) {lexeme=yytext(); return Inteiro;}

/* Funcao */
( "funcao" ) {lexeme=yytext(); return funcao;}

/* Procedimento */
( "procedimento" ) {lexeme=yytext(); return procedimento;}





/*Real*/
[-]?|{NUMERO}+"."{NUMERO}+ {lexeme=yytext(); return real;}

/*Inteiro*/
[-]?|{NUMERO}+ {lexeme=yytext(); return inteiro;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}

/* Identificador */
{L}({L}|{NUMERO})* {lexeme=yytext(); return id;}


/*************************************************************************/

/* Salto de linea */
/*( "\n" ) {return Linea;}

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

/* Tipos de datos */
( byte | int | char | long | float | double ) {lexeme=yytext(); return T_dato;}

/* Tipo de dato String */
( String ) {lexeme=yytext(); return Cadena;}

/* Palabra reservada If */
( if ) {lexeme=yytext(); return If;}

/* Palabra reservada Else */
( else ) {lexeme=yytext(); return Else;}

/* Palabra reservada Do */
( do ) {lexeme=yytext(); return Do;}

/* Palabra reservada While */
( while ) {lexeme=yytext(); return While;}

/* Palabra reservada For */
( for ) {lexeme=yytext(); return For;}

/* Operador Igual */
( "=" ) {lexeme=yytext(); return Igual;}

/* Operador Suma */
( "+" ) {lexeme=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexeme=yytext(); return Resta;}

/* Operador Multiplicacion */
( "*" ) {lexeme=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexeme=yytext(); return Division;}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}

/*Operadores Booleanos*/
(true | false)      {lexeme = yytext(); return Op_booleano;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexeme = yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexeme = yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexeme=yytext(); return Main;}

/* Punto y coma */
( ";" ) {lexeme=yytext(); return P_coma;}*/




/* Error de analisis */
 . {return ERROR;}
