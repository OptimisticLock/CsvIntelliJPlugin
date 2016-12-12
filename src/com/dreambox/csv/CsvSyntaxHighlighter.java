package com.dreambox.csv;

//import com.intellij.database.extractors.CsvTokens;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.ui.JBColor;
import generated.GeneratedTypes;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class CsvSyntaxHighlighter extends SyntaxHighlighterBase {

	private static final TextAttributesKey[] EMPTY_KEYS = {};
	public static final TextAttributesKey LITERAL = createTextAttributesKey("LITERAL", DefaultLanguageHighlighterColors.CONSTANT);
	public static final TextAttributesKey LITERAL2 = createTextAttributesKey("LITERAL2", DefaultLanguageHighlighterColors.CONSTANT);
	public static final TextAttributesKey COMMA = createTextAttributesKey("COMMA", DefaultLanguageHighlighterColors.COMMA);
	public static final TextAttributesKey LINE = createTextAttributesKey("COMMA", DefaultLanguageHighlighterColors.CONSTANT);
	public static final TextAttributesKey STRING = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey EOL = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.CONSTANT);

	private static final TextAttributesKey[] LITERAL_KEYS = {LITERAL};
	private static final TextAttributesKey[] LITERAL_KEYS2 = {LITERAL2};
	private static final TextAttributesKey[] COMMA_KEYS = {COMMA};
	private static final TextAttributesKey[] LINE_KEYS = {LINE};
	private static final TextAttributesKey[] STRING_KEYS = {STRING};
	private static final TextAttributesKey[] EOL_KEYS = {EOL};

	JBColor[] rainbow = {JBColor.RED, JBColor.ORANGE, JBColor.YELLOW, JBColor.GREEN, JBColor.BLUE, JBColor.pink};
	static int row = 0;
	static int column = 0;

//	private final TokenSet KEYWORDS = TokenSet.create();

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new CsvLexerAdapter();
	}



	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {

		if (tokenType == GeneratedTypes.LITERAL) {
		//	column++;
			return column % 2 == 0 ? LITERAL_KEYS : LITERAL_KEYS2;
		}

		if (tokenType == GeneratedTypes.STRING)
			return STRING_KEYS;

		if (tokenType == GeneratedTypes.COMMA)
			return COMMA_KEYS;

		if (tokenType == GeneratedTypes.CSV_LINE)
			return LINE_KEYS;

		if (tokenType == GeneratedTypes.EOL) {
			row++;
			int colorNo = row % rainbow.length;
			JBColor color = rainbow[colorNo];
			//TextAttributesKey key = new TextAttributesKey("CSV_EOL");
			//key.

			return EOL_KEYS;
		}


		return EMPTY_KEYS;
	}
}
