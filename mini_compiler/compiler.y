%{
    #include <stdio.h>
    #include <stdlib.h>
    #include <ctype.h>
    #include "mytable.h"
    #include <string.h> 
    int yyerror(char *);
    int yylex(void);
    int yylineno;
    
   
%}

%token	PAR_OPEN  PAR_CLOSE COMMA SEMICOLON  WHILE RETURN  
%token	IF ELSE CB_OPEN CB_CLOSE PLUS MINUS ASTERISK SLASH ASSIGNMENT
%token	OR AND NOT LESS LESS_EQUAL MORE_EQUAL MORE EQUAL NOT_EQUAL QUOT

%union { char * intval;
        char  charval;
        struct symtab *symp;
        }
        
%token <intval> NUMBER
%token <charval> LITERAL_C
%token <symp> ID
%token <intval> CHAR
%token <intval> INT

%type <intval> expression
%type <charval> char_expression   
%type <intval> conditions   
%type <intval> types
       
%left PLUS MINUS
%left ASTERISK SLASH

%%


program
    :program funcdef 
    | funcdef
    |
    ;

funcdef
    : types ID args block_statement
    ;

args
    :  PAR_OPEN var_def_list PAR_CLOSE
    ;
    
var_def_list
    :var_def COMMA var_def
    |var_def 
    |
    ;

    
var_def
    :   types ID
    ;

types
    : INT
    | CHAR
    ;

block_statement
    :   CB_OPEN statements CB_CLOSE
    ;

statements
    : statements statement 
    | statement 
    |
    ;

statement
    : block_statement
    | conditional_statement
    | while_st
    | assignment_statement SEMICOLON
    | ret_statement SEMICOLON
    ;
    
conditional_statement
    
    : IF PAR_OPEN conditions PAR_CLOSE block_statement  elsest 
     ;

elsest
    : ELSE block_statement
    |
    ;
    
while_st 
    : WHILE PAR_OPEN conditions  PAR_CLOSE  block_statement  
    ;
    

conditions 
    : conditions LESS expression 
    | conditions LESS_EQUAL expression 
    | conditions MORE_EQUAL expression 
    | conditions MORE expression 
    | conditions NOT_EQUAL expression 
    | conditions EQUAL expression 
    | expression   
    ;

ret_statement
    : RETURN expression {  } 
    ;
assignment_statement
    : types ID ASSIGNMENT expression 
    | ID ASSIGNMENT expression 
    | types ID ASSIGNMENT char_expression 
    | ID ASSIGNMENT char_expression 
    | types ID ASSIGNMENT 
    | error ; 
    ;
expression
    : NUMBER { $$ = $1; }
    | ID { $$ = $1 -> name ;}
    | expression PLUS expression 
    | expression MINUS expression 
    | expression ASTERISK expression 
    | expression SLASH expression 
    | PAR_OPEN expression PAR_CLOSE 
    ;
     
char_expression
    : QUOT LITERAL_C QUOT { }
    ;

%%
int yyerror(char *s){
    fprintf(stderr , "%s line %i \n", s, yylineno);
    exit(0);

}

int main(int argc ,char *argv[]){
    printf("please write your expression : -> \n \n");
    yyparse();
    return 0;
}

    
    
    
