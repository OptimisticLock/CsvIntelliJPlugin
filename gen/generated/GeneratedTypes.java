// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.dreambox.csv.CsvElementType;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType CSV_LINE = new CsvElementType("CSV_LINE");
  IElementType CSV_VALUE = new CsvElementType("CSV_VALUE");

  IElementType CSVCOMMA = new IElementType(",", null);
  IElementType CSVEOF = new IElementType("<<EOF>>", null);
  IElementType CSVEOL = new IElementType("csvEol", null);
  IElementType CSVLITERAL = new IElementType("csvLiteral", null);
  IElementType CSVSTRING = new IElementType("csvString", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CSV_LINE) {
        return new CsvLineImpl(node);
      }
      else if (type == CSV_VALUE) {
        return new CsvValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
