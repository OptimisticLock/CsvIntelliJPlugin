package com.dreambox.csv;
import com.dreambox.csv.elements.MyCsvLine;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import generated.psi.CsvLine;
import generated.psi.Value;
import generated.psi.impl.CsvLineImpl;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /** A bit more efficient than getRow(0). TODO: cache */
    public CsvLineImpl getHeader() {
        return (CsvLineImpl) getFirstChild();
    }

    public CsvLineImpl getLine(int lineNo) {
        PsiElement[] children = getChildren();
        // TODO test for boundaries
        return (CsvLineImpl) children[lineNo];
    }

    public List<CsvLineImpl> findRows(Predicate<CsvLineImpl> predicate) {

        List<CsvLineImpl> lines = PsiTreeUtil.getChildrenOfTypeAsList(this, CsvLineImpl.class);

        List <CsvLineImpl> result = lines
        		.stream()
        		.filter(predicate)
        		.collect(Collectors.toList());

        return null;
    }


    public boolean hasHeader(String header) {

        CsvLineImpl headers = (CsvLineImpl) getFirstChild();
        List<Value> values = headers.getValueList();
        for (Value value : values)
            if (header.equals(value.getText()))
                return true;

        return false;
    }
}