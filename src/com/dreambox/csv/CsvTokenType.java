package com.dreambox.csv;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

public class CsvTokenType extends IElementType {
  public CsvTokenType(@NotNull @NonNls String debugName) {
    super(debugName, CsvLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "CsvTokenType." + super.toString();
  }
}