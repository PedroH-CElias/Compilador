package codigo;
import static codigo.Token.*;
%%

%class AnalisadorLexico
%type Token

BRANCO = [ |\t|\r]*
BOOLEAN = "true" | "false"
CARACTERE = [a-zA-Z]+
NUMERO = [0-9]+

%{
    public String lexeme;
%}

%%
/* Pular linha */
( "\n" ) {return LINHA;}
{BRANCO} {/*Ignore*/}
"//".* {/*Ignore*/}
"programa" {lexeme=yytext(); return PROGRAMA;}
"utilize" {lexeme=yytext(); return UTILIZE;}
"bibIO" {lexeme=yytext(); return BIB_IO;}
"const" {lexeme=yytext(); return CONST;}
"inicio" {lexeme=yytext(); return INICIO;}
"fim" {lexeme=yytext(); return FIM;}
"inteiro" {lexeme=yytext(); return INTEIRO;}
"real" {lexeme=yytext(); return REAL;}
"caractere" {lexeme=yytext(); return CARACTERE;}
"palavra" {lexeme=yytext(); return PALAVRA;}
"logico" {lexeme=yytext(); return LOGICO;}
"var" {lexeme=yytext(); return VAR;}
"arranjo" {lexeme=yytext(); return ARRANJO;}
"leia" {lexeme=yytext(); return LEIA;}
"leialn" {lexeme=yytext(); return LEIA_LN;}
"escreva" {lexeme=yytext(); return ESCREVA;}
"escrevaln" {lexeme=yytext(); return ESCREVA_LN;}
"se" {lexeme=yytext(); return SE;}
"entao" {lexeme=yytext(); return ENTAO;}
"senao" {lexeme=yytext(); return SENAO;}
"para" {lexeme=yytext(); return PARA;}
"de" {lexeme=yytext(); return DE;}
"ate" {lexeme=yytext(); return ATE;}
"faca" {lexeme=yytext(); return FACA;}
"enquanto" {lexeme=yytext(); return ENQUANTO;}
"repita" {lexeme=yytext(); return REPITA;}
"procedimento" {lexeme=yytext(); return PROCEDIMENTO;}
"funcao" {lexeme=yytext(); return FUNCAO;}
"ou" {lexeme=yytext(); return OU;}
"e" {lexeme=yytext(); return E;}
"nao" {lexeme=yytext(); return NAO;}
"(" {lexeme=yytext(); return ABRE_PARENTESES;}
")" {lexeme=yytext(); return FECHA_PARENTESES;}
"\"" {lexeme=yytext(); return ASPAS_DUPLAS;}
"'" {lexeme=yytext(); return ASPAS_SIMPLES;}
"." {lexeme=yytext(); return PONTO;}
"," {lexeme=yytext(); return VIRGULA;}
"{" {lexeme=yytext(); return ABRE_CHAVES;}
"}" {lexeme=yytext(); return FECHA_CHAVES;}
"[" {lexeme=yytext(); return ABRE_COLCHETE;}
"]" {lexeme=yytext(); return FECHA_COLCHETE;}
">" {lexeme=yytext(); return MAIOR;}
"<" {lexeme=yytext(); return MENOR;}
"<>" {lexeme=yytext(); return DIFERENTE;}
"<=" {lexeme=yytext(); return MENOR_IGUAL;}
">=" {lexeme=yytext(); return MAIOR_IGUAL;}
" \%" {lexeme=yytext(); return RESTO_DIVISAO;}
"^" {lexeme=yytext(); return POTENCIA;}
"=" {lexeme=yytext(); return ATRIBUICAO;}
"==" {lexeme=yytext(); return IGUALDADE;}
"+" {lexeme=yytext(); return SOMA;}
"*" {lexeme=yytext(); return MULTIPLICACAO;}
"-" {lexeme=yytext(); return SUBTRACAO;}
"/" {lexeme=yytext(); return DIVISAO;}

[+-]?|{NUMERO}+{CARACTERE}+ {lexeme=yytext(); return ID_INVALIDO;}
{CARACTERE}({CARACTERE}|{NUMERO})* {lexeme=yytext(); return ID;}
([+-]?|{NUMERO}) {lexeme=yytext(); return INTEIRO;}
\"{CARACTERE}({CARACTERE}|{NUMERO})*"\"" {lexeme=yytext(); return PALAVRA;}
"\'"{CARACTERE}"\'" {lexeme=yytext(); return CARACTERE;}
{CARACTERE}({CARACTERE}|{NUMERO})* {lexeme=yytext(); return ID;}
[+-]?|{NUMERO}+"."{NUMERO}+ {lexeme=yytext(); return REAL;}
[+-]?|{NUMERO}+ {lexeme=yytext(); return INTEIRO;}

.  {lexeme=yytext(); return ERRO;}