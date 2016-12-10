// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static generated.GeneratedTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class CsvLineImpl extends ASTWrapperPsiElement implements CsvLine {

  public CsvLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitCsvLine(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CsvValue> getCsvValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CsvValue.class);
  }

  @Override
  @Nullable
  public PsiElement getCsvEol() {
    return findChildByType(CSVEOL);
  }

}
