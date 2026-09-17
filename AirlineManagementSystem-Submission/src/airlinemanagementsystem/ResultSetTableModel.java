package airlinemanagementsystem;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Converts a JDBC result set into a read-only Swing table model. */
public final class ResultSetTableModel extends AbstractTableModel {
    private final String[] columns;
    private final List<Object[]> rows = new ArrayList<>();

    public ResultSetTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metadata = resultSet.getMetaData();
        columns = new String[metadata.getColumnCount()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = metadata.getColumnLabel(i + 1);
        }
        while (resultSet.next()) {
            Object[] row = new Object[columns.length];
            for (int i = 0; i < columns.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            rows.add(row);
        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
}
