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

CSVEOL=[\r\n]+
CSVLITERAL=[^,\r\n'\"][^,\r\n]*
CSVSTRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "<<EOF>>"          { return CSVEOF; }
  ","                { return CSVCOMMA; }

  {CSVEOL}           { return CSVEOL; }
  {CSVLITERAL}       { return CSVLITERAL; }
  {CSVSTRING}        { return CSVSTRING; }

}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
