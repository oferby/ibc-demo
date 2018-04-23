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
        | delCommand { $values = $newCommand.values; }
        | connectCommand { $values = $newCommand.values; }
        | disconnectCommand { $values = $newCommand.values; }
        | allowCommand { $values = $newCommand.values; }
        | denyCommand { $values = $newCommand.values; }
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
        : newOperator NEW? e=entity n=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "new");
                $values.put("name", $n.text);
                $values.put("entity", $e.text);
            }
        ;


delCommand returns [Map<String,String> values]
        : delOperator (e=entity)? n=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "delete");
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

connectCommand returns [Map<String,String> values]
        : connect f=name to? and? t=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "connect");
                $values.put("from", $f.text);
                $values.put("to", $t.text);

            }
        ;

disconnectCommand returns [Map<String,String> values]
        : disconnect f=name from? and? t=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "disconnect");
                $values.put("from", $f.text);
                $values.put("to", $t.text);

            }
        ;

allowCommand returns [Map<String,String> values]
        : allow access from entity? f=name to entity? t=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "allow");
                $values.put("from", $f.text);
                $values.put("to", $t.text);
            }
        ;

denyCommand returns [Map<String,String> values]
        : deny access from entity? f=name to entity? t=name
            {
                $values = new HashMap<String,String>();
                $values.put("operator", "deny");
                $values.put("from", $f.text);
                $values.put("to", $t.text);
            }
        ;


operator    : show | newOperator | search ;
from        : FROM;
to          : TO ;
and         : AND ;
show        : SHOW ;
newOperator : NEW ;
delOperator : DELETE ;
search      : SEARCH ;
connect     : CONNECT;
disconnect  : DISCONNECT;
allow       : ALLOW;
deny        : DENY;
access      : ACCESS | TRAFFIC;
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
AND         : 'and' ;
ACCESS      : 'access';
TRAFFIC     : 'traffic';
SHOW        : ( 'show' |  'get' ) ;
SEARCH      : ( 'find' | 'search' ) ;
CONNECT     : ( 'connect' | 'attach' ) ;
DISCONNECT  : ( 'disconnect' | 'detach' ) ;
NEW         : ( 'create' | 'build' | 'start' | 'add' ) ;
DELETE      : ( 'delete' | 'remove' ) ;
ALLOW       : ( 'allow' | 'grant' | 'permit' ) ;
DENY        : ( 'deny' | 'revoke' ) ;
ENTITY      : ('router' | 'vm' | 'switch' |  'firewall' | 'service' | 'application') ;
SEARCHABLE  : ( 'path' | 'traffic' ) ;
NEWLINE     : ('\r'? '\n' | '\r')+ ;
NAME        : ( LOWERCASE | UPPERCASE | DIGIT )+ ;
WORD        : ( LOWERCASE | UPPERCASE | '_' )+ ;
WHITESPACE  : ' ' -> skip ;