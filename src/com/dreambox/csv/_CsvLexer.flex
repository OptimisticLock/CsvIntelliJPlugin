package com.dreambox.csv;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static generated.GeneratedTypes.*;

%%

%{
  public _CsvLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _CsvLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=[\r\n]+
LITERAL=[^,\r\n'\"][^,\r\n]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {

  "<<EOF>>"          { return EOF; }
  ","                { return COMMA; }

  {EOL}              { return EOL; }
  {LITERAL}          { return LITERAL; }
  {STRING}           { return STRING; }

}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
