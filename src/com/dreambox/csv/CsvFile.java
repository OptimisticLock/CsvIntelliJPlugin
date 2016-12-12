package com.dreambox.csv;
import com.dreambox.csv.elements.MyCsvLine;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import generated.psi.CsvLine;
import generated.psi.impl.CsvLineImpl;
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
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    @Override
    public String toString() {
        return "Csv File '" + getViewProvider().getVirtualFile().getPath();
    }

    /** A bit more efficient than getRow(0) */
    public CsvLineImpl getHeader() {
        return (CsvLineImpl) getFirstChild();
    }

    public CsvLineImpl GetRow(int rowNo) {
        PsiElement[] children = getChildren();
        // TODO test for boundaries
        return (CsvLineImpl) children[rowNo];
    }
}