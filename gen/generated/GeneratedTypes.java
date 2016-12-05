// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType LINE = new IElementType("LINE", null);
  IElementType VALUE = new IElementType("VALUE", null);

  IElementType COMMA = new IElementType(",", null);
  IElementType EOF = new IElementType("<<EOF>>", null);
  IElementType EOL = new IElementType("eol", null);
  IElementType LITERAL = new IElementType("literal", null);
  IElementType STRING = new IElementType("string", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == LINE) {
        return new LineImpl(node);
      }
      else if (type == VALUE) {
        return new ValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
