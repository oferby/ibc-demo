grammar Ztn;


@header {
    import java.util.*;

}

@members {
    HashMap<String,String> values;
}


/*
* Parser Rules
*/

zn  returns [Map<String,String> values]
        :
        ( showCommand { $values = $showCommand.values; }
        | findPathCommand { $values = $findPathCommand.values; }
        | newCommand { $values = $newCommand.values; }
        )
        ;

showCommand returns [Map<String,String> values]
        : show (e=entity)? n=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "show");
                $values.put("name", $n.text);
                $values.put("entity", $e.text);
            }
        ;


newCommand returns [Map<String,String> values]
        : newOperator e=entity n=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "new");
                $values.put("name", $n.text);
                $values.put("entity", $e.text);
            }
        ;


findPathCommand returns [Map<String,String> values]
        : ( search | show ) searchble from f=name to t=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "path");
                $values.put("from", $f.text);
                $values.put("to", $t.text);
            }
        ;

operator    : show | newOperator | search ;
from        : FROM;
to          : TO ;
show        : SHOW ;
newOperator : NEW ;
search      : SEARCH ;
entity      : ENTITY ;
name        : NAME ;
searchble   : SEARCHABLE ;


/*
* Lexer Rules
*/

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;
fragment DIGIT      : [0-9]+ ;

FROM        : 'from' ;
TO          : 'to' ;
SHOW        : ( 'show' |  'get' ) ;
SEARCH      : ( 'find' | 'search' ) ;
NEW         : ( 'new' | 'create' | 'build' | 'start' ) ;
ENTITY      : ('router' | 'vm' | 'switch' |  'firewall') ;
SEARCHABLE  : ( 'path' | 'traffic' ) ;
NEWLINE     : ('\r'? '\n' | '\r')+ ;
NAME        : ( LOWERCASE | UPPERCASE | DIGIT )+ ;
WORD        : ( LOWERCASE | UPPERCASE | '_' )+ ;
WHITESPACE  : ' ' -> skip ;