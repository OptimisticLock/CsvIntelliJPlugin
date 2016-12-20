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

// TODO see if we can get CsvLine to implement some of these methods so that we can program to interfaces.
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

	public String getString(String columnName) {
		Value value = getValue(columnName);

		if (value == null)
			return null;

		String result = value.getText();

		// Strip result of surrounding single or double quotes, if any
		result = result.replaceAll("^[\"']", "");
		result = result.replaceAll("[\"']$", "");
		return result;
	}

	/**
	 * Gets a column whose value is identical to text. Useful for headers.
	 * @param text
	 * @return column number or -1 if none.
	 * TODO: cache these
	 */
	public int getColumnNo(String text) {
		Value[] values = PsiTreeUtil.getChildrenOfType(this, Value.class);

		for (int columnNo = 0; columnNo < values.length; columnNo++ ) {
			Value value = values[columnNo];
			if (value.getText().equals(text))
				return columnNo;
		}
		return -1;
	}

	public boolean columnExists(String text) {
		int col = getColumnNo(text);
		return col != -1;
	}

	public boolean columnsExist(String... columns) {
		for (String column : columns)
			if (!columnExists(column))
				return false;

		return true;
	}


	public String toString() {
		return super.toString() + " " + getText();
	}

/*	public String toString() {

		String result = "<br><br><b> In file:</b> <font color=red>" + table.getFileName() + "</font>\n<br>";

		for (String header : table.getHeaders()) {
			String value = getString(header).replace(">", "&gt;").replace("<", "&lt;");
			result += "\t<b>" + header + "</b>\t : '<font color=blue>" + value + "</font>'<br>\n";
		}

		return result;
	}
	*/
}
