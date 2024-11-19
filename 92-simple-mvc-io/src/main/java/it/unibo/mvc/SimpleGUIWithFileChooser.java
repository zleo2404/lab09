package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {

    private final JFrame frame = this.getFrame();
    private final Controller c = this.getC();
    /**
     * Contructor of the class.
     */
    public SimpleGUIWithFileChooser() {
        super();
        final JPanel panel = this.getPanel(); 
        final JPanel secondPanel = new JPanel(new BorderLayout());
        panel.add(secondPanel, BorderLayout.NORTH);
        final JTextField jTxtFBrowse = new JTextField();
        jTxtFBrowse.setEnabled(false);
        jTxtFBrowse.setText(c.getPath());
        secondPanel.add(jTxtFBrowse, BorderLayout.CENTER);
        final JButton btnBrowse = new JButton("Browse..");
        secondPanel.add(btnBrowse, BorderLayout.LINE_END);
        btnBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser j = new JFileChooser();
                final int result = j.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    c.setCurrentFile(j.getSelectedFile());
                    jTxtFBrowse.setText(c.getPath());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Error has occured");
                }
        } });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }
}
