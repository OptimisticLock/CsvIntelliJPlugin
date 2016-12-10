// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static generated.GeneratedTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeneratedParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == CSV_LINE) {
      r = csvLine(b, 0);
    }
    else if (t == CSV_VALUE) {
      r = csvValue(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // !<<eof>> csvValue (csvComma csvValue)* ( csvEol | <<eof>>)
  public static boolean csvLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvLine")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CSV_LINE, "<csv line>");
    r = csvLine_0(b, l + 1);
    r = r && csvValue(b, l + 1);
    r = r && csvLine_2(b, l + 1);
    r = r && csvLine_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !<<eof>>
  private static boolean csvLine_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvLine_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (csvComma csvValue)*
  private static boolean csvLine_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvLine_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!csvLine_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "csvLine_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // csvComma csvValue
  private static boolean csvLine_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvLine_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CSVCOMMA);
    r = r && csvValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // csvEol | <<eof>>
  private static boolean csvLine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvLine_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CSVEOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (csvString | csvLiteral)?
  public static boolean csvValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvValue")) return false;
    Marker m = enter_section_(b, l, _NONE_, CSV_VALUE, "<csv value>");
    csvValue_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // csvString | csvLiteral
  private static boolean csvValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csvValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CSVSTRING);
    if (!r) r = consumeToken(b, CSVLITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // csvLine *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    int c = current_position_(b);
    while (true) {
      if (!csvLine(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
