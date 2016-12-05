package com.dreambox.csv;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class CsvFileType extends LanguageFileType {
  public static final CsvFileType INSTANCE = new CsvFileType();

  private CsvFileType() {
    super(CsvLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "csv";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "CSV file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "csv";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return CsvIcons.FILE;
  }
}