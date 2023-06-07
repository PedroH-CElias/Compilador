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
"programa" {return PROGRAMA;}
"utilize" {return UTILIZE;}
"bibIO" {return BIB_IO;}
"const" {return CONST;}
"inicio" {return INICIO;}
"fim" {return FIM;}
"inteiro" {return INTEIRO;}
"real" {return REAL;}
"caractere" {return CARACTERE;}
"palavra" {return PALAVRA;}
"logico" {return LOGICO;}
"var" {return VAR;}
"arranjo" {return ARRANJO;}
"leia" {return LEIA;}
"leialn" {return LEIA_LN;}
"escreva" {return ESCREVA;}
"escrevaln" {return ESCREVA_LN;}
"se" {return SE;}
"entao" {return ENTAO;}
"senao" {return SENAO;}
"para" {return PARA;}
"de" {return DE;}
"ate" {return ATE;}
"faca" {return FACA;}
"enquanto" {return ENQUANTO;}
"repita" {return REPITA;}
"procedimento" {return PROCEDIMENTO;}
"funcao" {return FUNCAO;}
"ou" {return OU;}
"e" {return E;}
"nao" {return NAO;}
"(" {return ABRE_PARENTESES;}
")" {return FECHA_PARENTESES;}
"\"" {return ASPAS_DUPLAS;}
"'" {return ASPAS_SIMPLES;}
"." {return PONTO;}
"," {return VIRGULA;}
"{" {return ABRE_CHAVES;}
"}" {return FECHA_CHAVES;}
"[" {return ABRE_COLCHETE;}
"]" {return FECHA_COLCHETE;}
">" {return MAIOR;}
"<" {return MENOR;}
"<>" {return DIFERENTE;}
"<=" {return MENOR_IGUAL;}
">=" {return MAIOR_IGUAL;}
" \%" {return RESTO_DIVISAO;}
"^" {return POTENCIA;}
"=" {return ATRIBUICAO;}
"==" {return IGUALDADE;}
"+" {return SOMA;}
"*" {return MULTIPLICACAO;}
"-" {return SUBTRACAO;}
"/" {return DIVISAO;}

[+-]?|{NUMERO}+{CARACTERE}+ {lexeme=yytext(); return ID_INVALIDO;}
{CARACTERE}({CARACTERE}|{NUMERO})* {lexeme=yytext(); return ID;}
([+-]?|{NUMERO}) {lexeme=yytext(); return INTEIRO;}
\"{CARACTERE}({CARACTERE}|{NUMERO})*"\"" {lexeme=yytext(); return PALAVRA;}
"\'"{CARACTERE}"\'" {lexeme=yytext(); return CARACTERE;}
{CARACTERE}({CARACTERE}|{NUMERO})* {lexeme=yytext(); return ID;}
[+-]?|{NUMERO}+"."{NUMERO}+ {lexeme=yytext(); return REAL;}
[+-]?|{NUMERO}+ {lexeme=yytext(); return INTEIRO;}

.  {lexeme=yytext(); return ERRO;}