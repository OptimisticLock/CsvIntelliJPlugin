package com.dreambox.csv;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class CsvColorSettingsPage implements ColorSettingsPage {

	private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
			new AttributesDescriptor("Literal", CsvSyntaxHighlighter.LITERAL),
			new AttributesDescriptor("Literal2", CsvSyntaxHighlighter.LITERAL2),
			new AttributesDescriptor("Comma", CsvSyntaxHighlighter.COMMA),
			new AttributesDescriptor("Line", CsvSyntaxHighlighter.LINE),
			new AttributesDescriptor("String", CsvSyntaxHighlighter.STRING),
			new AttributesDescriptor("EOL", CsvSyntaxHighlighter.EOL)
	};

	@Nullable
	@Override
	public Icon getIcon() {
		return CsvIcons.FILE;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {

		return new CsvSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return "a, bb, ccc,                    \n\n" +
				"\"I am a string, I have a comma\", d, e \n" +
				"fff, e, ggg                  \n" ;
	}

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "CSV";
	}
}
