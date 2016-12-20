package com.dreambox.csv;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import generated.GeneratedParser;
import generated.GeneratedTypes;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class CsvParserDefinition implements ParserDefinition{

    // Load class in order to register it in the list of available languages. A hack.
    private static CsvLanguage language = CsvLanguage.INSTANCE;

    public static final IFileElementType FILE = new IFileElementType(Language.<CsvLanguage>findInstance(CsvLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new CsvLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new GeneratedParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new CsvFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MUST_NOT; // TODO
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return GeneratedTypes.Factory.createElement(node);
    }

}


class CsvLexerAdapter extends FlexAdapter {
    public CsvLexerAdapter() {
        super(new _CsvLexer((Reader) null));

    }
}