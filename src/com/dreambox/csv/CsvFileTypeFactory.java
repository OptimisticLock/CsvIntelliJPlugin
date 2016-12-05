package com.dreambox.csv;

import com.intellij.openapi.fileTypes.*;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;

public class CsvFileTypeFactory extends FileTypeFactory {
  @Override
  public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(CsvFileType.INSTANCE, "csv");
  }
}  