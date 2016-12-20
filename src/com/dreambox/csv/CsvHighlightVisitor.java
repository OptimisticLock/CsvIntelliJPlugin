package com.dreambox.csv;

import com.intellij.codeHighlighting.RainbowHighlighter;
import com.intellij.codeInsight.daemon.JavaRainbowVisitor;
import com.intellij.codeInsight.daemon.RainbowVisitor;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.*;
import com.intellij.psi.javadoc.PsiDocTagValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by irina.rapoport on 12/9/16.  // RainbowVisitor
 */
public class CsvHighlightVisitor extends RainbowVisitor {


    public CsvHighlightVisitor() {
        super();
    }

    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        return file instanceof CsvFile;
    }

    @Override
    public void visit(@NotNull PsiElement psiElement) {


        //    System.out.println("Visited " + psiElement);
        HighlightInfo attrs = getRainbowSymbolKey(psiElement);
        addInfo(attrs);
    }

    @NotNull
    @Override
    public CsvHighlightVisitor clone() {
        return new CsvHighlightVisitor();
    }

    @NotNull
    @Override
    protected RainbowHighlighter getHighlighter() {
        return super.getHighlighter();
    }

    @Override
    public int order() {
        return super.order();
    }

    @Override
    protected void addInfo(@Nullable HighlightInfo highlightInfo) {
        super.addInfo(highlightInfo);
    }

    @Override
    protected HighlightInfo getInfo(@NotNull PsiElement psiElement, @NotNull PsiElement psiElement1, @NotNull String s, @Nullable TextAttributesKey textAttributesKey) {
        return super.getInfo(psiElement, psiElement1, s, textAttributesKey);
    }


    @Nullable
    private HighlightInfo getRainbowSymbolKey(PsiElement rainbowElement) {

  //      return getInfo(context, rainbowElement, name, JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
        TextAttributesKey colorKey = JavaHighlightingColors.STRING;
        return getHighlighter().getInfo(0, rainbowElement, colorKey);
    }

}