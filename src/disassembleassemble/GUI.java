/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disassembleassemble;

import Listeners.BtnListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author zozulyarv
 */
public class GUI {
    public static final String INPUT_FILENAME = "Введите полное имя файла:";
    private JFrame frame;
    private JPanel textPanel;
    private JPanel btnPanel;
    private JTextField txtField;
    private JButton btnDisassemble;
    private JButton btnAssemble;
    private final JLabel txt = new JLabel(INPUT_FILENAME);
    
    
    
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        GUI gui = new GUI();
        gui.createFrame();
        gui.createPanels();
        gui.createTxtField();
        gui.creatBtns();
        gui.addTxtField();
        gui.addPanels();
        gui.addBtns();
        
        
        gui.frame.setVisible(true);
    }

    private void createFrame() {
        frame = new JFrame("расборка-сборка");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void createPanels() {
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(300, 70));
        textPanel.setBorder(BorderFactory.createEtchedBorder());
        
        btnPanel = new JPanel(new FlowLayout());
        btnPanel.setPreferredSize(new Dimension(300,50));
        btnPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    private void addPanels() {
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(btnPanel, BorderLayout.SOUTH);
    }

    private void createTxtField() {
        txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(250, 30));
    }

    private void addTxtField() {
        textPanel.add(txt);
        textPanel.add(txtField);
    }

    private void creatBtns() {
        Dimension dim = new Dimension(120, 30);
        BtnListener bl = new BtnListener(txtField);
        btnAssemble = new JButton("Собрать");
        btnAssemble.setPreferredSize(dim);
        btnAssemble.addActionListener(bl);
        btnDisassemble = new JButton("Разобрать");
        btnDisassemble.setPreferredSize(dim);
        btnDisassemble.addActionListener(bl);
    }

    private void addBtns() {
        btnPanel.add(btnAssemble);
        btnPanel.add(btnDisassemble);
    }
    
}
