package com.dreambox.csv;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

public class CsvElementType extends IElementType {
  public CsvElementType(@NotNull @NonNls String debugName) {
    super(debugName, CsvLanguage.INSTANCE);
  }
}