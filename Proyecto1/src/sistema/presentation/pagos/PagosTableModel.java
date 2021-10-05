/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.pagos;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import sistema.logic.Mensualidad;


public class PagosTableModel  extends AbstractTableModel implements TableModel {

     String[] cols ={"Numero","Saldo","Interes","Amortizacion" };
    List<Mensualidad> rows;

    public  PagosTableModel(List<Mensualidad> rows){
        this.rows=rows;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int col){
        return cols[col];
    }

    public int getRowCount() {
        return rows.size();
    }
    
    public Object getValueAt(int row, int col) {
      Mensualidad c = rows.get(row);
        switch (col){
            case 0: return c.getNumero();
            case 1:return c.getSaldo();
            case 2:return c.getInteres();
            case 3:return c.getAmortizacion();
            
            default: return "";
        }
    }    
}

    

