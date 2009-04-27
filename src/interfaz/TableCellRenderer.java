/*
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package interfaz;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author luis
 */
public class TableCellRenderer extends DefaultTableCellRenderer {

    String imgPath;

    public TableCellRenderer(String path){
        this.imgPath=path;
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                 boolean isSelected, boolean hasFocus,
                                                 int row, int column) {
    ImageIcon icon = new ImageIcon(getClass().getResource(imgPath));
    setText((String)value);
    setIcon(icon);
    setSize(icon.getIconWidth(), icon.getIconHeight());

    return this;
  }

}
