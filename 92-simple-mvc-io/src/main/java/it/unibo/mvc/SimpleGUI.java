package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller c = new Controller();
    private final JPanel panel = new JPanel(new BorderLayout());

    /**
     * Return the frame.
     * 
     * @return Frame
     */
    protected JFrame getFrame() {
        return frame;
    }

    /**
     * Return the controller.
     * 
     * @return Controller
     */
    protected Controller getC() {
        return c;
    }

    /**
     * Return the panel.
     * 
     * @return Panel
     */
    protected JPanel getPanel() {
        return panel;
    }

    /**
     * Contructor of the class.
     * 
     */
    public SimpleGUI() {
        final JTextArea jTxtSave = new JTextArea();
        final JButton jButtonSave = new JButton("Save");
        panel.add(jTxtSave, BorderLayout.CENTER);
        panel.add(jButtonSave, BorderLayout.SOUTH);
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    c.writeString(jTxtSave.getText());
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage()); 
                }
            }
        });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Make the frame fit the resolution of the screen.
     *
     * 
     */
    void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);

        frame.pack();
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
