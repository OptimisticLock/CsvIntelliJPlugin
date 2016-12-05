package com.dreambox.csv;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CsvFile extends PsiFileBase {


    public CsvFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CsvLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CsvFileType.INSTANCE;
    }

    @Override
    public String toString() {

        return "Csv File '" + getViewProvider().getVirtualFile().getPath();
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}