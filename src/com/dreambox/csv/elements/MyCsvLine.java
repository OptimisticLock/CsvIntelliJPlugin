package com.dreambox.csv.elements;

import com.dreambox.csv.CsvFile;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.util.PsiTreeUtil;
import generated.psi.CsvLine;
import generated.psi.Value;
import generated.psi.impl.CsvLineImpl;
import org.jetbrains.annotations.NotNull;
//import org.jetbrains.dekaf.util.Strings;

import java.util.List;


public class MyCsvLine extends ASTWrapperPsiElement {

	private static final Logger LOG = Logger.getInstance(MyCsvLine.class);

	public MyCsvLine(@NotNull ASTNode node) {
		super(node);
	}

	public Value getValue(String columnName) {
		CsvFile file = (CsvFile) getContainingFile();
		CsvLineImpl header = file.getHeader();

		// TODO cache this
		int columnNo = header.getColumnNo(columnName);

		if (columnNo == -1)
			return null;

		List<Value> values = PsiTreeUtil.getChildrenOfTypeAsList(this, Value.class);
		return values.get(columnNo);
	}

	/**
	 * Gets a column whose value is identical to text. Useful for headers.
	 * @param text
	 * @return column number
	 * TODO: cache these
	 */
	public int getColumnNo(String text) {
	//	CsvFile file = (CsvFile) getContainingFile();
		Value[] values = PsiTreeUtil.getChildrenOfType(this, Value.class);

		for (int columnNo = 0; columnNo < values.length; columnNo++ ) {
			Value value = values[columnNo];
			if (value.getText().equals(text))
				return columnNo;
		}
		return -1;
	}


	public String toString() {
		return super.toString() + " " + getText();
	}
}
