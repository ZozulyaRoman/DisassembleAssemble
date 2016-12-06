

package Listeners;

import disassembleassemble.DisAssemble_Assemble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BtnListener implements ActionListener{
    private JTextField field;

    public BtnListener(JTextField field) {
        this.field = field;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)){
            return;
        }
        JButton btn = (JButton)e.getSource();
        String fileName=field.getText();
        
        switch(btn.getActionCommand()){
            case "Собрать":
                try {
                    DisAssemble_Assemble.assemble(fileName);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(field, ex.getMessage());
                    System.exit(1);
                }
                JOptionPane.showMessageDialog(field, "Файл собран!");
            break;
            
            case "Разобрать":
                int subfileSise=0;
                try {
                subfileSise = 1024*Integer.parseInt(JOptionPane.showInputDialog(field, "Укажите размер субфайла, кб"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(field, "Размер файла введен не корректно");
                    System.exit(1);
                }
                try {
                    DisAssemble_Assemble.disassemble(fileName, subfileSise);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(field, ex.getMessage());
                    System.exit(1);
                }
                JOptionPane.showMessageDialog(field, "Файл разобран!");
        
            break;
        }
    }

}
