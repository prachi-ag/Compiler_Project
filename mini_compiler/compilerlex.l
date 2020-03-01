L   [a-zA-Z_]
A   [a-zA-Z_0-9]
D   [0-9]
NZ  [1-9]
UNDER (_)
WS  [ \t\v\n\f]
%{
#include <stdio.h>
#include "compiler.tab.h"
#include <stdlib.h>
extern void yyerror(const char *);
static void comment(void);
int yylineno ;
%}
%%
"/*"                    { comment(); }
"//".*                  { /* consume //-comment */ }
{NZ}{D}*                { yylval.intval = strdup(yytext);
						return(NUMBER); }
"int"					{ yylval.intval = strdup(yytext);return(INT); }
"char"					{ yylval.intval = strdup(yytext);return(CHAR); }
"if"					{ return(IF); }
"else"					{ return(ELSE); }
"and"                   { return(AND); }
"not"                   { return(NOT); }
"while"                 { return WHILE;}
"return"                { return RETURN; }
"or"                    { return(OR); }  
"("						{ return PAR_OPEN; }
")"						{ return PAR_CLOSE; }
";"						{ return SEMICOLON; }
"{"						{ return CB_OPEN; }
"}"						{ return CB_CLOSE; }
"+"						{ return PLUS; }
"-"						{ return MINUS; }
"*"						{ return ASTERISK; }
"/"						{ return SLASH; }
"="						{ return ASSIGNMENT; }
"<="					{ return LESS_EQUAL; }
"<"						{ return LESS; }
">="					{ return MORE_EQUAL; }
">"						{ return MORE; }
"=="					{ return EQUAL; }
"!="					{ return NOT_EQUAL; }
","                     { return COMMA;}
"'"                     {return QUOT;}
"exit"					{exit(EXIT_SUCCESS);}
{UNDER}{L}              { yylval.charval = yytext[1];
                        return LITERAL_C ; }
{L}{A}*					{ return(ID); }

{WS}					{ if( *yytext == '\n' ){yylineno++;} }
.						{ yyerror("Undefiend keyword"); }

%%
int yywrap(void)        
{
    return 1;           
}
static void comment(void)
{
    int c;

    while ((c = input()) != 0)
        if (c == '*')
        {
            while ((c = input()) == '*')
                ;

            if (c == '/')
                return;

            if (c == 0)
                break;
        }
    yyerror("unterminated comment");
}
