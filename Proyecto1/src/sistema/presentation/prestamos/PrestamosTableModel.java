/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.prestamos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import sistema.logic.Prestamo;

public class PrestamosTableModel extends AbstractTableModel implements TableModel {
    String[] cols ={"Numero","Descrpción","Monto Solicitado","Interes","Plazo","Cuota" };
    List<Prestamo> rows;

    public  PrestamosTableModel(List<Prestamo> rows){
        this.rows=rows;
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int col){
        return cols[col];
    }

    public int getRowCount() {
        return rows.size();
    }
    
    public Object getValueAt(int row, int col) {
        Prestamo c = rows.get(row);
        switch (col){
            case 0: return c.getNumero();
            case 1:return c.getDescripción();
            case 2:return c.getMonto();
            case 3:return c.getInteres();
            case 4:return c.getPlazo();
            case 5:return c.cuota();
            default: return "";
        }
    }    
}
